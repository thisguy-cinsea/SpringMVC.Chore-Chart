package com.github.thisguy_cinsea.model;

import java.util.UUID;

public class Group implements GroupInterface {
    private String groupId;
    private String groupName;
    private Boolean isDeleted;

    public Group(String groupId, String groupName, Boolean isDeleted) {
        this.groupId = UUID.randomUUID().toString();
        this.groupName = groupName;
        this.isDeleted = isDeleted;
    }

    public Group(String groupId, String groupName, int isDeleted) {
        this(groupId, groupName, isDeleted == 1);
    }

    public Group(String groupName) {
        this(null, groupName, null);
    }

    public Group() {
    }

    @Override
    public String getId() {
        return groupId;
    }

    @Override
    public void setId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public String getGroupName() {
        return groupName;
    }

    @Override
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public Boolean getDeleted() {
        return isDeleted;
    }

    @Override
    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String getTableName() {
        return "group_tbl";
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
