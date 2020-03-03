package com.github.thisguy_cinsea.model;

import java.io.Serializable;

public interface EntityInterface<SomeSerializable extends Serializable> {
    SomeSerializable getId();
    void setId(SomeSerializable id);
}
