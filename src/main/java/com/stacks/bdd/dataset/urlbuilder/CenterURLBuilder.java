package com.stacks.bdd.dataset.urlbuilder;

import org.codehaus.plexus.util.StringUtils;

import com.stacks.bdd.dataset.domain.CenterRecord;
import com.stacks.bdd.dataset.domain.DatasetQueryRecord;
import com.stacks.bdd.dataset.exception.MandatoryQueryParameterException;
import com.stacks.bdd.dataset.reader.DatasetDataReader;

/**
 * Builds center's dataset {@code URL}s.
 * 
 * @author ttrigo
 *
 */
public class CenterURLBuilder extends BasicGetURLBuilder {

	private static final String DATA_FILE_PATH = "CreateCenters.csv";
	private static final String CENTER_ENDPOINT = "remotewsCenterCall.htm" ;
	
	public CenterURLBuilder(DatasetDataReader reader) {
		super(reader, DATA_FILE_PATH);
	}
	
    /**
     * {@inheritDoc}
     */
	@Override
	public String buildPath() {
		return CENTER_ENDPOINT;
	}

    /**
     * {@inheritDoc}
     * 
     * <p>Uses the field {@code urlParameter} of the {@link CenterRecord} as a parameter name.</p>
     * <p>Uses the record obtained form a file as a parameter value.</p>
     * @throws MandatoryQueryParameterException 
     */
	@Override
	public String buildQuery(DatasetQueryRecord record) throws MandatoryQueryParameterException {
		StringBuilder sb = new StringBuilder();
		
		int paramIndex = 0;
		for (CenterRecord center : CenterRecord.values()) {
			String parameterName = center.getUrlParameterName();
			String value = record.get(center);
			
			if (center.isMandatory() && StringUtils.isBlank(value)) {
				throw new MandatoryQueryParameterException(parameterName);
			}
			
			if (StringUtils.isNotBlank(value)) {
				sb.append(paramIndex == 0 ? "?" : "&");
				sb.append(parameterName);
				sb.append("=");
				sb.append(value);
				
				paramIndex++;
			}
		}
		
		return sb.toString();
	}

}
