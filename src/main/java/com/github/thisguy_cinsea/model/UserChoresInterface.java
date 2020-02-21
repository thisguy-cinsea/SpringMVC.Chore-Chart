package com.github.thisguy_cinsea.model;

import java.util.Date;

public interface UserChoresInterface {
    String getUserChoresId();
    String getUserId();
    String getChoreId();
    Date getCreationDate();
    Date getDueDate();
    Date getCompletionDate();
    String getNote();

//    void setUserChoresId(String userChoresId);
    void setUserId(String userId);
    void setChoreId(String choreId);
    void setCreationDate(Date creationDate);
    void setDueDate(Date dueDate);
    void setCompletionDate(Date completionDate);
    void setNote(String note);
}
