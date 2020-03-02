package com.github.thisguy_cinsea.dao;

import com.github.thisguy_cinsea.model.*;
import com.github.thisguy_cinsea.utils.IOConsole;
import com.github.thisguy_cinsea.utils.jdbc.DBConnection;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public interface RegisteredUserDao {
    DBConnection getDBConnection();

    default Map<String, RegisteredUserInterface> getRegisteredUserByStatement(String sqlQuery) {
        sqlQuery = sqlQuery + " AND (`is_registration_deleted` <> 1 OR `is_registration_deleted` IS NULL);";
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

    default String sqlSelectQuery() {
        return "SELECT `user_tbl`.`userId`, `user_tbl`.`firstName`, `user_tbl`.`groupId`, `user_tbl`.`is_deleted` AS `is_user_deleted`, " +
                "`reg_user_tbl`.`lastName`, `reg_user_tbl`.`email`, `reg_user_tbl`.`role`, `reg_user_tbl`.`is_registration_deleted` " +
                "FROM `reg_user_tbl` " +
                "JOIN `user_tbl` ON `reg_user_tbl`.`userId` = `user_tbl`.`userId` ";
    }

    default Map<String, RegisteredUserInterface> getAllRegisteredUsers() {
        String sqlQuery =  sqlSelectQuery() + "WHERE 1=1";
        return getRegisteredUserByStatement(sqlQuery);
    }

    default RegisteredUserInterface getRegisteredUserById(String registeredUserId) {
        String sqlQuery = sqlSelectQuery() +  "WHERE `user_tbl`.`userId` = '" + registeredUserId + "'";
        Map<String, RegisteredUserInterface> registeredUserMap = getRegisteredUserByStatement(sqlQuery);
        if (registeredUserMap.isEmpty())
            return null;
        return registeredUserMap.values().iterator().next();

    }

    default RegisteredUserInterface createRegisteredUser(RegisteredUser registeredUser) {
        boolean newGroupFlag = false;
        if (StringUtils.isBlank(registeredUser.getGroupId())){
            newGroupFlag = true;
            registeredUser.setGroupId(UUID.randomUUID().toString());
        }
        RegisteredUserInterface registeredUserToCreate = new RegisteredUserBuilder()
                .setUserId(registeredUser.getUserId())
                .setGroupId(registeredUser.getGroupId().isBlank() ? UUID.randomUUID().toString() : registeredUser.getGroupId())
                .setFirstName(registeredUser.getFirstName())
                .setLastName(registeredUser.getLastName())
                .setEmail(registeredUser.getEmail())
                .setPassword(hashPassword(registeredUser.getPassword()))
                .setRole("USER")
                .build();
        System.out.println(registeredUserToCreate);

        String sqlStatement = "";
        if (newGroupFlag){
            sqlStatement = "INSERT INTO `group_tbl` (`groupId`, `groupName`) VALUES ('" +
                    registeredUserToCreate.getGroupId() + "', '" +
                    registeredUser.getLastName() + " Household ');";
        }
        sqlStatement = sqlStatement +
                "INSERT INTO `user_tbl` (`userId`, `firstName`, `groupId`) VALUES ('" +
                        registeredUserToCreate.getUserId() +"', '" +
                        registeredUserToCreate.getFirstName() +"', '" +
                        registeredUserToCreate.getGroupId() +"');" +
                "INSERT INTO `reg_user_tbl` (`userId`, `lastName`, `PASSWORD`, `email`, `role`) VALUES ('" +
                        registeredUserToCreate.getUserId() +"', '" +
                        registeredUserToCreate.getLastName() + "', '" +
                        registeredUserToCreate.getPassword() + "', '" +
                        registeredUserToCreate.getEmail() + "', '" +
                        registeredUserToCreate.getRole() + "');";
        String[] statements = sqlStatement.split(";");
        for (String statement : statements) {
            getDBConnection().executeStatement(statement);
        }
        return registeredUserToCreate;
    }

    default String hashPassword(String plainTextPassword){
       return new BCryptPasswordEncoder().encode(plainTextPassword);
    }

    default RegisteredUserInterface updateRegisteredUser(String registeredUserId, RegisteredUser registeredUser) {
        RegisteredUserInterface registeredUserToUpdate = getRegisteredUserById(registeredUserId);
        registeredUserToUpdate.setUserId(registeredUserId);
        registeredUserToUpdate.setFirstName(registeredUser.getFirstName());
        registeredUserToUpdate.setLastName(registeredUser.getLastName());
        registeredUserToUpdate.setEmail(registeredUser.getEmail());
        registeredUserToUpdate.setPassword(hashPassword(registeredUser.getPassword()));
        String sqlStatement = "UPDATE `user_tbl` SET `firstName` = '"+ registeredUserToUpdate.getFirstName()
                +"' WHERE `userId` = '"+ registeredUserToUpdate.getUserId() +"';";
        sqlStatement = sqlStatement + "UPDATE `reg_user_tbl` SET `lastName` = '" +
                registeredUserToUpdate.getLastName() + "', `email` = '" +
                registeredUserToUpdate.getEmail() + "', `password` = '" +
                registeredUserToUpdate.getPassword() +"' WHERE `userId` = '"+
                registeredUserToUpdate.getUserId() +"';";
        String[] statements = sqlStatement.split(";");
        for (String statement : statements) {
            getDBConnection().executeStatement(statement);
        }
        return registeredUserToUpdate;
    }

    default RegisteredUserInterface deleteRegisteredUser(String registeredUserId) {
        RegisteredUserInterface registeredUserToDelete = getRegisteredUserById(registeredUserId);
        registeredUserToDelete.setUserId(registeredUserId);
        registeredUserToDelete.setDeleted(true);
        String sqlStatement = "UPDATE `reg_user_tbl` SET `is_registration_deleted` = 1 WHERE `userId` = '"
                + registeredUserToDelete.getUserId() +"';";
        getDBConnection().executeStatement(sqlStatement);
        return registeredUserToDelete;
    }
}
