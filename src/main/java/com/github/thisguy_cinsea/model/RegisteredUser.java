package com.github.thisguy_cinsea.model;

public class RegisteredUser extends User implements RegisteredUserInterface {
    private String lastName;
    private String email;
    private String password;
    private String role;
    private Boolean isRegisteredDeleted;

    public RegisteredUser(String userId, String firstName, String groupId,
                          Boolean isDeleted, String lastName, String email,
                          String password, String role, Boolean isRegisteredDeleted) {
        super(userId, firstName, groupId, isDeleted);
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isRegisteredDeleted = isRegisteredDeleted;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public Boolean getRegisteredDeleted() {
        return isRegisteredDeleted;
    }

    @Override
    public void setRegisteredDeleted(Boolean registeredDeleted) {
        isRegisteredDeleted = registeredDeleted;
    }

    public String getTableName() {
        return "reg_user_tbl";
    }
    @Override
    public String toString() {
        return "RegisteredUser{" +
                "lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", isRegisteredDeleted=" + isRegisteredDeleted +
                '}';
    }
}