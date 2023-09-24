package com.stacks.bdd.restassured.models;

public class CodeMessageJson {
    private String code;
    private String message;

    public CodeMessageJson() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
