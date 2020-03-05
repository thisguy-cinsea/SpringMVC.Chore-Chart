package com.github.thisguy_cinsea.model;

import java.util.UUID;

public class User implements UserInterface{
    private String userId;
    private String firstName;
    private String groupId;
    private Boolean isDeleted;

    public User(String userId, String firstName, String groupId, Boolean isDeleted) {
        this.userId = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.groupId = groupId;
        this.isDeleted = isDeleted;
    }

    public User(String userId, String firstName, String groupId, int isDeleted) {
        this(userId, firstName, groupId, isDeleted == 1);
    }

    public User() {
    }

    @Override
    public String getId() {
        return userId;
    }

    @Override
    public void setId(String userId) {
        this.userId = userId;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getGroupId() {
        return groupId;
    }

    @Override
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String getTableName() {
        return "user_tbl";
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", groupId='" + groupId + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
