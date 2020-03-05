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

public interface RegisteredUserDao extends DaoInterface<RegisteredUserInterface>{

    default Map<String, RegisteredUserInterface> getByStatement(String sqlQuery) {
        sqlQuery = sqlQuery + " AND (`is_registration_deleted` <> 1 OR `is_registration_deleted` IS NULL)";
        return getByStatement((results) ->{
            try{
                String registeredUserId = results.getString("id");
                RegisteredUser registeredUser = new RegisteredUserBuilder()
                        .setId(registeredUserId)
                        .setFirstName(results.getString("firstName"))
                        .setGroupId(results.getString("groupId"))
                        .setLastName(results.getString("lastName"))
                        .setEmail(results.getString("email"))
                        .setRole(results.getString("role"))
                        .build();
                registeredUser.setId(registeredUserId);
                return registeredUser;
            } catch (SQLException e) {
                throw new Error(e);
            }
        }, sqlQuery);
    }

    default String sqlSelectQuery() {
        return "SELECT `user_tbl`.`id`, `user_tbl`.`firstName`, `user_tbl`.`groupId`, `user_tbl`.`is_deleted` AS `is_user_deleted`, " +
                "`reg_user_tbl`.`lastName`, `reg_user_tbl`.`email`, `reg_user_tbl`.`role`, `reg_user_tbl`.`is_registration_deleted` " +
                "FROM `reg_user_tbl` " +
                "JOIN `user_tbl` ON `reg_user_tbl`.`id` = `user_tbl`.`id` ";
    }

    default Map<String, RegisteredUserInterface> getAll() {
        String sqlQuery =  sqlSelectQuery() + "WHERE 1=1";
        return getByStatement(sqlQuery);
    }

//    default RegisteredUserInterface getRegisteredUserById(String registeredUserId) {
//        String sqlQuery = sqlSelectQuery() +  "WHERE `user_tbl`.`userId` = '" + registeredUserId + "'";
//        Map<String, RegisteredUserInterface> registeredUserMap = getRegisteredUserByStatement(sqlQuery);
//        if (registeredUserMap.isEmpty())
//            return null;
//        return registeredUserMap.values().iterator().next();
//
//    }

    default RegisteredUserInterface create(RegisteredUserInterface registeredUser) {
        boolean newGroupFlag = false;
        if (StringUtils.isBlank(registeredUser.getGroupId())){
            newGroupFlag = true;
            registeredUser.setGroupId(UUID.randomUUID().toString());
        }
        RegisteredUserInterface registeredUserToCreate = new RegisteredUserBuilder()
                .setId(registeredUser.getId())
                .setGroupId(registeredUser.getGroupId().isBlank() ? UUID.randomUUID().toString() : registeredUser.getGroupId())
                .setFirstName(registeredUser.getFirstName())
                .setLastName(registeredUser.getLastName())
                .setEmail(registeredUser.getEmail())
                .setPassword(hashPassword(registeredUser.getPassword()))
                .setRole("USER")
                .build();

        String sqlStatement = "";
        if (newGroupFlag){
            sqlStatement = "INSERT INTO `group_tbl` (`id`, `groupName`) VALUES ('" +
                    registeredUserToCreate.getGroupId() + "', '" +
                    registeredUser.getLastName() + " Household ');";
        }
        sqlStatement = sqlStatement +
                "INSERT INTO `user_tbl` (`id`, `firstName`, `groupId`) VALUES ('" +
                        registeredUserToCreate.getId() +"', '" +
                        registeredUserToCreate.getFirstName() +"', '" +
                        registeredUserToCreate.getGroupId() +"');" +
                "INSERT INTO `reg_user_tbl` (`id`, `lastName`, `PASSWORD`, `email`, `role`) VALUES ('" +
                        registeredUserToCreate.getId() +"', '" +
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

    default RegisteredUserInterface update(String registeredUserId, RegisteredUserInterface registeredUser) {
        RegisteredUserInterface registeredUserToUpdate = getById(registeredUserId);
        registeredUserToUpdate.setId(registeredUserId);
        registeredUserToUpdate.setFirstName(registeredUser.getFirstName());
        registeredUserToUpdate.setLastName(registeredUser.getLastName());
        registeredUserToUpdate.setEmail(registeredUser.getEmail());
        registeredUserToUpdate.setPassword(hashPassword(registeredUser.getPassword()));
        String sqlStatement = "UPDATE `" + getTableName() + "` SET `firstName` = '"+ registeredUserToUpdate.getFirstName()
                +"' WHERE `id` = '"+ registeredUserToUpdate.getId() +"';";
        sqlStatement = sqlStatement + "UPDATE `" + getTableName() + "` SET `lastName` = '" +
                registeredUserToUpdate.getLastName() + "', `email` = '" +
                registeredUserToUpdate.getEmail() + "', `password` = '" +
                registeredUserToUpdate.getPassword() +"' WHERE `userId` = '"+
                registeredUserToUpdate.getId() +"';";
        String[] statements = sqlStatement.split(";");
        for (String statement : statements) {
            getDBConnection().executeStatement(statement);
        }
        return registeredUserToUpdate;
    }

//    default RegisteredUserInterface deleteRegisteredUser(String registeredUserId) {
//        RegisteredUserInterface registeredUserToDelete = getRegisteredUserById(registeredUserId);
//        registeredUserToDelete.setId(registeredUserId);
//        registeredUserToDelete.setDeleted(true);
//        String sqlStatement = "UPDATE `reg_user_tbl` SET `is_registration_deleted` = 1 WHERE `userId` = '"
//                + registeredUserToDelete.getId() +"';";
//        getDBConnection().executeStatement(sqlStatement);
//        return registeredUserToDelete;
//    }
}
