package com.github.thisguy_cinsea.dao;

import com.github.thisguy_cinsea.utils.jdbc.DBConnection;

import java.util.Map;

public interface CrudInterface<SomeModel> {
    DBConnection getDBConnection();

    Map<String, SomeModel> getByStatement(String query);

    String getTableName();

    SomeModel create(SomeModel model);

    SomeModel update(String noteId, SomeModel note);

    SomeModel delete(String noteId);

    SomeModel getById(String noteId);

    default Map<String, SomeModel> getAll() {
        return getAllWhere("true");
    }

    default Map<String, SomeModel> getAllWhere(String whereClause) {
        return getByStatement("SELECT * FROM `" + getTableName() + "` WHERE  (`is_deleted` <> 1 OR `is_deleted` IS NULL) AND " + whereClause);
    }
}
