package com.stacks.bdd.restassured.models;

import java.util.Date;

public class PatientsGroupsJson implements Comparable<PatientsGroupsJson>{
    private Integer id;
    private Integer groupId;
    private Integer patientId;
    private Date linkDate;

    public PatientsGroupsJson(){

    }

    public PatientsGroupsJson(Integer id, Integer groupId,
                              Integer patientId,Date linkDate){
       this.id = id;
       this.groupId = groupId;
       this.patientId = patientId;
       this.linkDate = linkDate;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Date getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(Date linkDate) {
        this.linkDate = linkDate;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        return (this.id).equals( ((PatientsGroupsJson) obj). getId()) &&
                (this.groupId).equals( ((PatientsGroupsJson) obj). getGroupId()) &&
                (this.patientId).equals( ((PatientsGroupsJson) obj). getPatientId()) &&
                (this.linkDate).equals( ((PatientsGroupsJson) obj). getLinkDate());
    }

    @Override
    public int compareTo(PatientsGroupsJson o) {
        return Integer.compare((id),o.getId());
    }
}