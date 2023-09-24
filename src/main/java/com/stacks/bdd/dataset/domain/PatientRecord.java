package com.stacks.bdd.dataset.domain;

/**
 * Represents the fields of the record patient.
 * 
 * @author ttrigo
 *
 */
public enum PatientRecord {
	ID_USER("idUser", true),
	ID_CENTER("idCenter", true),
	NAME("firstName", true),
	FIRST_NAME("lastName", true),
	LAST_NAME("lastName2", true),
	GENDER("gender", true),
	DATE_OF_BIRTH("dateOfBirth", true),
	DOCUMENT_TYPE("docType"),
	DOCUMENT("ssn"),
	PHONE("homePhone"),
	MOVIL("cellPhone"),
	EMAIL("email"),
	COVERAJE("mutId"),
	POLIZA_NUMBER("niss"),
	STATUS("status"),
	CP("zip"),
	ADDRESS("street"),
	CONSENT_TYPE("consentType"),
	EHR_CONSENT_TYPE("EHRConsentType"),
	EHR_CHOSEN_OPTION("EHRConsentChosenOption");
	
	private String urlParameterName;
	
	private Boolean mandatory;
	
	private PatientRecord(String urlParameterName) {
		this.urlParameterName = urlParameterName;
	}
	
	private PatientRecord(String urlParameterName, Boolean mandatory) {
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
