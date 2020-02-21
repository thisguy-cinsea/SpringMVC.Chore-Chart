package com.github.thisguy_cinsea.model;

public interface UserInterface {
    String getUserId();
    String getFirstName();
    String getLastName();
    String getEmail();
    String getPassword();

//    void setUserId(String userId);
    void setFirstName(String firstName);
    void setLastName(String lastName);
    void setEmail(String email);
    void setPassword(String password);
}
