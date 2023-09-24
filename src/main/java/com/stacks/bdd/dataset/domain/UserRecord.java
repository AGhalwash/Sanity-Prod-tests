package com.stacks.bdd.dataset.domain;

/**
 * Represents the fields of the record user.
 * 
 * @author ttrigo
 *
 */
public enum UserRecord {
	ID_USER("idUser"),
	NOMBRE("nombre", true),
	APELLIDO1("apellido1", true),
	APELLIDO2("apellido2"),
	SEXO("sexo", true),
	TIPO_PROFESIONAL("tipoProfesional", true),
	NACIMIENTO("nacimiento", true),
	EMAIL("email"),
	USERNAME("userName", true),
	PASSWORD("password", true),
	TELEFONO1("telefono1"),
	DOCUMENTO("documento"),
	ID_CENTRO("idCentro", true),
	CODIGO_PERFIL("codigoPerfil", true),
	ID_ESPECIALIDAD("idEspecialidad", true),
	NUMERO_COLEGIADO("numeroColegiado");
	
	private String urlParameterName;
	
	private Boolean mandatory;
	
	private UserRecord(String urlParameterName) {
		this.urlParameterName = urlParameterName;
	}
	
	private UserRecord(String urlParameterName, Boolean mandatory) {
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
