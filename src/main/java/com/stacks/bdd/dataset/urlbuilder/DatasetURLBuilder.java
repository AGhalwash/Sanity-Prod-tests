package com.stacks.bdd.dataset.urlbuilder;

import com.stacks.bdd.dataset.dataset.RequestParameters;

import java.io.IOException;
import java.net.URI;
import java.util.List;

/**
 * A builder of the {@code URL} of the datasets endpoints.
 * <p>Must exists an implementation of this class for every different type of dataset.</p>
 * 
 * @author ttrigo
 *
 */
public interface DatasetURLBuilder {

	/**
	 * Returns a list with all the {@code URL} that the dataset has to load, each {@code URL} correspond to a different record.
	 * <p>
	 * The values of the parameters of the {@code URL} are obtained form the corresponding dataset file.
	 * With these parameter values obtains the query part of the {@code URL}.<p>
	 * Putting together the different {@code URL} parts it builds the final {@code URL}, (host, path and query).<p>
	 * </p>
	 * <p>The data for query part is obtained using the reader.</p>
	 * 
	 * @return a list of {@code URI}s.
	 * @throws IOException if the reader can no read the file.
	 */
	List<RequestParameters> getURLs() throws IOException;

}
