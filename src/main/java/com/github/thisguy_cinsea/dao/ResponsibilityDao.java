package com.github.thisguy_cinsea.dao;

import com.github.thisguy_cinsea.model.*;
import com.github.thisguy_cinsea.utils.IOConsole;
import com.github.thisguy_cinsea.utils.jdbc.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public interface ResponsibilityDao {
    DBConnection getDBConnection();

    default Map<String, ResponsibilityInterface> getResponsibilityByStatement(String sqlQuery) {
        sqlQuery = sqlQuery + " AND (`is_deleted` <> 1 OR `is_deleted` IS NULL);";
        ResultSet results = getDBConnection().executeQuery(sqlQuery);
        Map<String, ResponsibilityInterface> responsibilityMap = new HashMap<>();
        try{
            while (results.next()){
                String responsibilityId = results.getString("responsibilityId");
                System.out.println(responsibilityId);
                Responsibility responsibility = new ResponsibilityBuilder()
                        .setResponsibilityId(responsibilityId)
                        .setResponsibilityName(results.getString("responsibilityName"))
                        .setGroupId(results.getString("groupId"))
                        .setIsDeleted(results.getInt("is_Deleted"))
                        .build();
                responsibility.setResponsibilityId(responsibilityId);
                responsibilityMap.put(responsibilityId, responsibility);
            }
        } catch (SQLException e) {
            new IOConsole(IOConsole.AnsiColor.BLUE).println("No record found");
//            throw new Error(e);
        }
        return responsibilityMap;
    }

    default Map<String, ResponsibilityInterface> getAllResponsibilities() {
        return getResponsibilityByStatement("SELECT * FROM `responsibility_tbl` WHERE 1 = 1");
    }

    default ResponsibilityInterface getResponsibilityById(String responsibilityId) {
        Map<String, ResponsibilityInterface> responsibilityMap = getResponsibilityByStatement("SELECT * FROM `responsibility_tbl`" +
                "WHERE `responsibilityId` = '" + responsibilityId + "'");
        if (responsibilityMap.isEmpty())
            return null;
        return responsibilityMap.values().iterator().next();
    }

    default ResponsibilityInterface createResponsibility(Responsibility responsibility) {
        ResponsibilityInterface responsibilityToCreate = new ResponsibilityBuilder()
                .setResponsibilityName(responsibility.getResponsibilityName())
                .setGroupId(responsibility.getGroupId())
                .build();
        System.out.println(responsibilityToCreate);
        String sqlStatement = "INSERT INTO `responsibility_tbl` ( `responsibilityId`, `responsibilityName`, `groupId` ) VALUES ('"+
                responsibilityToCreate.getResponsibilityId() +"', '"+
                responsibilityToCreate.getResponsibilityName() +"', '" +
                responsibilityToCreate.getGroupId() + "');";
        System.out.println(sqlStatement);
        getDBConnection().executeStatement(sqlStatement);
        return responsibilityToCreate;
    }

    default ResponsibilityInterface updateResponsibility(String responsibilityId, ResponsibilityInterface responsibility) {
        ResponsibilityInterface responsibilityToUpdate = getResponsibilityById(responsibilityId);
        responsibilityToUpdate.setResponsibilityId(responsibilityId);
        responsibilityToUpdate.setResponsibilityName(responsibility.getResponsibilityName());
        responsibilityToUpdate.setGroupId(responsibility.getGroupId());
        String sqlStatement = "UPDATE `responsibility_tbl` " +
                "SET `responsibilityName` = '"+ responsibilityToUpdate.getResponsibilityName() +"' " +
                "`groupId` = '" + responsibilityToUpdate.getGroupId() + "' " +
                "WHERE `responsibilityId` = '"+ responsibilityToUpdate.getResponsibilityId() +"';";
        getDBConnection().executeStatement(sqlStatement);
        return responsibilityToUpdate;
    }

    default ResponsibilityInterface deleteResponsibility(String responsibilityId) {
        ResponsibilityInterface responsibilityToDelete = getResponsibilityById(responsibilityId);
        responsibilityToDelete.setResponsibilityId(responsibilityId);
        responsibilityToDelete.setDeleted(true);
        String sqlStatement = "UPDATE `responsibility_tbl` SET `is_deleted` = 1 WHERE `responsibilityId` = '"
                + responsibilityToDelete.getResponsibilityId() +"';";
        getDBConnection().executeStatement(sqlStatement);
        return responsibilityToDelete;
    }
}
