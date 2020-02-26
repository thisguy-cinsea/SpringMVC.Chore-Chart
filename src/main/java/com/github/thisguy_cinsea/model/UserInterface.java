package com.github.thisguy_cinsea.model;

public interface UserInterface {
    String getUserId();
    String getFirstName();
    String getGroupId();
    Boolean getDeleted();

    void setUserId(String userId);
    void setFirstName(String firstName);
    void setGroupId(String groupId);
    void setDeleted(Boolean deleted);
}
