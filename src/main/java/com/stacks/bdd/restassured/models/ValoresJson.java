package com.stacks.bdd.restassured.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ValoresJson implements Comparable<ValoresJson> {
    private Integer id;
    private String section;
    private String element;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date value;
    private String description;

    public ValoresJson() {
    }

    public ValoresJson(Integer id, String section, String element, Date value, String description) {
        this.id = id;
        this.section = section;
        this.element = element;
        this.value = value;
        this.description = description;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        return (this.description).equals( ((ValoresJson) obj). getDescription()) &&
                (this.id).equals( ((ValoresJson) obj). getId()) &&
                (this.section).equals( ((ValoresJson) obj). getSection()) &&
                (this.element).equals( ((ValoresJson) obj). getElement()) &&
                (this.value.getYear())==( ((ValoresJson) obj). getValue().getYear())  &&
                (this.value.getMonth())==( ((ValoresJson) obj). getValue().getMonth()) &&
                (this.value.getDate())==( ((ValoresJson) obj). getValue().getDate());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public Date getValue() {
        return value;
    }

    public void setValue(Date value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




    @Override
    public int compareTo(ValoresJson o) {
        return 0;
    }
}
