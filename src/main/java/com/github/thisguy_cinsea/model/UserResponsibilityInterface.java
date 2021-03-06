package com.github.thisguy_cinsea.model;

import java.util.Date;

public interface UserResponsibilityInterface extends EntityInterface{
    String getId();
    String getUserId();
    String getResponsibilityId();
    String getCreationId();
    String getCompletedId();
    Date getCreationDate();
    Date getDueDate();
    Date getCompletionDate();
    String getNoteId();

    void setId(String userResponsibilityId);
    void setUserId(String userId);
    void setResponsibilityId(String responsibilityId);
    void setCreationId(String creationId);
    void setCompletedId(String completedId);
    void setCreationDate(Date creationDate);
    void setDueDate(Date dueDate);
    void setCompletionDate(Date completionDate);
    void setNoteId(String noteId);
}
