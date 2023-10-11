package com.stacks.bdd.constants.core;

/**
	Collected constants of general utility.
	All members of this class are immutable.
*/
public final class Constants {

	public static final String VALUE = "value";
	public static final String CLASS = "class";
	public static final String NOT_FOUND = "\" not found.";

	public static final String INTERRUPTION_EXCEPTION = "Interruption exception";
	public static final String TIMEOUT_EXCEPTION = "timeout exception";

	
	
	/**
	   The caller references the constants using <tt>Consts.EMPTY_STRING</tt>, 
	   and so on. Thus, the caller should be prevented from constructing objects of 
	   this class, by declaring this private constructor. 
	*/
	private Constants(){
	    throw new AssertionError();
	}
}
