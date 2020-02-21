package com.github.thisguy_cinsea.model;

import java.util.Date;
import java.util.UUID;

public class UserChores implements UserChoresInterface {
    private final String userChoresId;
    private String userId;
    private String choreId;
    private Date creationDate;
    private Date dueDate;
    private Date completionDate;
    private String note;

    public UserChores(String userChoresId, String userId, String choreId, Date creationDate, Date dueDate, Date completionDate, String note) {
        this.userChoresId = UUID.randomUUID().toString();
        this.userId = userId;
        this.choreId = choreId;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.completionDate = completionDate;
        this.note = note;
    }

    @Override
    public String getUserChoresId() {
        return userChoresId;
    }

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String getChoreId() {
        return choreId;
    }

    @Override
    public void setChoreId(String choreId) {
        this.choreId = choreId;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public Date getDueDate() {
        return dueDate;
    }

    @Override
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public Date getCompletionDate() {
        return completionDate;
    }

    @Override
    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    @Override
    public String getNote() {
        return note;
    }

    @Override
    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "UserChores{" +
                "userChoresId='" + userChoresId + '\'' +
                ", userId='" + userId + '\'' +
                ", choreId='" + choreId + '\'' +
                ", creationDate=" + creationDate +
                ", dueDate=" + dueDate +
                ", completionDate=" + completionDate +
                ", note='" + note + '\'' +
                '}';
    }
}
