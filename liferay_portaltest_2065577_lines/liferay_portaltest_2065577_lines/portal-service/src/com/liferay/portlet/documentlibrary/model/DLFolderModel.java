/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

package com.liferay.portlet.documentlibrary.model;

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the DLFolder service. Represents a row in the &quot;DLFolder&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.documentlibrary.model.impl.DLFolderModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.documentlibrary.model.impl.DLFolderImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a d l folder model instance should use the {@link DLFolder} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DLFolder
 * @see com.liferay.portlet.documentlibrary.model.impl.DLFolderImpl
 * @see com.liferay.portlet.documentlibrary.model.impl.DLFolderModelImpl
 * @generated
 */
public interface DLFolderModel extends BaseModel<DLFolder> {
	/**
	 * Gets the primary key of this d l folder.
	 *
	 * @return the primary key of this d l folder
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this d l folder
	 *
	 * @param pk the primary key of this d l folder
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the uuid of this d l folder.
	 *
	 * @return the uuid of this d l folder
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this d l folder.
	 *
	 * @param uuid the uuid of this d l folder
	 */
	public void setUuid(String uuid);

	/**
	 * Gets the folder id of this d l folder.
	 *
	 * @return the folder id of this d l folder
	 */
	public long getFolderId();

	/**
	 * Sets the folder id of this d l folder.
	 *
	 * @param folderId the folder id of this d l folder
	 */
	public void setFolderId(long folderId);

	/**
	 * Gets the group id of this d l folder.
	 *
	 * @return the group id of this d l folder
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this d l folder.
	 *
	 * @param groupId the group id of this d l folder
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the company id of this d l folder.
	 *
	 * @return the company id of this d l folder
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this d l folder.
	 *
	 * @param companyId the company id of this d l folder
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user id of this d l folder.
	 *
	 * @return the user id of this d l folder
	 */
	public long getUserId();

	/**
	 * Sets the user id of this d l folder.
	 *
	 * @param userId the user id of this d l folder
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this d l folder.
	 *
	 * @return the user uuid of this d l folder
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this d l folder.
	 *
	 * @param userUuid the user uuid of this d l folder
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the user name of this d l folder.
	 *
	 * @return the user name of this d l folder
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this d l folder.
	 *
	 * @param userName the user name of this d l folder
	 */
	public void setUserName(String userName);

	/**
	 * Gets the create date of this d l folder.
	 *
	 * @return the create date of this d l folder
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this d l folder.
	 *
	 * @param createDate the create date of this d l folder
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets the modified date of this d l folder.
	 *
	 * @return the modified date of this d l folder
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this d l folder.
	 *
	 * @param modifiedDate the modified date of this d l folder
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Gets the parent folder id of this d l folder.
	 *
	 * @return the parent folder id of this d l folder
	 */
	public long getParentFolderId();

	/**
	 * Sets the parent folder id of this d l folder.
	 *
	 * @param parentFolderId the parent folder id of this d l folder
	 */
	public void setParentFolderId(long parentFolderId);

	/**
	 * Gets the name of this d l folder.
	 *
	 * @return the name of this d l folder
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this d l folder.
	 *
	 * @param name the name of this d l folder
	 */
	public void setName(String name);

	/**
	 * Gets the description of this d l folder.
	 *
	 * @return the description of this d l folder
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this d l folder.
	 *
	 * @param description the description of this d l folder
	 */
	public void setDescription(String description);

	/**
	 * Gets the last post date of this d l folder.
	 *
	 * @return the last post date of this d l folder
	 */
	public Date getLastPostDate();

	/**
	 * Sets the last post date of this d l folder.
	 *
	 * @param lastPostDate the last post date of this d l folder
	 */
	public void setLastPostDate(Date lastPostDate);

	/**
	 * Gets a copy of this d l folder as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public DLFolder toEscapedModel();

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(DLFolder dlFolder);

	public int hashCode();

	public String toString();

	public String toXmlString();
}