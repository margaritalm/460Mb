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

package com.liferay.portlet.journal.action;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.ProcessingInstruction;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalTemplate;
import com.liferay.portlet.journal.model.JournalTemplateConstants;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalTemplateLocalServiceUtil;
import com.liferay.portlet.journal.util.JournalUtil;
import com.liferay.util.servlet.ServletResponseUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Raymond Aug??
 */
public class GetArticleAction extends Action {

	public ActionForward execute(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)
		throws Exception {

		try {
			long groupId = ParamUtil.getLong(request, "groupId");
			String articleId =  ParamUtil.getString(request, "articleId");

			String languageId = LanguageUtil.getLanguageId(request);

			JournalArticle article =
				JournalArticleLocalServiceUtil.getLatestArticle(
					groupId, articleId, WorkflowConstants.STATUS_APPROVED);

			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
				WebKeys.THEME_DISPLAY);

			Map<String, String> tokens = JournalUtil.getTokens(
				groupId, themeDisplay);

			String xml = article.getContentByLocale(languageId);

			Document doc = SAXReaderUtil.read(xml);

			Element root = doc.getRootElement();

			addProcessingInstructions(doc, request, themeDisplay, article);

			JournalUtil.addAllReservedEls(root, tokens, article);

			xml = JournalUtil.formatXML(doc);

			String contentType = ContentTypes.TEXT_XML_UTF8;

			String fileName = null;
			byte[] bytes = xml.getBytes();

			ServletResponseUtil.sendFile(
				request, response, fileName, bytes, contentType);

			return null;
		}
		catch (Exception e) {
			PortalUtil.sendError(e, request, response);

			return null;
		}
	}

	protected void addProcessingInstructions(
		Document doc, HttpServletRequest request, ThemeDisplay themeDisplay,
		JournalArticle article) {

		// Add style sheets in the reverse order that they appear in the
		// document

		// Portal CSS

		String url =
			PortalUtil.getStaticResourceURL(
				request,
				themeDisplay.getCDNHost() + themeDisplay.getPathContext() +
					"/html/portal/css.jsp");

		Map<String, String> arguments = new LinkedHashMap<String, String>();

		arguments.put("type", "text/css");
		arguments.put("href", url);
		arguments.put("title", "portal css");
		arguments.put("alternate", "yes");

		addStyleSheet(doc, url, arguments);

		// Theme CSS

		url = PortalUtil.getStaticResourceURL(
			request, themeDisplay.getPathThemeCss() + "/main.css");

		arguments.clear();

		arguments.put("type", "text/css");
		arguments.put("href", url);
		arguments.put("title", "theme css");

		addStyleSheet(doc, url, arguments);

		// XSL template

		String templateId = article.getTemplateId();

		if (Validator.isNotNull(templateId)) {
			JournalTemplate template = null;

			try {
				template = JournalTemplateLocalServiceUtil.getTemplate(
					article.getGroupId(), templateId);

				if (Validator.equals(
						template.getLangType(),
						JournalTemplateConstants.LANG_TYPE_XSL)) {

					url =
						themeDisplay.getPathMain() +
							"/journal/get_template?groupId=" +
								article.getGroupId() + "&templateId=" +
									templateId;

					arguments.clear();

					arguments.put("type", "text/xsl");
					arguments.put("href", url);
					arguments.put("title", "xsl");

					addStyleSheet(doc, url, arguments);
				}
			}
			catch (Exception e) {
			}
		}
	}

	protected void addStyleSheet(
		Document doc, String url, Map<String, String> arguments) {

		List<Node> content = doc.content();

		ProcessingInstruction processingInstruction =
			SAXReaderUtil.createProcessingInstruction(
				"xml-stylesheet", arguments);

		content.add(0, processingInstruction);
	}

}