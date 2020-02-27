package com.github.thisguy_cinsea.dao;

import com.github.thisguy_cinsea.model.*;
import com.github.thisguy_cinsea.utils.IOConsole;
import com.github.thisguy_cinsea.utils.jdbc.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public interface RegisteredUserDao {
    DBConnection getDBConnection();

    default Map<String, RegisteredUserInterface> getRegisteredUserByStatement(String sqlQuery) {
        sqlQuery = sqlQuery + " AND (`is_deleted` <> 1 OR `is_deleted` IS NULL);";
        System.out.println(sqlQuery);
        ResultSet results = getDBConnection().executeQuery(sqlQuery);
        Map<String, RegisteredUserInterface> registeredUserMap = new HashMap<>();

        try{
            while (results.next()){
                String registeredUserId = results.getString("userId");
                RegisteredUser registeredUser = new RegisteredUserBuilder()
                        .setUserId(registeredUserId)
                        .setFirstName(results.getString("firstName"))
                        .setGroupId(results.getString("groupId"))
//                        .setIsDeleted(results.getInt("is_deleted"))
                        .setLastName(results.getString("lastName"))
                        .setEmail(results.getString("email"))
                        .setRole(results.getString("role"))
//                        .setIsRegisteredDeleted(results.getInt("is_registration_deleted"))
                        .build();
                registeredUser.setUserId(registeredUserId);
                registeredUserMap.put(registeredUserId, registeredUser);
            }
        } catch (SQLException e) {
            new IOConsole(IOConsole.AnsiColor.BLUE).println("No record found");
//            throw new Error(e);
        }
        return registeredUserMap;
    }

    default Map<String, RegisteredUserInterface> getAllRegisteredUsers() {
        String sqlQuery = "SELECT `user_tbl`.`userId`, `user_tbl`.`firstName`, `user_tbl`.`groupId`, `user_tbl`.`is_deleted` AS `is_user_deleted`, "+
        "`reg_user_tbl`.`lastName`, `reg_user_tbl`.`email`, `reg_user_tbl`.`role`, `reg_user_tbl`.`is_registration_deleted` " +
        "FROM `user_tbl`, `reg_user_tbl` " +
//        "JOIN `reg_user_tbl` ON `userId`";
        "WHERE `user_tbl`.`userId` = `reg_user_tbl`.`userId`";
        return getRegisteredUserByStatement(sqlQuery);
    }

    default RegisteredUserInterface getResponsibilityById(String registeredUserId) {
        return null;
    }

    default RegisteredUserInterface createResponsibility(Responsibility registeredUser) {
        return null;
    }

    default RegisteredUserInterface updateResponsibility(String registeredUserId, Responsibility registeredUser) {
        return null;
    }

    default RegisteredUserInterface deleteResponsibility(String registeredUserId) {
        return null;
    }
}
