package com.stacks.bdd.dataset.responseprocessor.json;

import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.stacks.bdd.dataset.responseprocessor.DatasetResponseProcessor;

/**
 * Process the content of a patient response.
 * <p>It processes the content as a JSON.</p>
 * 
 * @author ttrigo
 *
 */
public class PatientJsonResponseProcessor extends BasicJsonResponseProcessor implements DatasetResponseProcessor {

	private static final Logger logger = Logger.getLogger(PatientJsonResponseProcessor.class);
	
	private static final String JSON_KEY_SUCCESS = "success";
	private static final String JSON_KEY_DATA_RESULT = "dataResult";
	private static final String JSON_KEY_ID_PATIENT = "idPatient";
	private static final String JSON_KEY_ERROR_CODE = "errorCode";
	private static final String JSON_KEY_ERROR_MESSAGE = "errorMessage";
	
    /**
     * {@inheritDoc} 
     */
	public void processResponse(InputStream is) throws IOException {
		JSONObject json = parseResponse(is);
		
		boolean success = json.has(JSON_KEY_SUCCESS) && json.getBoolean(JSON_KEY_SUCCESS);
		if (success) {
			JSONObject patient = json.getJSONObject(JSON_KEY_DATA_RESULT);
			int patientId = patient.getInt(JSON_KEY_ID_PATIENT);
			
			logger.info("Patient created with idPatient: " + patientId);
		} else {
			int errorCode = json.getInt(JSON_KEY_ERROR_CODE);
			String errorMessage = json.getString(JSON_KEY_ERROR_MESSAGE);
			
			logger.info("Error creating a patient: " + errorCode + " -> " + errorMessage);
		}
	}

}
