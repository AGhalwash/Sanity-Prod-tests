package com.stacks.bdd.constants.genomi;

import org.apache.log4j.Logger;

import com.stacks.bdd.constants.core.Constants;
import com.stacks.bdd.constants.core.IPatient;

import java.util.EnumSet;

public enum Patient implements IPatient{

    WITH_MANDATORY_FIELDS_DKV("TEST01", "TEST01", "SURNAMEB", "M", "11/01/1945", "333", "TEST@STACKS.ES", "2", "18105321C", "DKV", "EMPLEADOS DKV"),
    ORIGIN_MERGE_PATIENT("PRUEBA001", "PRUEBA001", "PRUEBA001", "", "", "", "", "", "", "", ""),
    DESTINATION_MERGE_PATIENT("PRUEBA002", "PRUEBA002", "PRUEBA002", "", "", "", "", "", "", "", ""),
    FORCE_APPOINTMENT_PATIENT("SILVIA", "TEST", "", "", "", "", "", "", "", "", ""),
    VAL_COVERAGE_PATIENT("PRUEBA001", "PRUEBA001", "PRUEBA001", "", "", "", "", "", "", "", ""),
    PRUEBA_PRUEBA_PATIENT("PRUEBA", "PRUEBA", "PRUEBA", "", "", "", "", "", "", "", "");

    static Logger logger = Logger.getLogger(Patient.class.getName());

    private final String name;
    private final String surNameA;
    private final String surNameB;
    private final String sex;
    private final String birthdate;
    private final String phone;
    private final String email;
    private final String typeDocument;
    private final String document;
    private final String coverage;
    private final String clientType;

    Patient(
            String name,
            String surNameA,
            String surNameB,
            String sex,
            String birthdate,
            String phone,
            String email,
            String typeDocument,
            String document,
            String coverage,
            String clientType) {
        this.name = name;
        this.surNameA = surNameA;
        this.surNameB = surNameB;
        this.sex = sex;
        this.birthdate = birthdate;
        this.phone = phone;
        this.email = email;
        this.typeDocument = typeDocument;
        this.document = document;
        this.coverage = coverage;
        this.clientType = clientType;
    }

    public String getName() {
        return name;
    }

    public String getSurNameA() {
        return surNameA;
    }

    public String getSurNameB() {
        return surNameB;
    }

    public String getSex() {
        return sex;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public String getDocument() {
        return document;
    }

    public String getCoverage() {
        return coverage;
    }

    public String getClientType() {
        return clientType;
    }

    public String getFullNameDietaryFormat(){
        return surNameA + " " + surNameB + ", " + name ;
    }

    public static Patient getPatientByName(String name) {
        logger.trace("getPatientByName :: " + name);
        EnumSet<Patient> allPatients = EnumSet.allOf(Patient.class);
        for (Patient patient : allPatients) {
            if (name.equals(patient.name)) {
                return patient;
            }
        }

        throw new IllegalArgumentException("Patient with name \"" + name + Constants.NOT_FOUND);
    }
}