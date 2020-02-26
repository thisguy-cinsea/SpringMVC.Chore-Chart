package com.github.thisguy_cinsea.model;

public class RegisteredUserBuilder {
    private String userId;
    private String firstName;
    private String groupId;
    private Boolean isDeleted;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private Boolean isRegisteredDeleted;

    public RegisteredUserBuilder setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public RegisteredUserBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public RegisteredUserBuilder setGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public RegisteredUserBuilder setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public RegisteredUserBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public RegisteredUserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public RegisteredUserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public RegisteredUserBuilder setRole(String role) {
        this.role = role;
        return this;
    }

    public RegisteredUserBuilder setIsRegisteredDeleted(Boolean isRegisteredDeleted) {
        this.isRegisteredDeleted = isRegisteredDeleted;
        return this;
    }

    public RegisteredUser build() {
        return new RegisteredUser(userId, firstName, groupId, isDeleted, lastName, email, password, role, isRegisteredDeleted);
    }
}