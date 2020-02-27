package com.github.thisguy_cinsea.dao;

import com.github.thisguy_cinsea.model.Group;
import com.github.thisguy_cinsea.model.GroupInterface;
import com.github.thisguy_cinsea.model.Note;
import com.github.thisguy_cinsea.model.NoteInterface;
import com.github.thisguy_cinsea.utils.IOConsole;
import com.github.thisguy_cinsea.utils.jdbc.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public interface GroupDao {
    DBConnection getDBConnection();

    default Map<String, GroupInterface> getGroupByStatement(String sqlQuery) {
        sqlQuery = sqlQuery + " AND `is_deleted` <> 1 OR `is_deleted` IS NULL;";
        ResultSet results = getDBConnection().executeQuery(sqlQuery);
        Map<String, GroupInterface> groupMap = new HashMap<>();
        try{
            while (results.next()){
                String groupId = results.getString("groupId");
                System.out.println(groupId);
                Group group = new Group(
                        groupId,
                        results.getString("groupName"),
                        results.getInt("is_Deleted"));
                group.setGroupId(groupId);
                groupMap.put(groupId, group);
            }
        } catch (SQLException e) {
            new IOConsole(IOConsole.AnsiColor.BLUE).println("No record found");
//            throw new Error(e);
        }
        return groupMap;
    }

    default Map<String, GroupInterface> getAllGroups() {
        return getGroupByStatement("SELECT * FROM `group_tbl` WHERE 1 = 1");
    }

    default GroupInterface getGroupById(String groupId) {
        Map<String, GroupInterface> groupMap = getGroupByStatement("SELECT * FROM `group_tbl`" +
                "WHERE `groupId` = '" + groupId + "'");
        if (groupMap.isEmpty())
            return null;
        return groupMap.values().iterator().next();
    }

    default GroupInterface createGroup(Group group) {
        GroupInterface groupToCreate = new Group(group.getGroupName());
        String sqlStatement = "INSERT INTO `group_tbl` ( `groupId`, `groupName`) VALUES ('"+
                groupToCreate.getGroupId() +"', '"+ groupToCreate.getGroupName() +"');";
        getDBConnection().executeStatement(sqlStatement);
        return groupToCreate;
    }

    default GroupInterface updateGroup(String groupId, GroupInterface group) {
        GroupInterface groupToUpdate = getGroupById(groupId);
        groupToUpdate.setGroupId(groupId);
        groupToUpdate.setGroupName(group.getGroupName());
        String sqlStatement = "UPDATE `group_tbl` SET `groupName` = '"+ groupToUpdate.getGroupName()
                +"' WHERE `groupId` = '"+ groupToUpdate.getGroupId() +"';";
        getDBConnection().executeStatement(sqlStatement);
        return groupToUpdate;
    }

    default GroupInterface deleteGroup(String groupId) {
        GroupInterface groupToUpdate = getGroupById(groupId);
        groupToUpdate.setGroupId(groupId);
        groupToUpdate.setDeleted(true);
        String sqlStatement = "UPDATE `group_tbl` SET `is_deleted` = 1 WHERE `groupId` = '"
                + groupToUpdate.getGroupId() +"';";
        getDBConnection().executeStatement(sqlStatement);
        return groupToUpdate;
    }
}
