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

package com.liferay.portal.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.permission.PermissionChecker;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletPermissionUtil {

	public static void check(
			PermissionChecker permissionChecker, String portletId,
			String actionId)
		throws PortalException, SystemException {

		getPortletPermission().check(permissionChecker, portletId, actionId);
	}

	public static void check(
			PermissionChecker permissionChecker, long plid, String portletId,
			String actionId)
		throws PortalException, SystemException {

		getPortletPermission().check(
			permissionChecker, plid, portletId, actionId);
	}

	public static void check(
			PermissionChecker permissionChecker, long plid, String portletId,
			String actionId, boolean strict)
		throws PortalException, SystemException {

		getPortletPermission().check(
			permissionChecker, plid, portletId, actionId, strict);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, String portletId,
			String actionId)
		throws PortalException, SystemException {

		return getPortletPermission().contains(
			permissionChecker, portletId, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long plid, String portletId,
			String actionId)
		throws PortalException, SystemException {

		return getPortletPermission().contains(
			permissionChecker, plid, portletId, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long plid, String portletId,
			String actionId, boolean strict)
		throws PortalException, SystemException {

		return getPortletPermission().contains(
			permissionChecker, plid, portletId, actionId, strict);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long plid, Portlet portlet,
			String actionId)
		throws PortalException, SystemException {

		return getPortletPermission().contains(
			permissionChecker, plid, portlet, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long plid, Portlet portlet,
			String actionId, boolean strict)
		throws PortalException, SystemException {

		return getPortletPermission().contains(
			permissionChecker, plid, portlet, actionId, strict);
	}

	public static PortletPermission getPortletPermission() {
		return _portletPermission;
	}

	public static String getPrimaryKey(long plid, String portletId) {
		return getPortletPermission().getPrimaryKey(plid, portletId);
	}

	public static boolean hasLayoutManagerPermission(
		String portletId, String actionId) {

		return getPortletPermission().hasLayoutManagerPermission(
			portletId, actionId);
	}

	public void setPortletPermission(PortletPermission portletPermission) {
		_portletPermission = portletPermission;
	}

	private static PortletPermission _portletPermission;

}