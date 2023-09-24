package com.stacks.bdd.dataset.responseprocessor.text;

import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;

import com.stacks.bdd.dataset.responseprocessor.DatasetResponseProcessor;

/**
 * Process the content of a user response.
 * <p>It processes the content as a plain text.</p>
 * 
 * @author ttrigo
 *
 */
public class UserPlainTextResponseProcessor extends BasicPlainTextResponseProcessor implements DatasetResponseProcessor {

	private static final Logger logger = Logger.getLogger(UserPlainTextResponseProcessor.class);
	
	private static final String PLAIN_TEXT_RETURN_CODE = "returnCode";
	private static final String PLAIN_TEXT_ERROR_TEXT = "errorText";
	
    /**
     * {@inheritDoc} 
     */
	@Override
	public void processResponse(InputStream is) throws IOException {
		String responseContent = parseResponse(is);
		
		boolean success = !responseContent.contains(PLAIN_TEXT_RETURN_CODE) && !responseContent.contains(PLAIN_TEXT_ERROR_TEXT) && !responseContent.contains("<") && !responseContent.contains(">");
		if (success) {
			String userId = responseContent.substring(0, responseContent.indexOf(' '));
			
			logger.info("User created with id: " + userId);

		} else {
			if (responseContent.contains(PLAIN_TEXT_RETURN_CODE) || responseContent.contains(PLAIN_TEXT_ERROR_TEXT)) {
				responseContent = responseContent.replace("\"", "");
				responseContent = responseContent.startsWith("{") ? responseContent.substring(1) : responseContent;
				responseContent = responseContent.endsWith("}") ? responseContent.substring(0, responseContent.length() - 1) : responseContent;

				String[] contentFields = responseContent.split(",");

				String errorCode = contentFields[0].split(":")[1];
				String errorMessage = contentFields[1].substring(contentFields[1].indexOf(':') + 1, contentFields[1].length());

				logger.info("Error creating the user: " + errorCode + " -> " + errorMessage);
				
			} else {
				logger.info("Error not handled creating the user");
			}
		}
	}

}
