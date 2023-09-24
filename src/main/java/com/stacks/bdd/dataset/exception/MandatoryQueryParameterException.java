package com.stacks.bdd.dataset.exception;

import java.io.IOException;

/**
 * Represents the error when an empty mandatory parameter has found during the built of the query part of one URL.
 * 
 * @author ttrigo
 *
 */
public class MandatoryQueryParameterException extends IOException {

	private static final long serialVersionUID = 4124701874034899062L;

	public MandatoryQueryParameterException(String parameterName) {
		 super("The parameter " + parameterName + " is mandatory. It cannot be null.");
	}
	
	public MandatoryQueryParameterException(String message, Throwable cause) {
		super(message, cause);
	}

}
