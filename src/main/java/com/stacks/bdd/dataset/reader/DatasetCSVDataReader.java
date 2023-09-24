package com.stacks.bdd.dataset.reader;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.log4j.Logger;

import com.stacks.bdd.dataset.domain.DatasetQueryRecord;

/**
 * A data reader to get data from CSV files.
 * <p>Uses apache commons-csv library.</p>
 * 
 * @author ttrigo
 *
 */
public class DatasetCSVDataReader implements DatasetDataReader{

	private static final Logger logger = Logger.getLogger(DatasetCSVDataReader.class);
	
	private static final char DELIMITER = ';';
	private static final char COMMENT_MARKER = '#';

	protected char getDelimiter() {
		return DELIMITER;
	}

	protected char getCommentMarker() {
		return COMMENT_MARKER;
	}
	
    /**
     * {@inheritDoc}
     * 
     * <p>Returns an empty list if the CSV file has no records.</p>
     * <p>The CSV parser uses ';' as delimiter and '#' as a comment, also ignore empty lines.</p>
     */
	@Override
	public List<DatasetQueryRecord> getQueryData(String dataPath) throws IOException {
		List<CSVRecord> csvRecords;
		Map<String, Integer> headerMap;
		
		File file = getFile(dataPath);
		try( Reader isr = new InputStreamReader(new FileInputStream(file),StandardCharsets.UTF_8)) {
			CSVParser parser = CSVFormat.DEFAULT
					.withFirstRecordAsHeader()
					.withDelimiter(getDelimiter())
					.withCommentMarker(getCommentMarker())
					.withIgnoreEmptyLines()
					.parse(isr);
			
			csvRecords = parser.getRecords();
			headerMap = parser.getHeaderMap();
		}
	    
		List<DatasetQueryRecord> dataList = new ArrayList<>();
	    if (!csvRecords.isEmpty()) {
	    	dataList = parseData(csvRecords, headerMap);
	    } else {
	    	logger.warn(String.format("CSV file %s has no records: ", dataPath));
	    }
	    
	    return dataList;
	}
	
	/**
	 * Returns the CSV file.
	 * 
	 * @param dataPath the path of the file.
	 * @return the file.
	 * @throws IOException if the CSV file does not exits.
	 */
	private File getFile(String dataPath) throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		
		URL fileURL = classLoader.getResource(dataPath);
		if (fileURL == null) {
			throw new IOException(String.format("CSV file does not exist: " , dataPath));
		}
		
		return new File(fileURL.getFile());
	}
	
	/**
	 * Converts the data read from the CSV file to a generic type.
	 * 
	 * @param csvRecords the CSV records from file.
	 * @param headerMap the header from CSV file.
	 * @return the data of the file as {@code DatasetQueryRecord}.
	 */
	private List<DatasetQueryRecord> parseData(List<CSVRecord> csvRecords, Map<String, Integer> headerMap) {
		List<DatasetQueryRecord> dataList = new ArrayList<>();
		
	    for (CSVRecord csvRecord : csvRecords) {
	    	int index = csvRecord.size();
	    	String[] values = new String[index];
	    	for (int i = 0; i < index; i++) {
	    		values[i] = csvRecord.get(i);
	    	}
	    	DatasetQueryRecord record = new DatasetQueryRecord(headerMap, values);
	    	dataList.add(record);
	    }
	    
	    return dataList;
	}
	
}

