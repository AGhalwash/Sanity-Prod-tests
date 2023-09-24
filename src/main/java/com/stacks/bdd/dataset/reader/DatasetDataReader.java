package com.stacks.bdd.dataset.reader;

import java.io.IOException;
import java.util.List;

import com.stacks.bdd.dataset.domain.DatasetQueryRecord;

/**
 * A data reader to get data from dataset files.
 * 
 * @author ttrigo
 *
 */
public interface DatasetDataReader {
	
	/**
	 * Reads from any input source the query part of an URL.
	 * <p>Converts the data to a generic type.</p>
	 * 
	 * @param dataPath the data path.
	 * @return the data of the input source as {@code DatasetQueryRecord}.
	 * @throws IOException if any problem occurs when accessing the data.
	 */
	List<DatasetQueryRecord> getQueryData(String dataPath) throws IOException;
	
}
