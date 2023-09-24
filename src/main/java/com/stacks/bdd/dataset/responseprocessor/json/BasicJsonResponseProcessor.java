package com.stacks.bdd.dataset.responseprocessor.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Implementation for generic JSON response processing operations.
 * 
 * @author ttrigo
 *
 */
public abstract class BasicJsonResponseProcessor {
	
	private static final Logger logger = Logger.getLogger(BasicJsonResponseProcessor.class);
	
	/**
	 * Convert the content of the response to JSON.
	 * 
	 * @param is the {@code InputStream} to be converted.
	 * @return the content of the response converted as JSON.
	 * @throws IOException if any problem occurs reading the content. 
	 */
	protected JSONObject parseResponse(InputStream is) throws IOException {
		JSONObject jsonObject = null;
		
		try {
			StringBuilder sb = new StringBuilder();
			try(BufferedReader rd = new BufferedReader(new InputStreamReader(is))) {
				String line = "";
				while ((line = rd.readLine()) != null) {
					sb.append(line);
				}
			}
			String responseAsString = sb.toString();
			
			logger.trace("Response: " + responseAsString);
			
			jsonObject = new JSONObject(responseAsString);

		} catch(IOException ioe) {
			logger.error("Error reading the response.");
			throw ioe;
			
		} catch(JSONException jsone) {
			logger.error("Response not parsable to JSON.");
			throw jsone;
		}
		
		return jsonObject;
	}

}
