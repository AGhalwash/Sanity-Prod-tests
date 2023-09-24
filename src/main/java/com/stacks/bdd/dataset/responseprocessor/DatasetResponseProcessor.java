package com.stacks.bdd.dataset.responseprocessor;

import java.io.IOException;
import java.io.InputStream;

/**
 * A processor that process the content of the response.
 * 
 * @author ttrigo
 *
 */
public interface DatasetResponseProcessor {

	/**
	 * Process the data content of response.
	 * 
	 * @param is the data to be processed.
	 * @throws IOException if any problem occurs reading the content. 
	 */
	void processResponse(InputStream is) throws IOException;
	
}
