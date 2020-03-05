package com.github.thisguy_cinsea.model;

public interface ResponsibilityInterface extends EntityInterface{
//    String getResponsibilityId();
    String getResponsibilityName();
    String getGroupId();

//    void setResponsibilityId(String responsibilityId);
    void setResponsibilityName(String responsibilityName);
    void setGroupId(String groupId);
}
