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

package com.liferay.portlet.wiki.model;

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the WikiNode service. Represents a row in the &quot;WikiNode&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.wiki.model.impl.WikiNodeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.wiki.model.impl.WikiNodeImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a wiki node model instance should use the {@link WikiNode} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WikiNode
 * @see com.liferay.portlet.wiki.model.impl.WikiNodeImpl
 * @see com.liferay.portlet.wiki.model.impl.WikiNodeModelImpl
 * @generated
 */
public interface WikiNodeModel extends BaseModel<WikiNode> {
	/**
	 * Gets the primary key of this wiki node.
	 *
	 * @return the primary key of this wiki node
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this wiki node
	 *
	 * @param pk the primary key of this wiki node
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the uuid of this wiki node.
	 *
	 * @return the uuid of this wiki node
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this wiki node.
	 *
	 * @param uuid the uuid of this wiki node
	 */
	public void setUuid(String uuid);

	/**
	 * Gets the node id of this wiki node.
	 *
	 * @return the node id of this wiki node
	 */
	public long getNodeId();

	/**
	 * Sets the node id of this wiki node.
	 *
	 * @param nodeId the node id of this wiki node
	 */
	public void setNodeId(long nodeId);

	/**
	 * Gets the group id of this wiki node.
	 *
	 * @return the group id of this wiki node
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this wiki node.
	 *
	 * @param groupId the group id of this wiki node
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the company id of this wiki node.
	 *
	 * @return the company id of this wiki node
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this wiki node.
	 *
	 * @param companyId the company id of this wiki node
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user id of this wiki node.
	 *
	 * @return the user id of this wiki node
	 */
	public long getUserId();

	/**
	 * Sets the user id of this wiki node.
	 *
	 * @param userId the user id of this wiki node
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this wiki node.
	 *
	 * @return the user uuid of this wiki node
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this wiki node.
	 *
	 * @param userUuid the user uuid of this wiki node
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the user name of this wiki node.
	 *
	 * @return the user name of this wiki node
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this wiki node.
	 *
	 * @param userName the user name of this wiki node
	 */
	public void setUserName(String userName);

	/**
	 * Gets the create date of this wiki node.
	 *
	 * @return the create date of this wiki node
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this wiki node.
	 *
	 * @param createDate the create date of this wiki node
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets the modified date of this wiki node.
	 *
	 * @return the modified date of this wiki node
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this wiki node.
	 *
	 * @param modifiedDate the modified date of this wiki node
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Gets the name of this wiki node.
	 *
	 * @return the name of this wiki node
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this wiki node.
	 *
	 * @param name the name of this wiki node
	 */
	public void setName(String name);

	/**
	 * Gets the description of this wiki node.
	 *
	 * @return the description of this wiki node
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this wiki node.
	 *
	 * @param description the description of this wiki node
	 */
	public void setDescription(String description);

	/**
	 * Gets the last post date of this wiki node.
	 *
	 * @return the last post date of this wiki node
	 */
	public Date getLastPostDate();

	/**
	 * Sets the last post date of this wiki node.
	 *
	 * @param lastPostDate the last post date of this wiki node
	 */
	public void setLastPostDate(Date lastPostDate);

	/**
	 * Gets a copy of this wiki node as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public WikiNode toEscapedModel();

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

	public int compareTo(WikiNode wikiNode);

	public int hashCode();

	public String toString();

	public String toXmlString();
}