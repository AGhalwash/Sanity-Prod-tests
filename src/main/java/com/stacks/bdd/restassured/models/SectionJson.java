package com.stacks.bdd.restassured.models;

public class SectionJson implements Comparable<SectionJson>{
    private String key;
    private String value;

    public SectionJson() {

    }
    public SectionJson(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int compareTo(SectionJson o) {
        if(value==null || o.getValue()==null)
            return -1;
        return Integer.compare(value.charAt(0), o.getValue().charAt(0));
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if(this.value==null && ((SectionJson) obj). getValue()==null )
            return true;
        return (this.key).equals( ((SectionJson) obj). getKey()) &&
                (this.value).equals( ((SectionJson) obj). getValue()) ;
    }
}
