package com.github.thisguy_cinsea.dao;

import com.github.thisguy_cinsea.model.*;
import com.github.thisguy_cinsea.utils.IOConsole;
import com.github.thisguy_cinsea.utils.jdbc.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public interface ResponsibilityDao extends DaoInterface<ResponsibilityInterface> {

    default Map<String, ResponsibilityInterface> getByStatement(String sqlQuery) {
        return getByStatement((results) -> {
            try{
                String responsibilityId = results.getString("id");
                Responsibility responsibility = new ResponsibilityBuilder()
                        .setId(responsibilityId)
                        .setResponsibilityName(results.getString("responsibilityName"))
                        .setGroupId(results.getString("groupId"))
                        .setIsDeleted(results.getInt("is_Deleted"))
                        .build();
                responsibility.setId(responsibilityId);
                return responsibility;
            } catch (SQLException e) {
                throw new Error(e);
            }
        }, sqlQuery);
    }

//    default Map<String, ResponsibilityInterface> getAllResponsibilities() {
//        return getResponsibilityByStatement("SELECT * FROM `responsibility_tbl` WHERE 1 = 1");
//    }

//    default ResponsibilityInterface getById(String responsibilityId) {
//        Map<String, ResponsibilityInterface> responsibilityMap = getResponsibilityByStatement("SELECT * FROM `responsibility_tbl`" +
//                "WHERE `responsibilityId` = '" + responsibilityId + "'");
//        if (responsibilityMap.isEmpty())
//            return null;
//        return responsibilityMap.values().iterator().next();
//    }

    default ResponsibilityInterface create(ResponsibilityInterface responsibility) {
        ResponsibilityInterface responsibilityToCreate = new ResponsibilityBuilder()
                .setResponsibilityName(responsibility.getResponsibilityName())
                .setGroupId(responsibility.getGroupId())
                .build();
        String sqlStatement = "INSERT INTO `" + getTableName() + "` ( `id`, `responsibilityName`, `groupId` ) VALUES ('"+
                responsibilityToCreate.getId() +"', '"+
                responsibilityToCreate.getResponsibilityName() +"', '" +
                responsibilityToCreate.getGroupId() + "');";
        getDBConnection().executeStatement(sqlStatement);
        return responsibilityToCreate;
    }

    default ResponsibilityInterface update(String responsibilityId, ResponsibilityInterface responsibility) {
        ResponsibilityInterface responsibilityToUpdate = getById(responsibilityId);
        responsibilityToUpdate.setId(responsibilityId);
        responsibilityToUpdate.setResponsibilityName(responsibility.getResponsibilityName());
        responsibilityToUpdate.setGroupId(responsibility.getGroupId());
        String sqlStatement = "UPDATE `" + getTableName() + "` " +
                "SET `responsibilityName` = '"+ responsibilityToUpdate.getResponsibilityName() +"', " +
                "`groupId` = '" + responsibilityToUpdate.getGroupId() + "' " +
                "WHERE `id` = '"+ responsibilityToUpdate.getId() +"';";
        System.out.println(sqlStatement);
        getDBConnection().executeStatement(sqlStatement);
        return responsibilityToUpdate;
    }

//    default ResponsibilityInterface deleteResponsibility(String responsibilityId) {
//        ResponsibilityInterface responsibilityToDelete = getResponsibilityById(responsibilityId);
//        responsibilityToDelete.setId(responsibilityId);
//        responsibilityToDelete.setDeleted(true);
//        String sqlStatement = "UPDATE `responsibility_tbl` SET `is_deleted` = 1 WHERE `responsibilityId` = '"
//                + responsibilityToDelete.getId() +"';";
//        getDBConnection().executeStatement(sqlStatement);
//        return responsibilityToDelete;
//    }
}
