package com.stacks.bdd.restassured.models;

import java.time.LocalDateTime;

public class LogoJson {
    public LogoJson() {

    }
    private String name ;
    private String data;
    private LocalDateTime date;
    private String extension;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }




}
