package com.github.thisguy_cinsea.dao;

import com.github.thisguy_cinsea.model.Group;
import com.github.thisguy_cinsea.model.User;
import com.github.thisguy_cinsea.model.UserBuilder;
import com.github.thisguy_cinsea.model.UserInterface;

import java.util.Map;

public interface UserDao extends DaoInterface<UserInterface> {
    @Override
    default Map<String, UserInterface> getByStatement(String sqlQuery) {
        return getByStatement((results) -> {
            try {
                String userId = results.getString("id");
                User user = new UserBuilder()
                        .setUserId(userId)
                        results.getString("firstName"),
                        results.getInt("is_Deleted"));
                user.setId(userId);
                return group;
            } catch (Exception e) {
                throw new Error(e);
            }
        }, sqlQuery);
    }

    @Override
    default UserInterface create(UserInterface entity) {
        return null;
    }

    @Override
    default UserInterface update(String id, UserInterface entity) {
        return null;
    }
}
