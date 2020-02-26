package com.github.thisguy_cinsea.model;

import java.util.Date;

public class UserResponsibilityBuilder {
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

    public UserResponsibilityBuilder setUserResponsibilityId(String userResponsibilityId) {
        this.userResponsibilityId = userResponsibilityId;
        return this;
    }

    public UserResponsibilityBuilder setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public UserResponsibilityBuilder setResponsibilityId(String responsibilityId) {
        this.responsibilityId = responsibilityId;
        return this;
    }

    public UserResponsibilityBuilder setCreationId(String creationId) {
        this.creationId = creationId;
        return this;
    }

    public UserResponsibilityBuilder setCompletedId(String completedId) {
        this.completedId = completedId;
        return this;
    }

    public UserResponsibilityBuilder setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public UserResponsibilityBuilder setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public UserResponsibilityBuilder setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
        return this;
    }

    public UserResponsibilityBuilder setNoteId(String noteId) {
        this.noteId = noteId;
        return this;
    }

    public UserResponsibilityBuilder setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public UserResponsibility build() {
        return new UserResponsibility(userResponsibilityId, userId, responsibilityId, creationId, completedId, creationDate, dueDate, completionDate, noteId, isDeleted);
    }
}