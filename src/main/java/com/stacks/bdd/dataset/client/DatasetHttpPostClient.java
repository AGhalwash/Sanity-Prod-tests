package com.stacks.bdd.dataset.client;

import com.stacks.bdd.dataset.dataset.RequestParameters;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

/**
 * Client in charge of making native HTTP calls.
 * <p>This implementation uses the apache http-client library.</p>
 * 
 * @author dromero
 *
 */
public class DatasetHttpPostClient implements DatasetClient {

	private static final Logger logger = Logger.getLogger(DatasetHttpPostClient.class);

	private HttpEntityEnclosingRequestBase httpRequest;

	public DatasetHttpPostClient(HttpEntityEnclosingRequestBase httpRequest) {
		this.httpRequest = httpRequest;
	}
	
    /**
     * {@inheritDoc}
     */
	@Override
	public InputStream call(RequestParameters requestParameters) throws IOException {
		logger.trace("Sending 'GET' request to URL: " + requestParameters.getUri().toASCIIString());
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpEntityEnclosingRequestBase request = httpRequest;
		request.setURI(requestParameters.getUri());

		requestParameters.getHeaders().forEach(request::setHeader);
		request.setEntity(requestParameters.getEntity());
		
		HttpResponse response = client.execute(request);
		
		logger.trace("Response Code: " + response.getStatusLine().getStatusCode());
		
		return response.getEntity().getContent();
	}

}
