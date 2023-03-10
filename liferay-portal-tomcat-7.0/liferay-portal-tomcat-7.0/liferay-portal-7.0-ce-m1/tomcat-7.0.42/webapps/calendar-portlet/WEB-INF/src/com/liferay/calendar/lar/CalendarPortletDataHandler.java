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

package com.liferay.calendar.lar;

import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.model.CalendarNotificationTemplate;
import com.liferay.calendar.model.CalendarResource;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.calendar.service.CalendarLocalServiceUtil;
import com.liferay.calendar.service.CalendarNotificationTemplateLocalServiceUtil;
import com.liferay.calendar.service.CalendarResourceLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.lar.BasePortletDataHandler;
import com.liferay.portal.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.lar.PortletDataHandlerBoolean;
import com.liferay.portal.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.util.PortalUtil;

import java.util.List;

import javax.portlet.PortletPreferences;

/**
 * @author Marcellus Tavares
 * @author Andrea Di Giorgi
 */
public class CalendarPortletDataHandler extends BasePortletDataHandler {

	public static final String NAMESPACE = "calendar";

	public CalendarPortletDataHandler() {
		setDataLocalized(true);
		setDeletionSystemEventStagedModelTypes(
			new StagedModelType(Calendar.class),
			new StagedModelType(CalendarBooking.class),
			new StagedModelType(CalendarNotificationTemplate.class),
			new StagedModelType(CalendarResource.class));
		setExportControls(
			new PortletDataHandlerBoolean(
				NAMESPACE, "calendars", true, false, null,
				Calendar.class.getName()),
			new PortletDataHandlerBoolean(
				NAMESPACE, "calendar-resources", true, false, null,
				CalendarResource.class.getName()),
			new PortletDataHandlerBoolean(
				NAMESPACE, "calendar-bookings", true, false, null,
				CalendarBooking.class.getName()),
			new PortletDataHandlerBoolean(
				NAMESPACE, "calendar-notification-templates", true, false,
				new PortletDataHandlerBoolean[] {
					new PortletDataHandlerBoolean(
						NAMESPACE, "referenced-content")
				},
				CalendarNotificationTemplate.class.getName())
		);
	}


	protected PortletPreferences doDeleteData(
			PortletDataContext portletDataContext, String portletId,
			PortletPreferences portletPreferences)
		throws Exception {

		if (portletDataContext.addPrimaryKey(
				CalendarPortletDataHandler.class, "deleteData")) {

			return portletPreferences;
		}

		CalendarResourceLocalServiceUtil.deleteCalendarResources(
			portletDataContext.getScopeGroupId());

		return portletPreferences;
	}


	protected String doExportData(
			PortletDataContext portletDataContext, String portletId,
			PortletPreferences portletPreferences)
		throws Exception {

		portletDataContext.addPortletPermissions(RESOURCE_NAME);

		Element rootElement = addExportDataRootElement(portletDataContext);

		if (portletDataContext.getBooleanParameter(NAMESPACE, "calendars")) {
			ActionableDynamicQuery calendarActionableDynamicQuery =
				CalendarLocalServiceUtil.getExportActionableDynamicQuery(
					portletDataContext);

			calendarActionableDynamicQuery.performActions();

			ActionableDynamicQuery calendarResourceActionableDynamicQuery =
				getCalendarResourceActionableDynamicQuery(
					portletDataContext,
					StagedModelType.REFERRER_CLASS_NAME_ID_ALL);

			calendarResourceActionableDynamicQuery.performActions();
		}

		if (portletDataContext.getBooleanParameter(
				NAMESPACE, "calendar-bookings")) {

			ActionableDynamicQuery calendarBookingActionableDynamicQuery =
				CalendarLocalServiceUtil.getExportActionableDynamicQuery(
					portletDataContext);

			calendarBookingActionableDynamicQuery.performActions();
		}

		if (portletDataContext.getBooleanParameter(
				NAMESPACE, "calendar-notification-templates")) {

			ActionableDynamicQuery
				calendarNotificationTemplateActionableDynamicQuery =
					CalendarNotificationTemplateLocalServiceUtil.
						getExportActionableDynamicQuery(portletDataContext);

			calendarNotificationTemplateActionableDynamicQuery.performActions();
		}

		return getExportDataRootElementString(rootElement);
	}


