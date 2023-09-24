package com.stacks.bdd.dataset.responseprocessor.json;

import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.stacks.bdd.dataset.encrypter.DatasetEncrypter;
import com.stacks.bdd.dataset.responseprocessor.DatasetResponseProcessor;

/**
 * Process the content of an appointment response.
 * <p>It processes the content as a JSON.</p>
 * 
 * @author ttrigo
 *
 */
public class AppointmentJsonResponseProcessor extends BasicJsonResponseProcessor implements DatasetResponseProcessor {

	private static final Logger logger = Logger.getLogger(AppointmentJsonResponseProcessor.class);
	
	private static final String JSON_KEY_RETURN_CODE = "returnCode";
	private static final String JSON_KEY_TOTAL_COUNT = "totalCount";
	private static final String JSON_KEY_ITEMS = "items";
	private static final String JSON_KEY_ID_CITA = "idCita";
	private static final String JSON_KEY_ESTADO = "estado";
	private static final String JSON_KEY_FECHA_HORA = "fechaHora";
	private static final String JSON_KEY_ERROR_TEXT = "errorText";
	
	private DatasetEncrypter encrypter;
	
	public AppointmentJsonResponseProcessor(DatasetEncrypter encrypter) {
		this.encrypter = encrypter;
	}
	
    /**
     * {@inheritDoc} 
     */
	public void processResponse(InputStream is) throws IOException {
		JSONObject json = parseResponse(is);
		
		int success = encrypter.decryptInteger(json.getString(JSON_KEY_RETURN_CODE));
		if (success == 0) {
			int totalCount = encrypter.decryptInteger(json.getString(JSON_KEY_TOTAL_COUNT));
			if (totalCount > 0) {
				JSONObject cita = new JSONObject(json.getJSONArray(JSON_KEY_ITEMS).getJSONObject(0), new String[] { JSON_KEY_ID_CITA, JSON_KEY_ESTADO, JSON_KEY_FECHA_HORA });
				String appointmentId = encrypter.decrypt(cita.getString(JSON_KEY_ID_CITA));
				String status = encrypter.decrypt(cita.getString(JSON_KEY_ESTADO));
				String date = encrypter.decrypt(cita.getString(JSON_KEY_FECHA_HORA));
				
				String message = String.format("Appointment created with idCita, estado and fechaHora: %s, %s, %s", appointmentId, status, date);
				logger.info(message);
			}
		} else {
			String returnCode = encrypter.decrypt(json.getString(JSON_KEY_RETURN_CODE));
			String errorText = encrypter.decrypt(json.getString(JSON_KEY_ERROR_TEXT));
			
			logger.info("Error creating an appointment: " + returnCode + " -> " + errorText);
		}
	}

}
