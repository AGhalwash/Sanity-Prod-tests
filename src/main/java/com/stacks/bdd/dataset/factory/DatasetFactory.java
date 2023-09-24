package com.stacks.bdd.dataset.factory;

import com.stacks.bdd.dataset.client.DatasetHttpPostClient;
import com.stacks.bdd.dataset.reader.DatasetPSVDataReader;
import com.stacks.bdd.dataset.responseprocessor.json.ReportTemplateJsonResponseProcessor;
import com.stacks.bdd.dataset.urlbuilder.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import com.stacks.bdd.dataset.client.DatasetClient;
import com.stacks.bdd.dataset.client.DatasetHttpGetClient;
import com.stacks.bdd.dataset.dataset.Dataset;
import com.stacks.bdd.dataset.encrypter.DatasetEncrypter;
import com.stacks.bdd.dataset.reader.DatasetCSVDataReader;
import com.stacks.bdd.dataset.reader.DatasetDataReader;
import com.stacks.bdd.dataset.responseprocessor.DatasetResponseProcessor;
import com.stacks.bdd.dataset.responseprocessor.json.AppointmentJsonResponseProcessor;
import com.stacks.bdd.dataset.responseprocessor.json.CenterJsonResponseProcessor;
import com.stacks.bdd.dataset.responseprocessor.json.PatientJsonResponseProcessor;
import com.stacks.bdd.dataset.responseprocessor.text.UserPlainTextResponseProcessor;

/**
 * Builds a dataset with all of its dependencies.
 * <p>This must be the only point of the application in which it is allowed to instantiate non model objects.</p>
 * <p>
 * Once the class could instantiate more than 5 different implementations for one interface, 
 * we should change the way of how the instance are created, doing it dynamically using reflection.
 * </p>  
 * 
 * @author ttrigo
 *
 */
public class DatasetFactory {

	public static final int PATIENT_URL_BUILDER = 0;
	public static final int APPOINTMENT_URL_BUILDER = 1;
	public static final int CENTER_URL_BUILDER = 2;
	public static final int USER_URL_BUILDER = 3;
	public static final int REPORT_TEMPLATE_URL_BUILDER = 4;

	public static final int CSV_READER = 0;
	public static final int PSV_READER = 1;

	public static final int HTTP_GET_CLIENT = 0;
	public static final int HTTP_POST_CLIENT = 1;
	
	public static final int PATIENT_JSON_RESPONSE_PROCESSOR = 0;
	public static final int APPOINTMENT_JSON_RESPONSE_PROCESSOR = 1;
	public static final int CENTER_JSON_RESPONSE_PROCESSOR = 2;
	public static final int USER_PLAINTEXT_RESPONSE_PROCESSOR = 3;
	public static final int REPORT_TEMPLATE_JSON_RESPONSE_PROCESSOR = 4;

	/**
	 * Returns a dataset with its dependencies based on the types that arrives as a parameter.
	 * 
	 * @param urlBuilderType the type of {@code DatasetURLBuilder} dependency.
	 * @param readerType the type of {@code DatasetDataReader} dependency. 
	 * @param clientType the type of {@code DatasetClient} dependency.
	 * @param responseProcessorType the type of {@code DatasetResponseProcessor} dependency.
	 * @return a dataset with its dependencies.
	 */
	public Dataset buildDataset(Integer urlBuilderType, Integer readerType, Integer clientType, Integer responseProcessorType) {
		DatasetDataReader reader = buildReader(readerType);
		DatasetClient client = buildClient(clientType);
		DatasetResponseProcessor responseProcessor = buildResponseProcessor(responseProcessorType);
		
		DatasetURLBuilder urlBuilder = buildURLBuilder(urlBuilderType, reader);
		
		return new Dataset(urlBuilder, client, responseProcessor);
	}
	
