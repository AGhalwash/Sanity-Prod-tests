package com.stacks.bdd.dataset.client;

import java.io.IOException;
import java.io.InputStream;

import com.stacks.bdd.dataset.dataset.RequestParameters;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;

/**
 * Client in charge of making native HTTP calls.
 * <p>This implementation uses the apache http-client library.</p>
 * 
 * @author ttrigo
 *
 */
public class DatasetHttpGetClient implements DatasetClient {

	private static final Logger logger = Logger.getLogger(DatasetHttpGetClient.class);
	
	private HttpRequestBase httpRequest;
	
	public DatasetHttpGetClient(HttpRequestBase httpRequest) {
		this.httpRequest = httpRequest;
	}
	
    /**
     * {@inheritDoc}
     */
	@Override
	public InputStream call(RequestParameters requestParameters) throws IOException {
		logger.trace("Sending 'GET' request to URL: " + requestParameters.getUri().toASCIIString());
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpRequestBase request = httpRequest;
		request.setURI(requestParameters.getUri());
		
		HttpResponse response = client.execute(request);
		
		logger.trace("Response Code: " + response.getStatusLine().getStatusCode());
		
		return response.getEntity().getContent();
	}

}
