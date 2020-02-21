package com.github.thisguy_cinsea.model;

import java.util.UUID;

public class Chore implements ChoreInterface{

    private final String choreId;
    private String choreName;

    public Chore(String choreId, String choreName) {
        this.choreId = UUID.randomUUID().toString();
        this.choreName = choreName;
    }

    public Chore(String choreName) {
        this(null, choreName);
    }

    public Chore() {
        this(null, null);
    }

    public String getChoreId() {
        return choreId;
    }

    public String getChoreName() {
        return choreName;
    }

    public void setChoreName(String choreName) {
        this.choreName = choreName;
    }

    @Override
    public String toString() {
        return "Chore{" +
                "choreId='" + choreId + '\'' +
                ", choreName='" + choreName + '\'' +
                '}';
    }
}
