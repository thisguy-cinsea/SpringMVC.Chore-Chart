package com.github.thisguy_cinsea.dao;

import com.github.thisguy_cinsea.model.Group;
import com.github.thisguy_cinsea.model.GroupInterface;
import java.util.Map;

public interface GroupDao extends DaoInterface<GroupInterface>{

    default Map<String, GroupInterface> getByStatement(String sqlQuery) {
        return getByStatement((results) -> {
            try {
                String groupId = results.getString("id");
                Group group = new Group(
                        groupId,
                        results.getString("groupName"),
                        results.getInt("is_Deleted"));
                group.setId(groupId);
                return group;
            } catch (Exception e) {
                throw new Error(e);
            }
        }, sqlQuery);
    }

    default GroupInterface create(GroupInterface group) {
        GroupInterface groupToCreate = new Group(group.getGroupName());
        String sqlStatement = "INSERT INTO `" + getTableName() + "` ( `id`, `groupName`) VALUES ('"+
                groupToCreate.getId() +"', '"+ groupToCreate.getGroupName() +"');";
        getDBConnection().executeStatement(sqlStatement);
        return groupToCreate;
    }

    default GroupInterface update(String groupId, GroupInterface group) {
        GroupInterface groupToUpdate = getById(groupId);
        groupToUpdate.setId(groupId);
        groupToUpdate.setGroupName(group.getGroupName());
        String sqlStatement = "UPDATE `" + getTableName() + "` SET `groupName` = '"+ groupToUpdate.getGroupName()
                +"' WHERE `id` = '"+ groupToUpdate.getId() +"';";
        getDBConnection().executeStatement(sqlStatement);
        return groupToUpdate;
    }
}