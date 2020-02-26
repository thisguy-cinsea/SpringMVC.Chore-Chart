package com.github.thisguy_cinsea.dao;

import com.github.thisguy_cinsea.model.UserInterface;
import com.github.thisguy_cinsea.model.User;

import java.util.Map;

public interface UserDao {
    UserInterface getUserById(String userId);

    Map<String, UserInterface> getAllUsers();

    UserInterface createUser(User user);

    UserInterface registerUser(User user);
}
