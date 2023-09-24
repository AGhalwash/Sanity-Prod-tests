package com.stacks.bdd.dataset.responseprocessor.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

/**
 * Implementation for generic plain text response processing operations.
 * 
 * @author ttrigo
 *
 */
public abstract class BasicPlainTextResponseProcessor {
	
	private static final Logger logger = Logger.getLogger(BasicPlainTextResponseProcessor.class);
	
	/**
	 * Convert the response content to plain text.
	 * 
	 * @param is the {@code InputStream} to be converted.
	 * @return the content of the response converted as text plain.
	 * @throws IOException if any problem occurs reading the content. 
	 */
	protected String parseResponse(InputStream is) throws IOException {
		String responseAsString = null;
		
		try {
			StringBuilder sb = new StringBuilder();
			try(BufferedReader rd = new BufferedReader(new InputStreamReader(is))) {
				String line = "";
				while ((line = rd.readLine()) != null) {
					sb.append(line);
				}
			}

			responseAsString = sb.toString();
			
			logger.trace("Response: " + responseAsString);

		} catch(IOException ioe) {
			logger.error("Error reading the response.");
			throw ioe;
		} 
		
		return responseAsString;
	}

}
