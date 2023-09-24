package com.stacks.bdd.selenium.forms.genomi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.stacks.bdd.selenium.fields.IField;

public abstract class AbstractForm implements IForm {

	protected List<IField> fields;
	private static final String DATE_FORMAT = "dd/MM/yyyy";
	private static final DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern(DATE_FORMAT);
	public static final Long BIRTH_LESS_THAN_18_MONTHS = 15L;
	public static final Long BIRTH_BETWEEN_18_MONTH_AND_3_YEARS = 690L;
	public static final Long BIRTH_MORE_THAN_3_YEARS = 1500L;
	public static final Long BIRTH_MORE_THAN_18_YEARS = 10000L;

	@Override
	public List<IField> getAllFields() {
		return fields;
	}

	@Override
	public List<IField> getMandatoryFields() {
		List<IField> mandatoryFields = new ArrayList<>();
		for (IField iField : fields) 
			if (iField.isMandatory()) 
				mandatoryFields.add(iField);

		return mandatoryFields;
	}
	
	@Override
	public IField getFieldByName(String fieldName) {
		for (IField iField : fields) 
			if (fieldName.equals(iField.getName()))
				return iField;

		throw new IllegalArgumentException("Field with fieldName \"" + fieldName + "\" not found.");
	}

	public static String calculateBirthDate(Long minusDays){
		LocalDate currentDate = LocalDate.now();
		currentDate = currentDate.minusDays(minusDays);
		return dateFormater.format(currentDate);
	}
}
