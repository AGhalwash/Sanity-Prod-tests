package com.stacks.bdd.dataset.client;

import com.stacks.bdd.dataset.dataset.RequestParameters;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * An interface of any kind of client to make client-server operations.
 * 
 * @author ttrigo
 *
 */
public interface DatasetClient {

	/**
	 * Send a request to the server using the {@code URI} that arrives as a parameter.
	 * 
	 * @param uri the {@code URI} to be called.
	 * @return the content of response as {@code InputStream}.
	 * @throws IOException if there is any problem with the request or if the server response has no content.
	 */
	InputStream call(RequestParameters uri) throws IOException;

}
