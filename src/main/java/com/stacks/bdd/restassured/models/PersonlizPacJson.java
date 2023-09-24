package com.stacks.bdd.restassured.models;

public class PersonlizPacJson {
    Integer userSettingDefinitionId;
    Integer userId;

    public PersonlizPacJson() {

    }

    Integer pspId;
    Integer patientId;
    String value;
    public Integer getUserSettingDefinitionId() {
        return userSettingDefinitionId;
    }

    public void setUserSettingDefinitionId(Integer userSettingDefinitionId) {
        this.userSettingDefinitionId = userSettingDefinitionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPspId() {
        return pspId;
    }

    public void setPspId(Integer pspId) {
        this.pspId = pspId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
