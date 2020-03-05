package com.github.thisguy_cinsea.model;

public interface UserInterface extends EntityInterface{
//    String getUserId();
    String getFirstName();
    String getGroupId();

//    void setUserId(String userId);
    void setFirstName(String firstName);
    void setGroupId(String groupId);
}
