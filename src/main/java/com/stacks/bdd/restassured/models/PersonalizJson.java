package com.stacks.bdd.restassured.models;

public class PersonalizJson implements Comparable<PersonalizJson> {
    Integer userSettingDefinitionId;
    Integer userId;
    String section;
    String field;
    String value;
    public PersonalizJson(){

    }

    public PersonalizJson(Integer userSettingDefinitionId,
            Integer userId,
            String section,
            String field,
            String value){
        this.userSettingDefinitionId = userSettingDefinitionId;
        this.section = section;
        this.userId = userId;
        this.field = field;
        this.value = value;
    }



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

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        return (this.userSettingDefinitionId).equals( ((PersonalizJson) obj). getUserSettingDefinitionId()) &&
                (this.userId).equals( ((PersonalizJson) obj). getUserId()) &&
                (this.section).equals( ((PersonalizJson) obj). getSection()) &&
                (this.field).equals( ((PersonalizJson) obj). getField()) &&
                (this.value).equals( ((PersonalizJson) obj). getValue());
    }

    @Override
    public int compareTo(PersonalizJson o) {
        return Integer.compare(userId, o.getUserId());
    }
}
