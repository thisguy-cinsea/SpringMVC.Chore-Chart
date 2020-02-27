package com.github.thisguy_cinsea.controller;

import com.github.thisguy_cinsea.model.RegisteredUserInterface;
import com.github.thisguy_cinsea.model.Responsibility;
import com.github.thisguy_cinsea.service.RegisteredUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/registered")
public class RegisteredUserController {

    private RegisteredUserService service = new RegisteredUserService();

    @GetMapping("/")
    public ResponseEntity<Map<String, RegisteredUserInterface>> getAllRegisteredUsers(){
        Map<String, RegisteredUserInterface> registeredUserMap = service.getAllRegisteredUsers();
        if (registeredUserMap.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(registeredUserMap, HttpStatus.OK);
    }

    @GetMapping("/{registeredUserId}")
    public ResponseEntity<RegisteredUserInterface> getResponsibilityById(
            @PathVariable(value = "registeredUserId") String registeredUserId){
        RegisteredUserInterface registeredUser = service.getResponsibilityById(registeredUserId);
        if (registeredUser == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(registeredUser, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<RegisteredUserInterface> createResponsibility(
            @Valid @RequestBody Responsibility registeredUser){
        System.out.println(registeredUser);
        RegisteredUserInterface serviceRegisteredUser = service.createResponsibility(registeredUser);
        if (serviceRegisteredUser == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceRegisteredUser, HttpStatus.OK);
    }

    @PutMapping("/{registeredUserId}")
    public ResponseEntity<RegisteredUserInterface> updateResponsibility(
            @PathVariable (value = "registeredUserId") String registeredUserId,
            @Valid @RequestBody Responsibility registeredUser){
        RegisteredUserInterface serviceRegisteredUser = service.updateResponsibility(registeredUserId, registeredUser);
        if (serviceRegisteredUser == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceRegisteredUser, HttpStatus.OK);
    }

    @DeleteMapping("/{registeredUserId}")
    public ResponseEntity<RegisteredUserInterface> deleteResponsibility(
            @PathVariable (value = "registeredUserId") String registeredUserId){
        RegisteredUserInterface serviceRegisteredUser = service.deleteResponsibility(registeredUserId);
        if (serviceRegisteredUser == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceRegisteredUser, HttpStatus.OK);
    }
}