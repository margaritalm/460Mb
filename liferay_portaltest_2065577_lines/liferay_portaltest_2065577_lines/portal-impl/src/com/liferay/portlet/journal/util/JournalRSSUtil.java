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

package com.liferay.portlet.journal.util;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Image;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.imagegallery.model.IGImage;
import com.liferay.portlet.imagegallery.service.IGImageLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalFeed;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.util.comparator.ArticleDisplayDateComparator;
import com.liferay.portlet.journal.util.comparator.ArticleModifiedDateComparator;

import com.sun.syndication.feed.synd.SyndEnclosure;
import com.sun.syndication.feed.synd.SyndEnclosureImpl;
import com.sun.syndication.feed.synd.SyndLink;
import com.sun.syndication.feed.synd.SyndLinkImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Raymond Aug??
 */
public class JournalRSSUtil {

	public static List<JournalArticle> getArticles(JournalFeed feed)
		throws SystemException {

		long companyId = feed.getCompanyId();
		long groupId = feed.getGroupId();
		String articleId = null;
		Double version = null;
		String title = null;
		String description = null;
		String content = null;

		String type = feed.getType();

		if (Validator.isNull(type)) {
			type = null;
		}

		String structureId = feed.getStructureId();

		if (Validator.isNull(structureId)) {
			structureId = null;
		}

		String templateId = feed.getTemplateId();

		if (Validator.isNull(templateId)) {
			templateId = null;
		}

		Date displayDateGT = null;
		Date displayDateLT = new Date();
		int status = WorkflowConstants.STATUS_APPROVED;
		Date reviewDate = null;
		boolean andOperator = true;
		int start = 0;
		int end = feed.getDelta();

		String orderByCol = feed.getOrderByCol();
		String orderByType = feed.getOrderByType();
		boolean orderByAsc = orderByType.equals("asc");

		OrderByComparator obc = new ArticleModifiedDateComparator(orderByAsc);

		if (orderByCol.equals("display-date")) {
			obc = new ArticleDisplayDateComparator(orderByAsc);
		}

		return JournalArticleLocalServiceUtil.search(
			companyId, groupId, articleId, version, title, description, content,
			type, structureId, templateId, displayDateGT, displayDateLT,
			status, reviewDate, andOperator, start, end, obc);
	}

	public static List<SyndEnclosure> getDLEnclosures(
		String portalURL, String url) {

		List<SyndEnclosure> enclosures = new ArrayList<SyndEnclosure>();

		DLFileEntry fileEntry = getDLFileEntry(url);

		if (fileEntry != null) {
			SyndEnclosure enclosure = new SyndEnclosureImpl();

			enclosure.setLength(fileEntry.getSize());

			enclosure.setType(
				MimeTypesUtil.getContentType(fileEntry.getTitle()));

			enclosure.setUrl(portalURL + url);

			enclosures.add(enclosure);
		}

		return enclosures;
	}

	public static DLFileEntry getDLFileEntry(String url) {
		DLFileEntry fileEntry = null;

		String queryString = HttpUtil.getQueryString(url);

		Map<String, String[]> parameters = HttpUtil.parameterMapFromString(
			queryString);

		if (parameters.containsKey("folderId") &&
			parameters.containsKey("name")) {

			try {
				long groupId = GetterUtil.getLong(
					parameters.get("groupId")[0]);
				long folderId = GetterUtil.getLong(
					parameters.get("folderId")[0]);
				String name = parameters.get("name")[0];

				fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(
					groupId, folderId, name);
			}
			catch (Exception e) {
				if (_log.isWarnEnabled()) {
					_log.warn(e, e);
				}
			}
		}
		else if (parameters.containsKey("uuid") &&
				 parameters.containsKey("groupId")) {

			try {
				String uuid = parameters.get("uuid")[0];
				long groupId = GetterUtil.getLong(parameters.get("groupId")[0]);

				fileEntry =
					DLFileEntryLocalServiceUtil.getFileEntryByUuidAndGroupId(
						uuid, groupId);
			}
			catch (Exception e) {
				if (_log.isWarnEnabled()) {
					_log.warn(e, e);
				}
			}
		}

		return fileEntry;
	}

	public static List<SyndLink> getDLLinks(String portalURL, String url) {
		List<SyndLink> links = new ArrayList<SyndLink>();

		DLFileEntry fileEntry = getDLFileEntry(url);

		if (fileEntry != null) {
			SyndLink link = new SyndLinkImpl();

			link.setHref(portalURL + url);

			link.setLength(fileEntry.getSize());

			link.setRel("enclosure");

			link.setType(MimeTypesUtil.getContentType(fileEntry.getTitle()));

			links.add(link);
		}

		return links;
	}

	public static List<SyndEnclosure> getIGEnclosures(
		String portalURL, String url) {

		List<SyndEnclosure> enclosures = new ArrayList<SyndEnclosure>();

		Image image = getImage(url);

		if (image != null) {
			SyndEnclosure enclosure = new SyndEnclosureImpl();

			enclosure.setLength(image.getSize());

			enclosure.setType(
				MimeTypesUtil.getContentType("*." + image.getType()));

			enclosure.setUrl(portalURL + url);

			enclosures.add(enclosure);
		}

		return enclosures;
	}

	public static List<SyndLink> getIGLinks(String portalURL, String url) {
		List<SyndLink> links = new ArrayList<SyndLink>();

		Image image = getImage(url);

		if (image != null) {
			SyndLink link = new SyndLinkImpl();

			link.setHref(portalURL + url);

			link.setLength(image.getSize());

			link.setRel("enclosure");

			link.setType(
				MimeTypesUtil.getContentType("*." + image.getType()));

			links.add(link);
		}

		return links;
	}

	public static Image getImage(String url) {
		Image image = null;

		String queryString = HttpUtil.getQueryString(url);

		Map<String, String[]> parameters = HttpUtil.parameterMapFromString(
			queryString);

		if (parameters.containsKey("image_id") ||
			parameters.containsKey("img_id") ||
			parameters.containsKey("i_id")) {

			try {
				long imageId = 0;

				if (parameters.containsKey("image_id")) {
					imageId = GetterUtil.getLong(parameters.get("image_id")[0]);
				}
				else if (parameters.containsKey("img_id")) {
					imageId = GetterUtil.getLong(parameters.get("img_id")[0]);
				}
				else if (parameters.containsKey("i_id")) {
					imageId = GetterUtil.getLong(parameters.get("i_id")[0]);
				}

				image = ImageLocalServiceUtil.getImage(imageId);
			}
			catch (Exception e) {
				if (_log.isWarnEnabled()) {
					_log.warn(e, e);
				}
			}
		}
		else if (parameters.containsKey("uuid") &&
				 parameters.containsKey("groupId")) {

			try {
				String uuid = parameters.get("uuid")[0];
				long groupId = GetterUtil.getLong(parameters.get("groupId")[0]);

				IGImage igImage =
					IGImageLocalServiceUtil.getImageByUuidAndGroupId(
						uuid, groupId);

				image = ImageLocalServiceUtil.getImage(
					igImage.getLargeImageId());
			}
			catch (Exception e) {
				if (_log.isWarnEnabled()) {
					_log.warn(e, e);
				}
			}
		}

		return image;
	}

	private static Log _log = LogFactoryUtil.getLog(JournalRSSUtil.class);

}