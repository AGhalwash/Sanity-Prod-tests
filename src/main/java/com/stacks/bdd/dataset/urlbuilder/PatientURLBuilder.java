package com.stacks.bdd.dataset.urlbuilder;

import org.codehaus.plexus.util.StringUtils;

import com.stacks.bdd.dataset.domain.DatasetQueryRecord;
import com.stacks.bdd.dataset.domain.PatientRecord;
import com.stacks.bdd.dataset.exception.MandatoryQueryParameterException;
import com.stacks.bdd.dataset.reader.DatasetDataReader;

/**
 * Builds patient's dataset {@code URL}s.
 * 
 * @author ttrigo
 *
 */
public class PatientURLBuilder extends BasicGetURLBuilder {

	private static final String DATA_FILE_PATH = "CreatePatients.csv";
	private static final String PATIENT_ENDPOINT = "internalWSPatientCreate.htm" ;
	
	public PatientURLBuilder(DatasetDataReader reader) {
		super(reader, DATA_FILE_PATH);
	}
	
    /**
     * {@inheritDoc}
     */
	@Override
	public String buildPath() {
		return PATIENT_ENDPOINT;
	}

    /**
     * {@inheritDoc}
     * 
     * <p>Uses the field {@code urlParameter} of the {@link PatientRecord} as a parameter name.</p>
     * <p>Uses the record obtained form a file as a parameter value.</p>
     */
	@Override
	public String buildQuery(DatasetQueryRecord record) throws MandatoryQueryParameterException {
		StringBuilder sb = new StringBuilder();
		
		int paramIndex = 0;
		for (PatientRecord patient : PatientRecord.values()) {
			String parameterName = patient.getUrlParameterName();
			String value = record.get(patient);
			
			if (patient.isMandatory() && StringUtils.isBlank(value)) {
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
