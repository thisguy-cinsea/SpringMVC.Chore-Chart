package com.github.thisguy_cinsea.model;

import java.util.Date;
import java.util.UUID;

public class UserResponsibility implements UserResponsibilityInterface {
    private String userResponsibilityId;
    private String userId;
    private String responsibilityId;
    private String creationId;
    private String completedId;
    private Date creationDate;
    private Date dueDate;
    private Date completionDate;
    private String noteId;
    private Boolean isDeleted;

    public UserResponsibility(String userResponsibilityId, String userId, String responsibilityId,
                              String creationId, String completedId, Date creationDate, Date dueDate,
                              Date completionDate, String noteId, Boolean isDeleted) {
        this.userResponsibilityId = UUID.randomUUID().toString();
        this.userId = userId;
        this.responsibilityId = responsibilityId;
        this.creationId = creationId;
        this.completedId = completedId;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.completionDate = completionDate;
        this.noteId = noteId;
        this.isDeleted = isDeleted;
    }

    public UserResponsibility() {
    }

    @Override
    public String getId() {
        return userResponsibilityId;
    }

    @Override
    public void setId(String userResponsibilityId) {
        this.userResponsibilityId = userResponsibilityId;
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
    public String getResponsibilityId() {
        return responsibilityId;
    }

    @Override
    public void setResponsibilityId(String responsibilityId) {
        this.responsibilityId = responsibilityId;
    }

    @Override
    public String getCreationId() {
        return creationId;
    }

    @Override
    public void setCreationId(String creationId) {
        this.creationId = creationId;
    }

    @Override
    public String getCompletedId() {
        return completedId;
    }

    @Override
    public void setCompletedId(String completedId) {
        this.completedId = completedId;
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
    public String getNoteId() {
        return noteId;
    }

    @Override
    public void setNoteId(String noteId) {
        this.noteId = noteId;
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
    public String getTableName() {
        return "user_responsibility_tbl";
    }

    @Override
    public String toString() {
        return "UserResponsibility{" +
                "userResponsibilityId='" + userResponsibilityId + '\'' +
                ", userId='" + userId + '\'' +
                ", responsibilityId='" + responsibilityId + '\'' +
                ", creationId='" + creationId + '\'' +
                ", completedId='" + completedId + '\'' +
                ", creationDate=" + creationDate +
                ", dueDate=" + dueDate +
                ", completionDate=" + completionDate +
                ", noteId='" + noteId + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
