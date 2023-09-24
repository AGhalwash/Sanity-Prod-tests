package com.stacks.bdd.dataset.domain;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVRecord;

/**
 * Manage the data obtained from the CSV file.
 * <p>
 * The key of the identifier map must contain the parameters names of the query of the URL.
 * The value of the identifier map must the position of the parameters names of the query of the URL.
 * The values array must contain the values for the parameters for the query of the URL.
 * </p>
 * 
 * @author ttrigo
 * @see CSVRecord
 *
 */
public class DatasetQueryRecord implements Iterable<String> {
	 
	private final Map<String, Integer> identifierMap;
	
	private final String[] values;
	
	public DatasetQueryRecord(final Map<String, Integer> map, final String[] values) {
		this.identifierMap = map;
		this.values = values;
	}
	
    /**
     * Returns a value by {@link Enum}.
     *
     * @param e an enum.
     * @return the {@code String} at the given enum {@code String}.
     */
    public String get(Enum<?> e) {
        return get(e.toString());
    }

    /**
     * Returns a value by index.
     *
     * @param i a column index (0-based).
     * @return the {@code String} at the given index.
     */
    public String get(int i) {
        return values[i];
    }
    
    /**
     * Returns a value by name.
     *
     * @param name the name of the column to be retrieved.
     * @return the column value, maybe {@code null}.
     * @throws IllegalStateException if no header mapping was provided.
     * @throws IllegalArgumentException if {@code name} is not mapped or if the record is inconsistent.
     */
    public String get(String name) {
        if (identifierMap == null) {
            throw new IllegalStateException("No identifier map was specified, the record values can't be accessed by name");
        }
        Integer index = identifierMap.get(name);
        if (index == null) {
            throw new IllegalArgumentException(String.format("Mapping for %s not found, expected one of %s", name, identifierMap.keySet()));
        }
        try {
        	return values[index.intValue()];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(String.format("Index for identifer '%s' is %d but DatasetRecord only has %d values!", name, index, Integer.valueOf(values.length) + 1), e);
        }
    }

    /**
     * Returns an iterator over the values of this record.
     *
     * @return an iterator over the values of this record.
     */
    @Override
    public Iterator<String> iterator() {
        return toList().iterator();
    }
    
    /**
     * Converts the values to a List.
     *
     * @return a new List.
     */
    private List<String> toList() {
        return Arrays.asList(values);
    }
    
}
