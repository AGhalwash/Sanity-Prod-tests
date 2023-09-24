package com.stacks.bdd.restassured.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public class MethodJson implements Comparable<MethodJson> {
    public MethodJson() {

    }

    public MethodJson(Integer id,
            Integer centerId,
            String section,
            String field,
            String value,
            String comment,
            Integer editType,
            String context,
            String type,
            String keyComment,
            String keyCommentExtended,
            String tab,
            Date creationDate,
            String  installationCode,
            String jira,
            Date  activationDate,
            String method,
            String pendingStatus){
        this.id=id;
        this.centerId=centerId;
        this.section=section;
        this.field=field;
        this.value=value;
        this.comment=comment;
        this.editType=editType;
        this.context=context;
        this.type=type;
        this.keyComment=keyComment;
        this.keyCommentExtended=keyCommentExtended;
        this.tab=tab;
        this.creationDate=creationDate;
        this.installationCode=installationCode;
        this.jira=jira;
        this.activationDate=activationDate;
        this.method=method;
        this.pendingStatus=pendingStatus;
    }
    private Integer id;
    private Integer centerId;
    private String section;
    private String field;
    private String value;
    private String comment;
    private Integer editType;
    private String context;
    private String type;
    private String keyComment;
    private String keyCommentExtended;
    private String tab;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSSZ")
    private Date creationDate;
    private String  installationCode;
    private String jira;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date  activationDate;
    private String method;
    private String pendingStatus;

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        return (this.id).equals( ((MethodJson) obj). getId()) &&
                (this.centerId).equals( ((MethodJson) obj). getCenterId()) &&
                (this.section).equals( ((MethodJson) obj). getSection()) &&
                (this.field).equals( ((MethodJson) obj). getField()) &&
                (this.value).equals( ((MethodJson) obj). getValue()) &&
                (this.comment).equals( ((MethodJson) obj). getComment()) &&
                (this.editType).equals( ((MethodJson) obj). getEditType()) &&
                (this.context).equals( ((MethodJson) obj). getContext()) &&
                (this.type).equals( ((MethodJson) obj). getType()) &&
                (this.keyComment).equals( ((MethodJson) obj). getKeyComment()) &&
                (this.keyCommentExtended).equals( ((MethodJson) obj). getKeyCommentExtended()) &&
                (this.tab).equals( ((MethodJson) obj). getTab()) &&
                (this.creationDate.getTime())==( ((MethodJson) obj). getCreationDate().getTime()) &&
                (this.installationCode).equals( ((MethodJson) obj). getInstallationCode()) &&
                (this.jira).equals( ((MethodJson) obj). getJira()) &&
                (this.activationDate.getYear())==( ((MethodJson) obj). getActivationDate().getYear()) &&
                (this.activationDate.getDate())==( ((MethodJson) obj). getActivationDate().getDate()) &&
                (this.activationDate.getMonth())==( ((MethodJson) obj). getActivationDate().getMonth()) &&
                (this.method).equals( ((MethodJson) obj). getMethod()) &&
                (this.pendingStatus).equals( ((MethodJson) obj). getPendingStatus());
    }



    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getEditType() {
        return editType;
    }

    public void setEditType(Integer editType) {
        this.editType = editType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKeyComment() {
        return keyComment;
    }

    public void setKeyComment(String keyComment) {
        this.keyComment = keyComment;
    }

    public String getKeyCommentExtended() {
        return keyCommentExtended;
    }

    public void setKeyCommentExtended(String keyCommentExtended) {
        this.keyCommentExtended = keyCommentExtended;
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate)
    {
        this.creationDate = creationDate;
    }

    public String getInstallationCode() {
        return installationCode;
    }

    public void setInstallationCode(String installationCode) {
        this.installationCode = installationCode;
    }

    public String getJira() {
        return jira;
    }

    public void setJira(String jira) {
        this.jira = jira;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPendingStatus() {
        return pendingStatus;
    }

    public void setPendingStatus(String pendingStatus) {
        this.pendingStatus = pendingStatus;
    }


    @Override
    public int compareTo(MethodJson o) {
        return Integer.compare(id, o.getId());
    }
}
