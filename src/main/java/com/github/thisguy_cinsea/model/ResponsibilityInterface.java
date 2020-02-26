package com.github.thisguy_cinsea.model;

public interface ResponsibilityInterface {
    String getResponsibilityId();
    String getResponsibilityName();
    String getGroupId();
    Boolean getDeleted();

    void setResponsibilityId(String responsibilityId);
    void setResponsibilityName(String responsibilityName);
    void setGroupId(String groupId);
    void setDeleted(Boolean deleted);
}
