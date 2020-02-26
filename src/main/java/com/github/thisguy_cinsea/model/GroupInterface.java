package com.github.thisguy_cinsea.model;

public interface GroupInterface {
    String name = new String();
    String getGroupId();
    String getGroupName();
    Boolean getDeleted();

    void setGroupId(String groupId);
    void setGroupName(String groupName);
    void setDeleted(Boolean deleted);
}
