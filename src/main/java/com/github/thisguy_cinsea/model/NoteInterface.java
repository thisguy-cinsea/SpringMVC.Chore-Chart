package com.github.thisguy_cinsea.model;

public interface NoteInterface extends EntityInterface<String>{
//    String getId();
    String getMessage();
 Boolean getDeleted();

//    void setId(String id);
    void setMessage(String message);
    void setDeleted(Boolean deleted);
}
