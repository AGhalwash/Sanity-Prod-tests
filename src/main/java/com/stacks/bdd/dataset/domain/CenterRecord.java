package com.stacks.bdd.dataset.domain;

/**
 * Represents the fields of the record center.
 * 
 * @author ttrigo
 *
 */
public enum CenterRecord {
	ACTION("action", true),
	USER_ID_NUMBER("userIdNumber", true),
	CENTER_CODE("centerCode", false),
	CENTER_DESCRIPTION("centerDescription", true),
	CENTER_ADDRESS("centerAddress"),
	CENTER_SPECIALITY("centerSpecialtyCode"),
	LICENSE_CODE("licenseCode", true),
	CLIENT_ID("centerClientId",false),
	USER_EMAIL("userEmail", true),
	USER_NAME("userName", true),
	USER_SURNAME("userSurname", true),
	USER_TELEPHONE("userTelephone", true),
	USER_SEX("userSex", true),
	FORM_OF_ADDRESS("formOfAddress", true);
	
	private String urlParameterName;
	
	private Boolean mandatory;
	
	private CenterRecord(String urlParameterName) {
		this.urlParameterName = urlParameterName;
	}
	
	private CenterRecord(String urlParameterName, Boolean mandatory) {
		this.urlParameterName = urlParameterName;
		this.mandatory = mandatory;
	}

	public String getUrlParameterName() {
		return urlParameterName;
	}
	
	public Boolean isMandatory() {
		return mandatory != null && mandatory;
	}
	
}
