package com.github.thisguy_cinsea.dao;

import com.github.thisguy_cinsea.model.PersonInterface;
import com.github.thisguy_cinsea.model.User;
import com.github.thisguy_cinsea.model.UserInterface;

import java.util.Map;

public interface UserDao {
    UserInterface getUserById(String userId);

    Map<String, UserInterface> getAllUsers();

    PersonInterface createUser(User user);

    UserInterface registerUser(User user);
}
