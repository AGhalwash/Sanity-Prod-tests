package com.stacks.bdd.dataset.starter;

import org.apache.log4j.Logger;

import com.stacks.bdd.dataset.loader.DatasetLoader;

/**
 * Starts the application.
 * 
 * @author ttrigo
 *
 */
public class DatasetStarter {

	private static final Logger logger = Logger.getLogger(DatasetStarter.class);
	
	private DatasetLoader datasetLoader;
	
	public DatasetStarter() {
		this.datasetLoader = new DatasetLoader();
	}
	
	/**
	 * Starts the load of datasets.
	 */
	public void start() {
		datasetLoader.loadDatasets();
	}
	
	/**
	 * Application entry point.
	 * 
	 * @param args console arguments.
	 */
	public static void main(String[] args)  {
		logger.info("Dataset - started");
		
		new DatasetStarter().start();
		
		logger.info("Dataset - finished");
	}
	
}
