package com.stacks.bdd.constants.core;

/**
	Collected constants of general utility.
	All members of this class are immutable.
*/
public final class Constants {

	public static final String AUTOMATED_TEST = "automated test";
	public static final String NOT_APPLIED = "Not applied";
	public static final String ACCEPT = "Accept";
	public static final String VALUE = "value";
	public static final String CLASS = "class";
	public static final String NOT_FOUND = "\" not found.";
	public static final String INSTANTIATION="InstantiationException";
	public static final String PRODUCT_MSG = "Product \"";
	public static final String PAGE_MSG = "Page \"";
	public static final String MESSAGE_MSG = "Message \"";
	public static final String PATIENT = "patient";
	public static final String PROFESSIONAL = "professional";
	public static final String AUTOMATED_TEST_BDD = "automated test bdd";
	public static final String INTERRUPTION_EXCEPTION = "Interruption exception";
	public static final String TIMEOUT_EXCEPTION = "timeout exception";
	public static final String API_EXECPTION = "api exception";
	public static final String DATABASE_EXCEPTION = "database exception";
	public static final String DATE_PARSING_EXCEPTION = "date parsing exception";
	public static final String TAPIZ = "tapiz";
	
	
	/**
	   The caller references the constants using <tt>Consts.EMPTY_STRING</tt>, 
	   and so on. Thus, the caller should be prevented from constructing objects of 
	   this class, by declaring this private constructor. 
	*/
	private Constants(){
	    throw new AssertionError();
	}
}
