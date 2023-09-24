package com.stacks.bdd.dataset.responseprocessor.json;

import com.stacks.bdd.dataset.responseprocessor.DatasetResponseProcessor;
import com.stacks.bdd.dataset.responseprocessor.text.BasicPlainTextResponseProcessor;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Process the content of a report template response.
 * <p>It processes the content as a JSON.</p>
 * 
 * @author dromero
 *
 */
public class ReportTemplateJsonResponseProcessor extends BasicPlainTextResponseProcessor implements DatasetResponseProcessor {

	private static final Logger logger = Logger.getLogger(ReportTemplateJsonResponseProcessor.class);

    /**
     * {@inheritDoc} 
     */
	public void processResponse(InputStream is) throws IOException {
		String response = parseResponse(is);

		if (response != null && !response.isEmpty()) {
			logger.info("Error creating a report template: " + response );
		} else {
			logger.info("Report Template created " + response );
		}
	}
}
