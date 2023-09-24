package com.stacks.bdd.restassured.models;

public class LookUpJson implements Comparable<LookUpJson>{
    private String code;
    private String description;
    private String descriptionKey;
    public LookUpJson(){

    }

    public LookUpJson(String description, String descriptionKey,
                      String code){
        this.description= description;
        this.descriptionKey= descriptionKey;
        this.code= code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionKey() {
        return descriptionKey;
    }

    public void setDescriptionKey(String descriptionKey) {
        this.descriptionKey = descriptionKey;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        return (this.description).equals( ((LookUpJson) obj). getDescription()) &&
                (this.descriptionKey).equals( ((LookUpJson) obj). getDescriptionKey()) &&
                (this.code).equals( ((LookUpJson) obj). getCode());
    }

    @Override
    public int compareTo(LookUpJson o) {
        return Integer.compare(code.charAt(0), o.getCode().charAt(0));
    }


}

