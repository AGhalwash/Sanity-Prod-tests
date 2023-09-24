package com.stacks.bdd.dataset.domain;

/**
 * Represents the fields of the parameter cita.
 * 
 * @author ttrigo
 *
 */
public enum CitaParameter {
	CITA_ID_CITA("idCita"),
	CITA_HORA("fechaHora"),
	CITA_OBSERVACIONES("observaciones"),
	CITA_ESTADO("estado"),
	AGENDA_ID_AGENDA("idAgenda"),
	AGENDA_DESC_AGENDA("descAgenda"),
	AGENDA_OBSERVACIONES("observaciones"),
	CENTRO_ID_CENTRO("idCentro"),
	CENTRO_DESC_CENTRO("descCentro"),
	CENTRO_DIRECCION("direccion"),
	CENTRO_TELEFONO("telefono"),
	ESPECIALIDAD_ID_ESPECIALIDAD("idEspecialidad"),
	ESPECIALIDAD_DESC_ESPECIALIDAD("descEspecialidad"),
	PACIENTE_DOCUMENTO("documento"),
	PACIENTE_NUM_POLIZA("numPoliza"),
	PACIENTE_NOMBRE("nombre"),
	PACIENTE_PRIMER_APELLIDO("primerApellido"),
	PACIENTE_SEGUNDO_APELLIDO("segundoApellido"),
	PACIENTE_SEXO("sexo"),
	PACIENTE_FECHA_NACIMIENTO("fechaNacimiento"),
	PACIENTE_TELEFONO("telefono"),
	PACIENTE_MOVIL("movil");
	
	private String urlParameterName;
	
	/**
	 * Constructor.
	 * 
	 * @param urlParameterName the url parameter name
	 */
	private CitaParameter(String urlParameterName) {
		this.urlParameterName = urlParameterName;
	}

	public String getUrlParameterName() {
		return urlParameterName;
	}

}
