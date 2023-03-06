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

package com.liferay.portlet.journalcontentsearch.util;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portlet.journal.service.JournalContentSearchLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Chow
 * @author Raymond Augé
 */
public class ContentHits {

	public void recordHits(
			Hits hits, long groupId, boolean privateLayout, int start, int end)
		throws Exception {

		// This can later be optimized according to LEP-915.

		List<Document> docs = new ArrayList<Document>();
		List<Float> scores = new ArrayList<Float>();

		for (int i = 0; i < hits.getLength(); i++) {
			Document doc = hits.doc(i);

			String articleId = doc.get(Field.ENTRY_CLASS_PK);
			long articleGroupId = GetterUtil.getLong(doc.get(Field.GROUP_ID));

			if (JournalContentSearchLocalServiceUtil.getLayoutIdsCount(
					groupId, privateLayout, articleId) > 0) {

				docs.add(hits.doc(i));
				scores.add(hits.score(i));
			}
			else if (!isShowListed() && (articleGroupId == groupId)) {
				docs.add(hits.doc(i));
				scores.add(hits.score(i));
			}
		}

		int length = docs.size();

		hits.setLength(length);

		if (end > length) {
			end = length;
		}

		docs = docs.subList(start, end);

		hits.setDocs(docs.toArray(new Document[docs.size()]));
		hits.setScores(scores.toArray(new Float[docs.size()]));

		hits.setSearchTime(
			(float)(System.currentTimeMillis() - hits.getStart()) /
				Time.SECOND);
	}

	public boolean isShowListed() {
		return _showListed;
	}

	public void setShowListed(boolean showListed) {
		_showListed = showListed;
	}

	private boolean _showListed = true;

}