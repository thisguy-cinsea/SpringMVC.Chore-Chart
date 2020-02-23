package com.github.thisguy_cinsea.model;

public interface UserInterface extends PersonInterface {
    String getLastName();
    String getEmail();
    String getPassword();

    void setLastName(String lastName);
    void setEmail(String email);
    void setPassword(String password);
}