	/**
	 * Instantiates the {@code DatasetURLBuilder} of the dataset.
	 * <p>
	 * The implementation may vary according to the urlBuilderType parameter.
	 * A {@code DatasetURLBuilder} needs a {@code DatasetDataReader} to get the query data.
	 * </p>
	 * 
	 * @param urlBuilderType the type to be instantiate.
	 * @param reader the @code DatasetDataReader} dependency that the builder needs.
	 * @return a {@code DatasetURLBuilder}.
	 */
	private DatasetURLBuilder buildURLBuilder(Integer urlBuilderType, DatasetDataReader reader) {
		if (urlBuilderType == null) {
			throw new IllegalArgumentException();
		}
		
		if (urlBuilderType.equals(PATIENT_URL_BUILDER)) {
			return new PatientURLBuilder(reader);
			
		} else if (urlBuilderType.equals(APPOINTMENT_URL_BUILDER)) {
			return new AppointmentURLBuilder(reader, new DatasetEncrypter());
			
		} else if (urlBuilderType.equals(CENTER_URL_BUILDER)) {
			return new CenterURLBuilder(reader);
			
		} else if (urlBuilderType.equals(USER_URL_BUILDER)) {
			return new UserURLBuilder(reader);

		} else if (urlBuilderType.equals(REPORT_TEMPLATE_URL_BUILDER)) {
			return new ReportTemplateURLBuilder(reader);
		}
		
		throw new IllegalArgumentException();
	}
	
	/**
	 * Instantiates the {@code DatasetDataReader} of the dataset.
	 * <p>The implementation may vary according to the readerType parameter.</p>
	 * 
	 * @param readerType the type to be instantiate.
	 * @return a {@code DatasetDataReader}.
	 */
	private DatasetDataReader buildReader(Integer readerType) {
		if (readerType == null) {
			throw new IllegalArgumentException();
		}
		
		if (readerType.equals(CSV_READER)) {
			return new DatasetCSVDataReader();
		}
		if (readerType.equals(PSV_READER)) {
			return new DatasetPSVDataReader();
		}
		
		throw new IllegalArgumentException();
	}
	
	/**
	 * Instantiates the {@code DatasetClient} of the dataset.
	 * <p>The implementation may vary according to the clientType parameter.</p>
	 * 
	 * @param clientType the type to be instantiate.
	 * @return a {@code DatasetClient}.
	 */
	private DatasetClient buildClient(Integer clientType) {
		if (clientType == null) {
			throw new IllegalArgumentException();
		}
		
		if (clientType.equals(HTTP_GET_CLIENT)) {
			return new DatasetHttpGetClient(new HttpGet());
			
		} else if (clientType.equals(HTTP_POST_CLIENT)) {
			return new DatasetHttpPostClient(new HttpPost());
		}
		
		throw new IllegalArgumentException();	
	}
	
	/**
	 * Instantiates the {@code DatasetResponseProcessor} of the dataset.
	 * <p>The implementation may vary according to the responseProcessorType parameter.</p>
	 * 
	 * @param responseProcessorType the type to be instantiate.
	 * @return a {@code DatasetResponseProcessor}.
	 */
	private DatasetResponseProcessor buildResponseProcessor(Integer responseProcessorType) {
		if (responseProcessorType == null) {
			throw new IllegalArgumentException();
		}
		
		if (responseProcessorType.equals(PATIENT_JSON_RESPONSE_PROCESSOR)) {
			return new PatientJsonResponseProcessor();
			
		} else if (responseProcessorType.equals(APPOINTMENT_JSON_RESPONSE_PROCESSOR)) {
			return new AppointmentJsonResponseProcessor(new DatasetEncrypter());
			
		} else if (responseProcessorType.equals(CENTER_JSON_RESPONSE_PROCESSOR)) {
			return new CenterJsonResponseProcessor();
			
		} else if (responseProcessorType.equals(USER_PLAINTEXT_RESPONSE_PROCESSOR)) {
			return new UserPlainTextResponseProcessor();

		} else if (responseProcessorType.equals(REPORT_TEMPLATE_JSON_RESPONSE_PROCESSOR)) {
			return new ReportTemplateJsonResponseProcessor();
		}
		
		throw new IllegalArgumentException();		
	}
	
}
