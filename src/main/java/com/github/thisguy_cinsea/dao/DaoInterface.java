package com.github.thisguy_cinsea.dao;

import com.github.thisguy_cinsea.model.EntityInterface;
import com.github.thisguy_cinsea.utils.IOConsole;
import com.github.thisguy_cinsea.utils.jdbc.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public interface DaoInterface<SomeEntityInterface extends EntityInterface> {
    DBConnection getDBConnection();
    String getTableName();
    Map<String, SomeEntityInterface> getByStatement(String sqlQuery);
    SomeEntityInterface create(SomeEntityInterface entity);
    SomeEntityInterface update(String id, SomeEntityInterface entity);

    default Map<String, SomeEntityInterface> getByStatement(Function<ResultSet, SomeEntityInterface> function, String sqlQuery) {
        sqlQuery = sqlQuery + " AND (`is_deleted` <> 1 OR `is_deleted` IS NULL);";
        System.out.println("daointerface.getByStatement: " + sqlQuery);
        ResultSet results = getDBConnection().executeQuery(sqlQuery);
        Map<String, SomeEntityInterface> noteMap = new HashMap<>();
        try{
            while (results.next()){
                SomeEntityInterface note = function.apply(results);
                noteMap.put(note.getId(), note);
            }
        } catch (SQLException e) {
            new IOConsole(IOConsole.AnsiColor.BLUE).println("No record found");
        }
        return noteMap;
    }

    default Map<String, SomeEntityInterface> getAll() {
        return getByStatement("SELECT * FROM `"+ getTableName() + "` WHERE 1 = 1");
    }

    default SomeEntityInterface getById(String id) {
        Map<String, SomeEntityInterface> map = getByStatement("SELECT * FROM `" + getTableName() + "`" +
                " WHERE `id` = '" + id + "' ");
        if (map.isEmpty())
            return null;
        return map.values().iterator().next();
    }

    default SomeEntityInterface delete(String id) {
        SomeEntityInterface recordToDelete = getById(id);
        System.out.println(recordToDelete.getTableName());
        recordToDelete.setId(id);
        recordToDelete.setDeleted(true);
        String sqlStatement = "UPDATE `" + recordToDelete.getTableName() + "` SET `is_deleted` = 1 WHERE `id` = '"
                + recordToDelete.getId() +"';";
        System.out.println(sqlStatement);
        getDBConnection().executeStatement(sqlStatement);
        return recordToDelete;
    }
}
