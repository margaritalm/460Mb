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

package com.liferay.portal.workflow.kaleo.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.User;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.model.KaleoNode;
import com.liferay.portal.workflow.kaleo.model.KaleoNodeModel;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the KaleoNode service. Represents a row in the &quot;KaleoNode&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portal.workflow.kaleo.model.KaleoNodeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KaleoNodeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KaleoNodeImpl
 * @see com.liferay.portal.workflow.kaleo.model.KaleoNode
 * @see com.liferay.portal.workflow.kaleo.model.KaleoNodeModel
 * @generated
 */
public class KaleoNodeModelImpl extends BaseModelImpl<KaleoNode>
	implements KaleoNodeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a kaleo node model instance should use the {@link com.liferay.portal.workflow.kaleo.model.KaleoNode} interface instead.
	 */
	public static final String TABLE_NAME = "KaleoNode";
	public static final Object[][] TABLE_COLUMNS = {
			{ "kaleoNodeId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "kaleoDefinitionId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "metadata", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "type_", Types.VARCHAR },
			{ "initial_", Types.BOOLEAN },
			{ "terminal", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table KaleoNode (kaleoNodeId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(200) null,createDate DATE null,modifiedDate DATE null,kaleoDefinitionId LONG,name VARCHAR(200) null,metadata STRING null,description STRING null,type_ VARCHAR(20) null,initial_ BOOLEAN,terminal BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table KaleoNode";
	public static final String ORDER_BY_JPQL = " ORDER BY kaleoNode.kaleoNodeId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY KaleoNode.kaleoNodeId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.portal.workflow.kaleo.model.KaleoNode"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.portal.workflow.kaleo.model.KaleoNode"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.portal.workflow.kaleo.model.KaleoNode"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long KALEODEFINITIONID_COLUMN_BITMASK = 2L;
	public static long KALEONODEID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.portal.workflow.kaleo.model.KaleoNode"));

	public KaleoNodeModelImpl() {
	}


	public long getPrimaryKey() {
		return _kaleoNodeId;
	}


	public void setPrimaryKey(long primaryKey) {
		setKaleoNodeId(primaryKey);
	}


	public Serializable getPrimaryKeyObj() {
		return _kaleoNodeId;
	}


	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}


	public Class<?> getModelClass() {
		return KaleoNode.class;
	}


	public String getModelClassName() {
		return KaleoNode.class.getName();
	}


	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("kaleoNodeId", getKaleoNodeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("kaleoDefinitionId", getKaleoDefinitionId());
		attributes.put("name", getName());
		attributes.put("metadata", getMetadata());
		attributes.put("description", getDescription());
		attributes.put("type", getType());
		attributes.put("initial", getInitial());
		attributes.put("terminal", getTerminal());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}


	public void setModelAttributes(Map<String, Object> attributes) {
		Long kaleoNodeId = (Long)attributes.get("kaleoNodeId");

		if (kaleoNodeId != null) {
			setKaleoNodeId(kaleoNodeId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long kaleoDefinitionId = (Long)attributes.get("kaleoDefinitionId");

		if (kaleoDefinitionId != null) {
			setKaleoDefinitionId(kaleoDefinitionId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String metadata = (String)attributes.get("metadata");

		if (metadata != null) {
			setMetadata(metadata);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Boolean initial = (Boolean)attributes.get("initial");

		if (initial != null) {
			setInitial(initial);
		}

		Boolean terminal = (Boolean)attributes.get("terminal");

		if (terminal != null) {
			setTerminal(terminal);
		}
	}


	public long getKaleoNodeId() {
		return _kaleoNodeId;
	}


	public void setKaleoNodeId(long kaleoNodeId) {
		_columnBitmask = -1L;

		_kaleoNodeId = kaleoNodeId;
	}


	public long getGroupId() {
		return _groupId;
	}


	public void setGroupId(long groupId) {
		_groupId = groupId;
	}


	public long getCompanyId() {
		return _companyId;
	}


	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}


	public long getUserId() {
		return _userId;
	}


	public void setUserId(long userId) {
		_userId = userId;
	}


	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}


	public void setUserUuid(String userUuid) {
	}


	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}


	public void setUserName(String userName) {
		_userName = userName;
	}


	public Date getCreateDate() {
		return _createDate;
	}


	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}


	public Date getModifiedDate() {
		return _modifiedDate;
	}


	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}


	public long getKaleoDefinitionId() {
		return _kaleoDefinitionId;
	}


	public void setKaleoDefinitionId(long kaleoDefinitionId) {
		_columnBitmask |= KALEODEFINITIONID_COLUMN_BITMASK;

		if (!_setOriginalKaleoDefinitionId) {
			_setOriginalKaleoDefinitionId = true;

			_originalKaleoDefinitionId = _kaleoDefinitionId;
		}

		_kaleoDefinitionId = kaleoDefinitionId;
	}

	public long getOriginalKaleoDefinitionId() {
		return _originalKaleoDefinitionId;
	}


	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}


	public void setName(String name) {
		_name = name;
	}


	public String getMetadata() {
		if (_metadata == null) {
			return StringPool.BLANK;
		}
		else {
			return _metadata;
		}
	}


	public void setMetadata(String metadata) {
		_metadata = metadata;
	}


	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}


	public void setDescription(String description) {
		_description = description;
	}


	public String getType() {
		if (_type == null) {
			return StringPool.BLANK;
		}
		else {
			return _type;
		}
	}


	public void setType(String type) {
		_type = type;
	}


	public boolean getInitial() {
		return _initial;
	}


	public boolean isInitial() {
		return _initial;
	}


	public void setInitial(boolean initial) {
		_initial = initial;
	}


	public boolean getTerminal() {
		return _terminal;
	}


	public boolean isTerminal() {
		return _terminal;
	}


	public void setTerminal(boolean terminal) {
		_terminal = terminal;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}


	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			KaleoNode.class.getName(), getPrimaryKey());
	}


	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}


	public KaleoNode toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (KaleoNode)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}


	public Object clone() {
		KaleoNodeImpl kaleoNodeImpl = new KaleoNodeImpl();

		kaleoNodeImpl.setKaleoNodeId(getKaleoNodeId());
		kaleoNodeImpl.setGroupId(getGroupId());
		kaleoNodeImpl.setCompanyId(getCompanyId());
		kaleoNodeImpl.setUserId(getUserId());
		kaleoNodeImpl.setUserName(getUserName());
		kaleoNodeImpl.setCreateDate(getCreateDate());
		kaleoNodeImpl.setModifiedDate(getModifiedDate());
		kaleoNodeImpl.setKaleoDefinitionId(getKaleoDefinitionId());
		kaleoNodeImpl.setName(getName());
		kaleoNodeImpl.setMetadata(getMetadata());
		kaleoNodeImpl.setDescription(getDescription());
		kaleoNodeImpl.setType(getType());
		kaleoNodeImpl.setInitial(getInitial());
		kaleoNodeImpl.setTerminal(getTerminal());

		kaleoNodeImpl.resetOriginalValues();

		return kaleoNodeImpl;
	}


	public int compareTo(KaleoNode kaleoNode) {
		int value = 0;

		if (getKaleoNodeId() < kaleoNode.getKaleoNodeId()) {
			value = -1;
		}
		else if (getKaleoNodeId() > kaleoNode.getKaleoNodeId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}


	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KaleoNode)) {
			return false;
		}

		KaleoNode kaleoNode = (KaleoNode)obj;

		long primaryKey = kaleoNode.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}


	public int hashCode() {
		return (int)getPrimaryKey();
	}


	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}


	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}


	public void resetOriginalValues() {
		KaleoNodeModelImpl kaleoNodeModelImpl = this;

		kaleoNodeModelImpl._originalCompanyId = kaleoNodeModelImpl._companyId;

		kaleoNodeModelImpl._setOriginalCompanyId = false;

		kaleoNodeModelImpl._originalKaleoDefinitionId = kaleoNodeModelImpl._kaleoDefinitionId;

		kaleoNodeModelImpl._setOriginalKaleoDefinitionId = false;

		kaleoNodeModelImpl._columnBitmask = 0;
	}


	public CacheModel<KaleoNode> toCacheModel() {
		KaleoNodeCacheModel kaleoNodeCacheModel = new KaleoNodeCacheModel();

		kaleoNodeCacheModel.kaleoNodeId = getKaleoNodeId();

		kaleoNodeCacheModel.groupId = getGroupId();

		kaleoNodeCacheModel.companyId = getCompanyId();

		kaleoNodeCacheModel.userId = getUserId();

		kaleoNodeCacheModel.userName = getUserName();

		String userName = kaleoNodeCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			kaleoNodeCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			kaleoNodeCacheModel.createDate = createDate.getTime();
		}
		else {
			kaleoNodeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			kaleoNodeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			kaleoNodeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		kaleoNodeCacheModel.kaleoDefinitionId = getKaleoDefinitionId();

		kaleoNodeCacheModel.name = getName();

		String name = kaleoNodeCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			kaleoNodeCacheModel.name = null;
		}

		kaleoNodeCacheModel.metadata = getMetadata();

		String metadata = kaleoNodeCacheModel.metadata;

		if ((metadata != null) && (metadata.length() == 0)) {
			kaleoNodeCacheModel.metadata = null;
		}

		kaleoNodeCacheModel.description = getDescription();

		String description = kaleoNodeCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			kaleoNodeCacheModel.description = null;
		}

		kaleoNodeCacheModel.type = getType();

		String type = kaleoNodeCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			kaleoNodeCacheModel.type = null;
		}

		kaleoNodeCacheModel.initial = getInitial();

		kaleoNodeCacheModel.terminal = getTerminal();

		return kaleoNodeCacheModel;
	}


	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{kaleoNodeId=");
		sb.append(getKaleoNodeId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", kaleoDefinitionId=");
		sb.append(getKaleoDefinitionId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", metadata=");
		sb.append(getMetadata());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", initial=");
		sb.append(getInitial());
		sb.append(", terminal=");
		sb.append(getTerminal());
		sb.append("}");

		return sb.toString();
	}


	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.workflow.kaleo.model.KaleoNode");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>kaleoNodeId</column-name><column-value><![CDATA[");
		sb.append(getKaleoNodeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kaleoDefinitionId</column-name><column-value><![CDATA[");
		sb.append(getKaleoDefinitionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>metadata</column-name><column-value><![CDATA[");
		sb.append(getMetadata());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>initial</column-name><column-value><![CDATA[");
		sb.append(getInitial());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>terminal</column-name><column-value><![CDATA[");
		sb.append(getTerminal());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = KaleoNode.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			KaleoNode.class
		};
	private long _kaleoNodeId;
	private long _groupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _kaleoDefinitionId;
	private long _originalKaleoDefinitionId;
	private boolean _setOriginalKaleoDefinitionId;
	private String _name;
	private String _metadata;
	private String _description;
	private String _type;
	private boolean _initial;
	private boolean _terminal;
	private long _columnBitmask;
	private KaleoNode _escapedModel;
}