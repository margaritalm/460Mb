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

package com.liferay.portal.workflow.kaleo.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the KaleoNotification service. Represents a row in the &quot;KaleoNotification&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.workflow.kaleo.model.impl.KaleoNotificationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.workflow.kaleo.model.impl.KaleoNotificationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KaleoNotification
 * @see com.liferay.portal.workflow.kaleo.model.impl.KaleoNotificationImpl
 * @see com.liferay.portal.workflow.kaleo.model.impl.KaleoNotificationModelImpl
 * @generated
 */
public interface KaleoNotificationModel extends BaseModel<KaleoNotification>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a kaleo notification model instance should use the {@link KaleoNotification} interface instead.
	 */

	/**
	 * Returns the primary key of this kaleo notification.
	 *
	 * @return the primary key of this kaleo notification
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this kaleo notification.
	 *
	 * @param primaryKey the primary key of this kaleo notification
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the kaleo notification ID of this kaleo notification.
	 *
	 * @return the kaleo notification ID of this kaleo notification
	 */
	public long getKaleoNotificationId();

	/**
	 * Sets the kaleo notification ID of this kaleo notification.
	 *
	 * @param kaleoNotificationId the kaleo notification ID of this kaleo notification
	 */
	public void setKaleoNotificationId(long kaleoNotificationId);

	/**
	 * Returns the group ID of this kaleo notification.
	 *
	 * @return the group ID of this kaleo notification
	 */

	public long getGroupId();

	/**
	 * Sets the group ID of this kaleo notification.
	 *
	 * @param groupId the group ID of this kaleo notification
	 */

	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this kaleo notification.
	 *
	 * @return the company ID of this kaleo notification
	 */

	public long getCompanyId();

	/**
	 * Sets the company ID of this kaleo notification.
	 *
	 * @param companyId the company ID of this kaleo notification
	 */

	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this kaleo notification.
	 *
	 * @return the user ID of this kaleo notification
	 */

	public long getUserId();

	/**
	 * Sets the user ID of this kaleo notification.
	 *
	 * @param userId the user ID of this kaleo notification
	 */

	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this kaleo notification.
	 *
	 * @return the user uuid of this kaleo notification
	 */

	public String getUserUuid();

	/**
	 * Sets the user uuid of this kaleo notification.
	 *
	 * @param userUuid the user uuid of this kaleo notification
	 */

	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this kaleo notification.
	 *
	 * @return the user name of this kaleo notification
	 */
	@AutoEscape

	public String getUserName();

	/**
	 * Sets the user name of this kaleo notification.
	 *
	 * @param userName the user name of this kaleo notification
	 */

	public void setUserName(String userName);

	/**
	 * Returns the create date of this kaleo notification.
	 *
	 * @return the create date of this kaleo notification
	 */

	public Date getCreateDate();

	/**
	 * Sets the create date of this kaleo notification.
	 *
	 * @param createDate the create date of this kaleo notification
	 */

	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this kaleo notification.
	 *
	 * @return the modified date of this kaleo notification
	 */

	public Date getModifiedDate();

	/**
	 * Sets the modified date of this kaleo notification.
	 *
	 * @param modifiedDate the modified date of this kaleo notification
	 */

	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the kaleo class name of this kaleo notification.
	 *
	 * @return the kaleo class name of this kaleo notification
	 */
	@AutoEscape
	public String getKaleoClassName();

	/**
	 * Sets the kaleo class name of this kaleo notification.
	 *
	 * @param kaleoClassName the kaleo class name of this kaleo notification
	 */
	public void setKaleoClassName(String kaleoClassName);

	/**
	 * Returns the kaleo class p k of this kaleo notification.
	 *
	 * @return the kaleo class p k of this kaleo notification
	 */
	public long getKaleoClassPK();

	/**
	 * Sets the kaleo class p k of this kaleo notification.
	 *
	 * @param kaleoClassPK the kaleo class p k of this kaleo notification
	 */
	public void setKaleoClassPK(long kaleoClassPK);

	/**
	 * Returns the kaleo definition ID of this kaleo notification.
	 *
	 * @return the kaleo definition ID of this kaleo notification
	 */
	public long getKaleoDefinitionId();

	/**
	 * Sets the kaleo definition ID of this kaleo notification.
	 *
	 * @param kaleoDefinitionId the kaleo definition ID of this kaleo notification
	 */
	public void setKaleoDefinitionId(long kaleoDefinitionId);

	/**
	 * Returns the kaleo node name of this kaleo notification.
	 *
	 * @return the kaleo node name of this kaleo notification
	 */
	@AutoEscape
	public String getKaleoNodeName();

	/**
	 * Sets the kaleo node name of this kaleo notification.
	 *
	 * @param kaleoNodeName the kaleo node name of this kaleo notification
	 */
	public void setKaleoNodeName(String kaleoNodeName);

	/**
	 * Returns the name of this kaleo notification.
	 *
	 * @return the name of this kaleo notification
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this kaleo notification.
	 *
	 * @param name the name of this kaleo notification
	 */
	public void setName(String name);

	/**
	 * Returns the description of this kaleo notification.
	 *
	 * @return the description of this kaleo notification
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this kaleo notification.
	 *
	 * @param description the description of this kaleo notification
	 */
	public void setDescription(String description);

	/**
	 * Returns the execution type of this kaleo notification.
	 *
	 * @return the execution type of this kaleo notification
	 */
	@AutoEscape
	public String getExecutionType();

	/**
	 * Sets the execution type of this kaleo notification.
	 *
	 * @param executionType the execution type of this kaleo notification
	 */
	public void setExecutionType(String executionType);

	/**
	 * Returns the template of this kaleo notification.
	 *
	 * @return the template of this kaleo notification
	 */
	@AutoEscape
	public String getTemplate();

	/**
	 * Sets the template of this kaleo notification.
	 *
	 * @param template the template of this kaleo notification
	 */
	public void setTemplate(String template);

	/**
	 * Returns the template language of this kaleo notification.
	 *
	 * @return the template language of this kaleo notification
	 */
	@AutoEscape
	public String getTemplateLanguage();

	/**
	 * Sets the template language of this kaleo notification.
	 *
	 * @param templateLanguage the template language of this kaleo notification
	 */
	public void setTemplateLanguage(String templateLanguage);

	/**
	 * Returns the notification types of this kaleo notification.
	 *
	 * @return the notification types of this kaleo notification
	 */
	@AutoEscape
	public String getNotificationTypes();

	/**
	 * Sets the notification types of this kaleo notification.
	 *
	 * @param notificationTypes the notification types of this kaleo notification
	 */
	public void setNotificationTypes(String notificationTypes);


	public boolean isNew();


	public void setNew(boolean n);


	public boolean isCachedModel();


	public void setCachedModel(boolean cachedModel);


	public boolean isEscapedModel();


	public Serializable getPrimaryKeyObj();


	public void setPrimaryKeyObj(Serializable primaryKeyObj);


	public ExpandoBridge getExpandoBridge();


	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);


	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);


	public void setExpandoBridgeAttributes(ServiceContext serviceContext);


	public Object clone();


	public int compareTo(KaleoNotification kaleoNotification);


	public int hashCode();


	public CacheModel<KaleoNotification> toCacheModel();


	public KaleoNotification toEscapedModel();


	public KaleoNotification toUnescapedModel();


	public String toString();


	public String toXmlString();
}