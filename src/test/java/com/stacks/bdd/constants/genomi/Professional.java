package com.stacks.bdd.constants.genomi;

import java.util.EnumSet;

import org.apache.log4j.Logger;

import com.stacks.bdd.constants.core.IProfessional;

public enum Professional implements IProfessional{

	PROF_TEST("WHVLMTJYHNNKHHTC", "ALERGOLOGIA");
	
	static Logger logger = Logger.getLogger(Professional.class.getName());
	
	private final String name;
	private final String speciality;
	
	Professional(String name, String speciality) {
		this.name = name ;
		this.speciality = speciality ;
	}	
	
	public static Professional getProfessionalByName(String name) {
		logger.trace("getProfessional :: " + name);
		EnumSet<Professional> allProfessional = EnumSet.allOf( Professional.class);
		for( Professional professional : allProfessional) {
		    if (name.equals(professional.name)) {
				return professional;
			}
		}
		
		throw new IllegalArgumentException("Professional with name \"" + name + "\" not found.");
	}

	public static Professional getProfessionalBySpeciality(String speciality) {

		logger.trace("getProfessional :: " + speciality);
		EnumSet<Professional> allProfessional = EnumSet.allOf( Professional.class);
		for( Professional professional : allProfessional) {
		    if (speciality.equals(professional.speciality)) {
				return professional;
			}
		}
		
		throw new IllegalArgumentException("Professional with speciality \"" + speciality + "\" not found.");
	}

	public String getName() {
		return name;
	}

	public String getSpeciality() {
		return speciality;
	}
}
