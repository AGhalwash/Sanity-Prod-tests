package com.stacks.bdd.dataset.urlbuilder;

import com.stacks.bdd.dataset.dataset.RequestParameters;
import com.stacks.bdd.dataset.domain.DatasetQueryRecord;
import com.stacks.bdd.dataset.domain.ReportTemplateRecord;
import com.stacks.bdd.dataset.reader.DatasetDataReader;
import com.stacks.bdd.dataset.utils.JWTTestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Builds report template's dataset {@code URL}s.
 * 
 * @author dromero
 *
 */
public class ReportTemplateURLBuilder extends BasicPostURLBuilder {

	private static final String DATA_FILE_PATH = "ReportTemplate.csv";
	private static final String PATIENT_ENDPOINT = "saveReportTemplate" ;

	public ReportTemplateURLBuilder(DatasetDataReader reader) {
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
     * <p>Uses the field {@code urlParameter} of the {@link ReportTemplateRecord} as a parameter name.</p>
     * <p>Uses the record obtained form a file as a parameter value.</p>
     */
	@Override
	public RequestParameters buildQuery(DatasetQueryRecord record) throws UnsupportedEncodingException {
		Map<String, String> headersMap = new HashMap<>();
		HttpEntity entity = null;
		for (ReportTemplateRecord reportTemplate : ReportTemplateRecord.values()) {
			String parameterName = reportTemplate.getParameterName();
			String value = record.get(reportTemplate);

			if("Authorization".equals(parameterName)){
				value += JWTTestUtils.createGenericToken();
			}
			if("payload".equals(parameterName)){
				entity = new StringEntity(value);
			} else {
				headersMap.put(parameterName, value);
			}
		}
		return new RequestParameters(null, headersMap, entity);
	}
}
