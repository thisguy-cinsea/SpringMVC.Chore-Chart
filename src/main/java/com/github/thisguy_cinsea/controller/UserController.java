package com.github.thisguy_cinsea.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//
//import com.github.thisguy_cinsea.model.PersonInterface;
//import com.github.thisguy_cinsea.model.User;
//import com.github.thisguy_cinsea.model.UserInterface;
//import com.github.thisguy_cinsea.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api/v2/")

//
    @RestController
    public class UserController {
        @RequestMapping("/user")
        public String showUserMsg()
        {
            System.out.println("controller.showusermsg");
            return "User has logged in!!!";

        }

        @RequestMapping("/admin")
        public String showAdminMsg()
        {
            return "Admin has logged in!!!";
        }
    }
//    private UserService service = new UserService();
//
//    @RequestMapping("/user")
//    public String showUserMsg(){
//        return "User has logged in!!!";
//    }
//
//    @RequestMapping("/admin")
//    public String showAdminMsg(){
//        return "Admin has logged in!!!";
//    }
//
////    @GetMapping("/")
////    public Map<String, UserInterface> getAllUsers(){
////        return service.getAllUsers();
////    }
////
////    @GetMapping("/{id}")
////    public UserInterface getUserById(@PathVariable(value = "id") String userId){
////        return service.getUserById(userId);
////    }
////
////    @PostMapping("/register")
////    public UserInterface registerUser(@Valid @RequestBody User user){
////        return service.registerUser(user);
////    }
////
////    @PostMapping("/create")
////    public PersonInterface createUser(@Valid @RequestBody User user){
////        System.out.println("controller.createUser");
////        System.out.println(user);
////        return service.createUser(user);
////    }
//}
