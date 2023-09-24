package com.stacks.bdd.dataset.urlbuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.json.JSONObject;

import com.stacks.bdd.dataset.domain.AppointmentRecord;
import com.stacks.bdd.dataset.domain.CitaParameter;
import com.stacks.bdd.dataset.domain.DatasetQueryRecord;
import com.stacks.bdd.dataset.encrypter.DatasetEncrypter;
import com.stacks.bdd.dataset.exception.MandatoryQueryParameterException;
import com.stacks.bdd.dataset.reader.DatasetDataReader;

/**
 * Builds appointment's dataset {@code URL}s.
 * 
 * @author ttrigo
 *
 */
public class AppointmentURLBuilder extends BasicGetURLBuilder {

	private static final String DATA_FILE_PATH = "AssignAppointments.csv";
	private static final String PATIENT_ENDPOINT = "asignarCitaCW.htm" ;
	
	private DatasetEncrypter encrypter;
	
	public AppointmentURLBuilder(DatasetDataReader reader, DatasetEncrypter encrypter) {
		super(reader, DATA_FILE_PATH);
		this.encrypter = encrypter;
	}
	
    /**
     * {@inheritDoc}
     */
	@Override
	public String buildPath() {
		return PATIENT_ENDPOINT;
	}

    /**
     * {@inheritDoc}
     * 
     * <p>Uses the field {@code urlParameter} of the {@link AppointmentRecord} as a parameter name.</p>
     * <p>Uses the record obtained form a file as a parameter value.</p>
     * <p>Parameter cita is mapped in {@link CitaParameter}.</p>
     */
	@Override
	public String buildQuery(DatasetQueryRecord record) throws MandatoryQueryParameterException {
		StringBuilder sb = new StringBuilder();
		
		for (AppointmentRecord appointment : AppointmentRecord.values()) {
			sb.append(appointment.ordinal() == 0 ? "?" : "&");
			sb.append(appointment.getUrlParameterName());
			sb.append("=");
			if (appointment.equals(AppointmentRecord.CITA)) {
				sb.append(buildCita(record));
			} else {
				sb.append(encrypter.encrypt(record.get(appointment)));
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * Build parameter cita as JSON.
	 * 
	 * <p>
	 * Example:
	 * {
	 * \"idCita\":\"QqgeO2uAywq5cZAW76dK0Q==\",
	 * \"fechaHora\":\"jSroKpnTXREO4gSw1JjgOQ==\",
	 * \"observaciones\":\"N8a3thctnEqPnRwPjdj+DA==\", \"estado\":\"\",
	 * \"agenda\":{\"idAgenda\":\"lu2PhK+8JCuIJCtF5hcZHQ==\",
	 * \"descAgenda\":\"otCrl+a6MZWn0HHB6kyDuw==\",
	 * \"observaciones\":\"TD+UsvzrOtev7JBmbuz0Xg==\",
	 * \"centro\":{\"idCentro\":\"nM4ZoARJZsEnCfDmOLzsqg==\",
	 * \"descCentro\":\"v8iD0DyWDk+td8I8iAN/0g==\",
	 * \"direccion\":\"kq3Z9XCz0EHWYEx3lxtPqNoNbdw0fm1CJrrH+wBdDYc=\",
	 * \"telefono\":\"yerOTdyJhC7xIVJifMVFHA==\"},
	 * \"especialidad\":{\"idEspecialidad\":\"2M9E7qOsevBC6d/NkKdjlQ==\",
	 * \"descEspecialidad\":\"UZFZZDRz6mkkvn/BUMkmEg==\",},},
	 * \"paciente\":{\"documento\":\"iLpYKRfrHeuTJuQlIaX1IA==\",
	 * \"numPoliza\":\"MmjyAusjrcTf80/zWQKIsA==\",
	 * \"nombre\":\"NV8Skv2c4DTFqwzYvQlLSw==\",
	 * \"primerApellido\":\"TTF+lLNUWL/Ay4iGglRAoQ==\",
	 * \"segundoApellido\":\"SI18nel4PQRglv2w+MrxGQ==\",
	 * \"sexo\":\"YLkOHBoOOaSgu4qpkXw0Bg==\",
	 * \"fechaNacimiento\":\"qKwVBoZJpQfZLufs0WFTsA==\",
	 * \"telefono\":\"i9MHWNLZ+Fxk47xQJHAIkQ==\",
	 * \"movil\":\"i9MHWNLZ+Fxk47xQJHAIkQ==\" }
	 * }
	 * </p>
	 * @param record the data necessary to build the query. 
	 * @return parameter cita as String.
	 */
	private String buildCita(DatasetQueryRecord record) {
		// cita
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.parse(record.get(CitaParameter.CITA_HORA));
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		String fechaHora = dateTime.format(formatter);
		fechaHora = encrypter.encrypt(fechaHora);
		
		String idCita = encrypter.encrypt(record.get(CitaParameter.CITA_ID_CITA));
		String citaObservaciones = encrypter.encrypt(record.get(CitaParameter.CITA_OBSERVACIONES));
		
		JSONObject cita = new JSONObject();
		cita.put(CitaParameter.CITA_ID_CITA.getUrlParameterName(), idCita);
		cita.put(CitaParameter.CITA_HORA.getUrlParameterName(), fechaHora);
		cita.put(CitaParameter.CITA_OBSERVACIONES.getUrlParameterName(), citaObservaciones);
		cita.put(CitaParameter.CITA_ESTADO.getUrlParameterName(), "");

		// agenda
		String idAgenda = encrypter.encrypt(record.get(CitaParameter.AGENDA_ID_AGENDA));
		String descAgenda = encrypter.encrypt(record.get(CitaParameter.AGENDA_DESC_AGENDA));
		String agendaObservaciones = encrypter.encrypt(record.get(CitaParameter.AGENDA_OBSERVACIONES));
		
		JSONObject agenda = new JSONObject();
		agenda.put(CitaParameter.AGENDA_ID_AGENDA.getUrlParameterName(), idAgenda);
		agenda.put(CitaParameter.AGENDA_DESC_AGENDA.getUrlParameterName(), descAgenda);
		agenda.put(CitaParameter.AGENDA_OBSERVACIONES.getUrlParameterName(), agendaObservaciones);

		// centro
		String idCentro = encrypter.encrypt(record.get(CitaParameter.CENTRO_ID_CENTRO));
		String descCentro = encrypter.encrypt(record.get(CitaParameter.CENTRO_DESC_CENTRO));
		String direccion = encrypter.encrypt(record.get(CitaParameter.CENTRO_DIRECCION));
		String centroTelefono = encrypter.encrypt(record.get(CitaParameter.CENTRO_TELEFONO));
		
		JSONObject centro = new JSONObject();
		centro.put(CitaParameter.CENTRO_ID_CENTRO.getUrlParameterName(), idCentro);
		centro.put(CitaParameter.CENTRO_DESC_CENTRO.getUrlParameterName(), descCentro);
		centro.put(CitaParameter.CENTRO_DIRECCION.getUrlParameterName(), direccion);
		centro.put(CitaParameter.CENTRO_TELEFONO.getUrlParameterName(), centroTelefono);

		// especialidad
		String idEspecialidad = encrypter.encrypt(record.get(CitaParameter.ESPECIALIDAD_ID_ESPECIALIDAD));
		String descEspecialidad = encrypter.encrypt(record.get(CitaParameter.ESPECIALIDAD_DESC_ESPECIALIDAD));
		
		JSONObject especialidad = new JSONObject();
		especialidad.put(CitaParameter.ESPECIALIDAD_ID_ESPECIALIDAD.getUrlParameterName(), idEspecialidad);
		especialidad.put(CitaParameter.ESPECIALIDAD_DESC_ESPECIALIDAD.getUrlParameterName(), descEspecialidad);

		// paciente
		String documento = encrypter.encrypt(record.get(CitaParameter.PACIENTE_DOCUMENTO));
		String numPoliza = encrypter.encrypt(record.get(CitaParameter.PACIENTE_NUM_POLIZA));
		String nombre = encrypter.encrypt(record.get(CitaParameter.PACIENTE_NOMBRE));
		String primerApellido = encrypter.encrypt(record.get(CitaParameter.PACIENTE_PRIMER_APELLIDO));
		String segundoApellido = encrypter.encrypt(record.get(CitaParameter.PACIENTE_SEGUNDO_APELLIDO));
		String sexo = encrypter.encrypt(record.get(CitaParameter.PACIENTE_SEXO));
		String fechaNacimiento = encrypter.encrypt(record.get(CitaParameter.PACIENTE_FECHA_NACIMIENTO));
		String pacienteTelefono = encrypter.encrypt(record.get(CitaParameter.PACIENTE_TELEFONO));
		String movil = encrypter.encrypt(record.get(CitaParameter.PACIENTE_MOVIL));
		
		JSONObject paciente = new JSONObject();
		paciente.put(CitaParameter.PACIENTE_DOCUMENTO.getUrlParameterName(), documento);
		paciente.put(CitaParameter.PACIENTE_NUM_POLIZA.getUrlParameterName(), numPoliza);
		paciente.put(CitaParameter.PACIENTE_NOMBRE.getUrlParameterName(), nombre);
		paciente.put(CitaParameter.PACIENTE_PRIMER_APELLIDO.getUrlParameterName(), primerApellido);
		paciente.put(CitaParameter.PACIENTE_SEGUNDO_APELLIDO.getUrlParameterName(), segundoApellido);
		paciente.put(CitaParameter.PACIENTE_SEXO.getUrlParameterName(), sexo);
		paciente.put(CitaParameter.PACIENTE_FECHA_NACIMIENTO.getUrlParameterName(), fechaNacimiento);
		paciente.put(CitaParameter.PACIENTE_TELEFONO.getUrlParameterName(), pacienteTelefono);
		paciente.put(CitaParameter.PACIENTE_MOVIL.getUrlParameterName(), movil);
		
		agenda.put("centro", centro);
		agenda.put("especialidad", especialidad);
		cita.put("agenda", agenda);
		cita.put("paciente", paciente);

		return cita.toString();
	}

}
