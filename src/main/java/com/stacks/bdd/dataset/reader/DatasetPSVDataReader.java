package com.stacks.bdd.dataset.reader;

/**
 * A data reader to get data from PSV files.
 * <p>Uses apache commons-csv library.</p>
 * 
 * @author dromero
 *
 */
public class DatasetPSVDataReader extends DatasetCSVDataReader{
	private static final char DELIMITER = '|';
	private static final char COMMENT_MARKER = '#';

	@Override
	protected char getDelimiter() {
		return DELIMITER;
	}

	@Override
	protected char getCommentMarker() {
		return COMMENT_MARKER;
	}
}

