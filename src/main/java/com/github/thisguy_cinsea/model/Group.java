package com.github.thisguy_cinsea.model;

import java.util.UUID;

public class Group implements GroupInterface {
    private String id;
    private String groupName;
    private Boolean isDeleted;

    public Group(String id, String groupName, Boolean isDeleted) {
        this.id = UUID.randomUUID().toString();
        this.groupName = groupName;
        this.isDeleted = isDeleted;
    }

    public Group(String id, String groupName, int isDeleted) {
        this(id, groupName, isDeleted == 1);
    }

    public Group(String groupName) {
        this(null, groupName, null);
    }

    public Group() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
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
    public String toString() {
        return "Group{" +
                "groupId='" + id + '\'' +
                ", groupName='" + groupName + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
