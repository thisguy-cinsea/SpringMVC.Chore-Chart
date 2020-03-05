package com.github.thisguy_cinsea.controller;

import com.github.thisguy_cinsea.model.RegisteredUser;
import com.github.thisguy_cinsea.model.RegisteredUserInterface;
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
        Map<String, RegisteredUserInterface> registeredUserMap = service.getAll();
        if (registeredUserMap.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(registeredUserMap, HttpStatus.OK);
    }

    @GetMapping("/{registeredUserId}")
    public ResponseEntity<RegisteredUserInterface> getRegisteredUserById(
            @PathVariable(value = "registeredUserId") String registeredUserId){
        RegisteredUserInterface registeredUser = service.getById(registeredUserId);
        if (registeredUser == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(registeredUser, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<RegisteredUserInterface> createRegisteredUser(
            @Valid @RequestBody RegisteredUser registeredUser){
        RegisteredUserInterface serviceRegisteredUser = service.create(registeredUser);
        if (serviceRegisteredUser == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceRegisteredUser, HttpStatus.OK);
    }

    @PutMapping("/{registeredUserId}")
    public ResponseEntity<RegisteredUserInterface> updateRegisteredUser(
            @PathVariable (value = "registeredUserId") String registeredUserId,
            @Valid @RequestBody RegisteredUser registeredUser){
        RegisteredUserInterface serviceRegisteredUser = service.update(registeredUserId, registeredUser);
        if (serviceRegisteredUser == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceRegisteredUser, HttpStatus.OK);
    }

    @DeleteMapping("/{registeredUserId}")
    public ResponseEntity<RegisteredUserInterface> deleteRegisteredUser(
            @PathVariable (value = "registeredUserId") String registeredUserId){
        RegisteredUserInterface serviceRegisteredUser = service.delete(registeredUserId);
        if (serviceRegisteredUser == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceRegisteredUser, HttpStatus.OK);
    }
}