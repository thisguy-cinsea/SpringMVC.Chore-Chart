package com.github.thisguy_cinsea.model;

public class UserBuilder {
    private String userId;
    private String firstName;
    private String groupId;
    private Boolean isDeleted;

    public UserBuilder setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public UserBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder setGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public UserBuilder setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public User build() {
        return new User(userId, firstName, groupId, isDeleted);
    }
}