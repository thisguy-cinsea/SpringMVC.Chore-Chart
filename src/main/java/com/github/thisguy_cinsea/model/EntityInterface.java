package com.github.thisguy_cinsea.model;

public interface EntityInterface<IdType> {
    String getTableName();
    String getId();
    Boolean getDeleted();


    void setId(String id);
    void setDeleted(Boolean deleted);
}
