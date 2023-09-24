package com.stacks.bdd.dataset.builder;

import java.util.ArrayList;
import java.util.List;

import com.stacks.bdd.dataset.dataset.Dataset;
import com.stacks.bdd.dataset.factory.DatasetFactory;

/**
 * Allow the definition of the datasets and its dependencies.
 * 
 * @author ttrigo
 *
 */
public class DatasetBuilder {

	private DatasetFactory datasetFactory;
	
	public DatasetBuilder() {
		datasetFactory = new DatasetFactory();
	}
	
	/**
	 * Defines and returns the datasets with its dependencies.
	 * 
	 * @return a list of datasets with its dependencies.
	 */
	public List<Dataset> buildDatasets() {
		List<Dataset> datasets = new ArrayList<>();
		
		Dataset centerDataset = datasetFactory.buildDataset(DatasetFactory.CENTER_URL_BUILDER, 
				DatasetFactory.CSV_READER, 
				DatasetFactory.HTTP_GET_CLIENT, 
				DatasetFactory.CENTER_JSON_RESPONSE_PROCESSOR);
		
		Dataset userDataset = datasetFactory.buildDataset(DatasetFactory.USER_URL_BUILDER, 
				DatasetFactory.CSV_READER, 
				DatasetFactory.HTTP_POST_CLIENT, 
				DatasetFactory.USER_PLAINTEXT_RESPONSE_PROCESSOR);		
		
		Dataset patientDataset = datasetFactory.buildDataset(DatasetFactory.PATIENT_URL_BUILDER, 
				DatasetFactory.CSV_READER, 
				DatasetFactory.HTTP_GET_CLIENT, 
				DatasetFactory.PATIENT_JSON_RESPONSE_PROCESSOR);

		Dataset appointmentDataset = datasetFactory.buildDataset(DatasetFactory.APPOINTMENT_URL_BUILDER, 
				DatasetFactory.CSV_READER, 
				DatasetFactory.HTTP_GET_CLIENT, 
				DatasetFactory.APPOINTMENT_JSON_RESPONSE_PROCESSOR);

		Dataset reportTemplateDataSet = datasetFactory.buildDataset(DatasetFactory.REPORT_TEMPLATE_URL_BUILDER,
				DatasetFactory.PSV_READER,
				DatasetFactory.HTTP_POST_CLIENT,
				DatasetFactory.REPORT_TEMPLATE_JSON_RESPONSE_PROCESSOR);
		
		datasets.add(centerDataset);
		datasets.add(userDataset);
		datasets.add(patientDataset);
		datasets.add(appointmentDataset);
		datasets.add(reportTemplateDataSet);
		
		return datasets;
	}
	
}
