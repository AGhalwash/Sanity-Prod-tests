package com.stacks.bdd.dataset.domain;

/**
 * Represents the fields of the record appointment.
 * 
 * @author ttrigo
 *
 */
public enum AppointmentRecord {
	ID_USUARIO("idUsuario"),
	CITA("cita");
	
	private String urlParameterName;
	
	private AppointmentRecord(String urlParameterName) {
		this.urlParameterName = urlParameterName;
	}

	public String getUrlParameterName() {
		return urlParameterName;
	}

}
