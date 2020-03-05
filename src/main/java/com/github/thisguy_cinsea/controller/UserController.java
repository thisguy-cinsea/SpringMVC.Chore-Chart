package com.github.thisguy_cinsea.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.thisguy_cinsea.model.UserInterface;
import com.github.thisguy_cinsea.model.User;
//import com.github.thisguy_cinsea.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v2/user")
public class UserController {
//    private UserService service = new UserService();

    @RequestMapping("/admin")
    public String showAdminMsg() {
        System.out.println("UserController.admin");

        return "Admin has logged in!!!";
    }

//    @GetMapping(value = "/user/")
//    public ResponseEntity<List<UserInterface>> listAllUsers(){
//        System.out.println("UserController.listAllUsers");
//
//        List<UserInterface> users = service.listAllUsers();
//        if (users.isEmpty()){
//            return new ResponseEntity<List<UserInterface>>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<UserInterface>>(users, HttpStatus.OK);
//    }
//
//    @GetMapping("/")
//    public Map<String, UserInterface> getAllUsers(){
//        System.out.println("UserController.getAllUsers");
//        return service.getAllUsers();
//    }
//
//    @GetMapping("/{id}")
//    public UserInterface getUserById(@PathVariable(value = "id") String userId){
//        System.out.println("UserController.getUserById");
//        return service.getUserById(userId);
//    }
//
//    @PutMapping("/testPut")
//    public ResponseEntity<HttpStatus> testPut(){
//        System.out.println("UserController.testPut");
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @PostMapping("/register")
//    public UserInterface registerUser(@Valid @RequestBody User user){
//        System.out.println("UserController.register");
//        System.out.println("registered passed user: "+ user);
//        return service.registerUser(user);
//    }
//
//    @PostMapping("/create")
//    public UserInterface createUser(@Valid @RequestBody User user){
//        System.out.println("controller.createUser");
//        System.out.println(user);
//        return service.createUser(user);
//    }
}
