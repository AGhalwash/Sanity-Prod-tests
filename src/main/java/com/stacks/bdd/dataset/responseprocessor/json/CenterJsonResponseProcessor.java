package com.stacks.bdd.dataset.responseprocessor.json;

import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.stacks.bdd.dataset.responseprocessor.DatasetResponseProcessor;

/**
 * Process the content of a center response.
 * <p>It processes the content as a JSON.</p>
 * 
 * @author ttrigo
 *
 */
public class CenterJsonResponseProcessor extends BasicJsonResponseProcessor implements DatasetResponseProcessor {

	private static final Logger logger = Logger.getLogger(CenterJsonResponseProcessor.class);
	
	private static final String JSON_KEY_RETURN_CODE = "returnCode";
	private static final String JSON_KEY_LOGIN = "login";
	private static final String JSON_KEY_PASSWORD = "password";
	private static final String JSON_KEY_ERROR_TEXT = "errorText";
	
    /**
     * {@inheritDoc} 
     */
	public void processResponse(InputStream is) throws IOException {
		JSONObject json = parseResponse(is);
		
		boolean success = json.has(JSON_KEY_RETURN_CODE) && json.getInt(JSON_KEY_RETURN_CODE) == 0;
		if (success) {
			String login = json.getString(JSON_KEY_LOGIN);
			String pwd = json.getString(JSON_KEY_PASSWORD);
			
			logger.info("Center created with user/pwd: " + login + " / " + pwd);
		} else {
			int returnCode = json.getInt(JSON_KEY_RETURN_CODE);
			String errorText = json.getString(JSON_KEY_ERROR_TEXT);
			
			logger.info("Error creating a center: " + returnCode + " -> " + errorText);
		}
	}

}
