package com.stacks.bdd.dataset.domain;

/**
 * Represents the fields of the record user.
 * 
 * @author ttrigo
 *
 */
public enum ReportTemplateRecord {
	ACCEPT("Accept"),
	ACCEPT_LANGUAGE("Accept-Language"),
	AUTHORIZATION("Authorization"),
	CONTENT_TYPE("Content-Type"),
	PAYLOAD("payload"),
	SEC_FETCH_MODE("Sec-Fetch-Mode"),
	SEC_FETCH_SITE("Sec-Fetch-Site");

	private String urlParameterName;

	private ReportTemplateRecord(String urlParameterName) {
		this.urlParameterName = urlParameterName;
	}

	public String getParameterName() {
		return urlParameterName;
	}
}
