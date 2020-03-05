package com.github.thisguy_cinsea.model;

import java.util.UUID;

public class Responsibility implements ResponsibilityInterface {

    private String responsibilityId;
    private String responsibilityName;
    private String groupId;
    private Boolean isDeleted;

    public Responsibility(String responsibilityId, String responsibilityName, String groupId, Boolean isDeleted) {
        this.responsibilityId = UUID.randomUUID().toString();
        this.responsibilityName = responsibilityName;
        this.groupId = groupId;
        this.isDeleted = isDeleted;
    }

    public Responsibility(String responsibilityId, String responsibilityName, String groupId, int isDeleted) {
        this(responsibilityId, responsibilityName, groupId, isDeleted == 1);
    }

    public Responsibility() {
    }

    public String getId() {
        return responsibilityId;
    }

    public void setId(String responsibilityId) {
        this.responsibilityId = responsibilityId;
    }

    @Override
    public String getResponsibilityName() {
        return responsibilityName;
    }

    @Override
    public void setResponsibilityName(String responsibilityName) {
        this.responsibilityName = responsibilityName;
    }

    public String getGroupId() {
        return groupId;
    }

    @Override
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public Boolean getDeleted() {
        return isDeleted;
    }

    @Override
    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getTableName() {
        return "responsibility_tbl";
    }

    @Override
    public String toString() {
        return "Responsibility{" +
                "responsibilityId='" + responsibilityId + '\'' +
                ", responsibilityName='" + responsibilityName + '\'' +
                ", groupId='" + groupId + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