	protected PortletPreferences doImportData(
			PortletDataContext portletDataContext, String portletId,
			PortletPreferences portletPreferences, String data)
		throws Exception {

		portletDataContext.importPortletPermissions(RESOURCE_NAME);

		if (portletDataContext.getBooleanParameter(NAMESPACE, "calendars")) {
			Element calendarsElement =
				portletDataContext.getImportDataGroupElement(Calendar.class);

			List<Element> calendarElements = calendarsElement.elements();

			for (Element calendarElement : calendarElements) {
				StagedModelDataHandlerUtil.importStagedModel(
					portletDataContext, calendarElement);
			}

			Element calendarResourcesElement =
				portletDataContext.getImportDataGroupElement(
					CalendarResource.class);

			List<Element> calendarResourceElements =
				calendarResourcesElement.elements();

			for (Element calendarResourceElement : calendarResourceElements) {
				StagedModelDataHandlerUtil.importStagedModel(
					portletDataContext, calendarResourceElement);
			}
		}

		if (portletDataContext.getBooleanParameter(
				NAMESPACE, "calendar-bookings")) {

			Element calendarBookingsElement =
				portletDataContext.getImportDataGroupElement(
					CalendarBooking.class);

			List<Element> calendarBookingElements =
				calendarBookingsElement.elements();

			for (Element calendarBookingElement : calendarBookingElements) {
				StagedModelDataHandlerUtil.importStagedModel(
					portletDataContext, calendarBookingElement);
			}
		}

		if (portletDataContext.getBooleanParameter(
				NAMESPACE, "calendar-notification-templates")) {

			Element calendarNotificationTemplatesElement =
				portletDataContext.getImportDataGroupElement(
					CalendarNotificationTemplate.class);

			List<Element> calendarNotificationTemplateElements =
				calendarNotificationTemplatesElement.elements();

			for (Element calendarNotificationTemplateElement :
					calendarNotificationTemplateElements) {

				StagedModelDataHandlerUtil.importStagedModel(
					portletDataContext, calendarNotificationTemplateElement);
			}
		}

		return portletPreferences;
	}


	protected void doPrepareManifestSummary(
			PortletDataContext portletDataContext,
			PortletPreferences portletPreferences)
		throws Exception {

		ActionableDynamicQuery calendarActionableDynamicQuery =
			CalendarLocalServiceUtil.getExportActionableDynamicQuery(
				portletDataContext);

		calendarActionableDynamicQuery.performCount();

		ActionableDynamicQuery calendarBookingActionableDynamicQuery =
			CalendarBookingLocalServiceUtil.getExportActionableDynamicQuery(
				portletDataContext);

		calendarBookingActionableDynamicQuery.performCount();

		ActionableDynamicQuery
			calendarNotificationTemplateActionableDynamicQuery =
				CalendarNotificationTemplateLocalServiceUtil.
					getExportActionableDynamicQuery(portletDataContext);

		calendarNotificationTemplateActionableDynamicQuery.performCount();

		ActionableDynamicQuery calendarResourceActionableDynamicQuery =
			getCalendarResourceActionableDynamicQuery(
				portletDataContext,
				PortalUtil.getClassNameId(CalendarResource.class));

		calendarResourceActionableDynamicQuery.performCount();
	}

	protected ActionableDynamicQuery getCalendarResourceActionableDynamicQuery(
		PortletDataContext portletDataContext, long referrerClassNameId) {

		ExportActionableDynamicQuery exportActionableDynamicQuery =
			CalendarResourceLocalServiceUtil.getExportActionableDynamicQuery(
				portletDataContext);

		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(CalendarResource.class),
				referrerClassNameId));

		return exportActionableDynamicQuery;
	}

	protected static final String RESOURCE_NAME =
		"com.liferay.portlet.calendar";

}