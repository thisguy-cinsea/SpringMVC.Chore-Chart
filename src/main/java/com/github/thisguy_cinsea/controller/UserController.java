package com.github.thisguy_cinsea.controller;

import com.github.thisguy_cinsea.model.PersonInterface;
import com.github.thisguy_cinsea.model.User;
import com.github.thisguy_cinsea.model.UserInterface;
import com.github.thisguy_cinsea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v2/user")
public class UserController {

    private UserService service = new UserService();

    @GetMapping("/")
    public Map<String, UserInterface> getAllUsers(){
        System.out.println("controller.getAllUsers");
        System.out.println("getAllUsers called");
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserInterface getUserById(@PathVariable(value = "id") String userId){
        return service.getUserById(userId);
    }

    @PostMapping("/register")
    public UserInterface registerUser(@Valid @RequestBody User user){
        return service.registerUser(user);
    }

    @PostMapping("/create")
    public PersonInterface createUser(@Valid @RequestBody User user){
        System.out.println("controller.createUser");
        System.out.println(user);
        return service.createUser(user);
    }
}
