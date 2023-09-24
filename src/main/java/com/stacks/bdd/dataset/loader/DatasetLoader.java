package com.stacks.bdd.dataset.loader;

import java.util.List;

import com.stacks.bdd.dataset.builder.DatasetBuilder;
import com.stacks.bdd.dataset.dataset.Dataset;

/**
 * Starts the load process.
 * 
 * @author ttrigo
 *
 */
public class DatasetLoader {
	
	private DatasetBuilder datasetBuilder;
	
	public DatasetLoader() {
		this.datasetBuilder = new DatasetBuilder();
	}
	
	/**
	 * Obtains all datasets and start the load process.
	 */
	public void loadDatasets() {
		List<Dataset> datasets = datasetBuilder.buildDatasets();
		
		for (Dataset dataset : datasets) {
			dataset.load();
		}
	}

}
