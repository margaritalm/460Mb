/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.sync.service.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.sync.model.SyncConstants;
import com.liferay.sync.model.SyncDLObject;
import com.liferay.sync.service.base.SyncDLObjectLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * @author Michael Young
 * @author Dennis Ju
 */
public class SyncDLObjectLocalServiceImpl
	extends SyncDLObjectLocalServiceBaseImpl {


	public SyncDLObject addSyncDLObject(
			long companyId, long modifiedTime, long repositoryId,
			long parentFolderId, String name, String extension, String mimeType,
			String description, String changeLog, String extraSettings,
			String version, long size, String checksum, String event,
			Date lockExpirationDate, long lockUserId, String lockUserName,
			String type, long typePK, String typeUuid)
		throws PortalException {

		if (!isDefaultRepository(parentFolderId)) {
			return null;
		}

		SyncDLObject syncDLObject = syncDLObjectPersistence.fetchByT_T(
			type, typePK);

		if (syncDLObject == null) {
			long syncDLObjectId = counterLocalService.increment();

			syncDLObject = syncDLObjectPersistence.create(syncDLObjectId);

			syncDLObject.setCompanyId(companyId);
			syncDLObject.setCreateTime(modifiedTime);
			syncDLObject.setRepositoryId(repositoryId);
			syncDLObject.setType(type);
			syncDLObject.setTypePK(typePK);
			syncDLObject.setTypeUuid(typeUuid);
		}
		else if (syncDLObject.getModifiedTime() >= modifiedTime) {
			return null;
		}
		else if (type.equals(SyncConstants.TYPE_FILE)) {
			SyncDLObject pwcSyncDLObject = syncDLObjectPersistence.fetchByT_T(
				SyncConstants.TYPE_PRIVATE_WORKING_COPY, typePK);

			if (pwcSyncDLObject != null) {
				DLFileEntry dlFileEntry =
					dlFileEntryLocalService.fetchDLFileEntry(typePK);

				if ((dlFileEntry != null) && !dlFileEntry.isCheckedOut()) {
					syncDLObjectPersistence.remove(pwcSyncDLObject);
				}
			}
		}

		syncDLObject.setModifiedTime(modifiedTime);
		syncDLObject.setParentFolderId(parentFolderId);
		syncDLObject.setName(name);
		syncDLObject.setExtension(extension);
		syncDLObject.setMimeType(mimeType);
		syncDLObject.setDescription(description);
		syncDLObject.setChangeLog(changeLog);
		syncDLObject.setExtraSettings(extraSettings);
		syncDLObject.setVersion(version);
		syncDLObject.setSize(size);
		syncDLObject.setChecksum(checksum);
		syncDLObject.setEvent(event);
		syncDLObject.setLockExpirationDate(lockExpirationDate);
		syncDLObject.setLockUserId(lockUserId);
		syncDLObject.setLockUserName(lockUserName);

		return syncDLObjectPersistence.update(syncDLObject);
	}


	public void deleteSyncDLObjects(String version, String type) {
		syncDLObjectPersistence.removeByV_T(version, type);
	}


	public long getLatestModifiedTime() {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SyncDLObject.class, SyncDLObject.class.getClassLoader());

		Projection projection = ProjectionFactoryUtil.max("modifiedTime");

		dynamicQuery.setProjection(projection);

		List<Long> modifiedTimes = syncDLObjectPersistence.findWithDynamicQuery(
			dynamicQuery);

		if (modifiedTimes.isEmpty() || (modifiedTimes.get(0) == 0)) {
			return System.currentTimeMillis();
		}

		return modifiedTimes.get(0);
	}

	protected boolean isDefaultRepository(long folderId)
		throws PortalException {

		if (folderId == DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) {
			return true;
		}

		Folder folder = dlAppLocalService.getFolder(folderId);

		return folder.isDefaultRepository();
	}

}