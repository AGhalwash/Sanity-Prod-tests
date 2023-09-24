package com.stacks.bdd.dataset.dataset;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.stacks.bdd.dataset.client.DatasetClient;
import com.stacks.bdd.dataset.responseprocessor.DatasetResponseProcessor;
import com.stacks.bdd.dataset.urlbuilder.DatasetURLBuilder;

/**
 * Class with the responsibility to execute all the necessary tasks to load a dataset.
 * <p>A dataset represents a data set of the same type that have to be processed in different ways.
 * In this case the data is sent to an external endpoint to be sotred.</p>
 * 
 * @author ttrigo
 *
 */
public class Dataset {

	private static final Logger logger = Logger.getLogger(Dataset.class);
	
	private DatasetURLBuilder urlBuilder;
	private DatasetClient client;
	private DatasetResponseProcessor responseProcessor;
	
	public Dataset(DatasetURLBuilder urlBuilder, DatasetClient client, DatasetResponseProcessor responseProcessor) {
		this.urlBuilder = urlBuilder;
		this.client = client;
		this.responseProcessor = responseProcessor;
	}

	/**
	 * Process the dataset, performing all the necessary tasks to process the dataset data.
	 * 
	 * <ul>
	 * <li>1. Gets the server URLs.</li>
	 * <li>2. Makes a call to every endpoint.</li>
	 * <li>3. Process the server response.</li>
	 * </ul>
	 */
	public void load() {
		List<RequestParameters> uriList = getURLs();
		
		for (RequestParameters requestParameters : uriList) {
			try {
				InputStream is = client.call(requestParameters);
				responseProcessor.processResponse(is);
			} catch (Exception e) {
				logger.error("Error loading dataset with URI: " + requestParameters.getUri().toASCIIString(), e);
			}
		}
	}
	
	/**
	 * Returns the list of {@code URL} associated with the data of the dataset.
	 * 
	 * @return the list of {@code URL}.
	 */
	private List<RequestParameters> getURLs() {
		List<RequestParameters> uriList = new ArrayList<>();

		try {
			uriList = urlBuilder.getURLs();
		} catch (IOException e) {
			logger.error("Error accesing the necessary data to build the URLs of the dataset", e);
		}

		return uriList;
	}
	
}
