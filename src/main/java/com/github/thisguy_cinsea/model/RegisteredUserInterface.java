package com.github.thisguy_cinsea.model;

public interface RegisteredUserInterface extends UserInterface {
//    String getUserId();
    String getLastName();
    String getEmail();
    String getPassword();
    String getRole();
    Boolean getRegisteredDeleted();

//    void setUserId(String userId);
    void setLastName(String lastName);
    void setEmail(String email);
    void setPassword(String password);
    void setRole(String role);
    void setRegisteredDeleted(Boolean deleted);
}
