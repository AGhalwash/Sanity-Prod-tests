package com.stacks.bdd.dataset.urlbuilder;

import com.stacks.bdd.dataset.dataset.RequestParameters;
import com.stacks.bdd.dataset.domain.DatasetQueryRecord;
import com.stacks.bdd.dataset.reader.DatasetDataReader;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Basic implementation for {@code URL} builders.
 * 
 * @author dromero
 *
 */
public abstract class BasicPostURLBuilder implements DatasetURLBuilder {

	private static final Logger logger = Logger.getLogger(BasicPostURLBuilder.class);

	private static final String SYSTEM_PROPERTIES_FILE_NAME = "system.properties";
	private static final String JENOMI_URL_PROPERTY = "selenium.server.url";
	private static final String DATASET_DIR_PATH = "dataset/";

	private DatasetDataReader reader;

	private String dataPath;

	public BasicPostURLBuilder(DatasetDataReader reader, String dataPath) {
		this.reader = reader;
		this.dataPath = dataPath;
	}
	
    /**
     * {@inheritDoc}
     */
	@Override
	public List<RequestParameters> getURLs() throws IOException {
		List<RequestParameters> requestParametersList = new ArrayList<>();
		
		String host = buildHost();
		String path = buildPath();
		URI uri = null;
		try {
			String urlAsString = host + path;
			URL url = new URL(urlAsString);
			uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
		} catch (MalformedURLException | URISyntaxException e) {
			logger.error("The dataset URL is not valid", e);
		}


		List<DatasetQueryRecord> queryData = reader.getQueryData(DATASET_DIR_PATH + dataPath);
		for (DatasetQueryRecord record : queryData) {
			RequestParameters requestParameters = buildQuery(record);
			requestParameters.setUri(uri);

			requestParametersList.add(requestParameters);
		}
		
		return requestParametersList;
	}
	
	/**
	 * Builds the {@code URL} host part.
	 * <p>This part is obtained from properties file.</p>
	 * 
	 * @return the host of the {@code URL} as {@code String}.
	 * @throws IOException if an error occurred when reading properties file.
	 */
	public String buildHost() throws IOException {
		Properties systemProps = new Properties();
		
		InputStream appConfigIn = BasicPostURLBuilder.class.getClassLoader().getResourceAsStream(SYSTEM_PROPERTIES_FILE_NAME);
		systemProps.load(appConfigIn);
		
		return systemProps.getProperty(JENOMI_URL_PROPERTY) + "jenomi/";
	}	
	
	/**
	 * Builds the {@code URL} path part.
	 * 
	 * @return the path of the {@code URL} as {@code String}.
	 */
	public abstract String buildPath();
	
	/**
	 * Builds the {@code URL} query part.
	 * 
	 * @param record the data necessary to build the query.
	 * @return the query of the {@code URL} as {@code String}.
	 * @throws MalformedURLException if the query part is malformed.
	 */
	public abstract RequestParameters buildQuery(DatasetQueryRecord record) throws IOException;
	
}
