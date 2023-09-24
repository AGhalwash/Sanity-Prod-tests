package com.stacks.bdd.restassured.models;


public class PatchJson {
    public PatchJson() {

    }

    public PatchJson(Integer id,
                      Integer centerId,

                      String value
                      ){
        this.id=id;
        this.centerId=centerId;
        this.value=value;
    }
    private Integer id;
    private Integer centerId;
    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCenterId() {
        return centerId;
    }

    public void setCenterId(Integer centerId) {
        this.centerId = centerId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }



}
