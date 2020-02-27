package com.github.thisguy_cinsea.controller;

import com.github.thisguy_cinsea.model.Responsibility;
import com.github.thisguy_cinsea.model.ResponsibilityInterface;
import com.github.thisguy_cinsea.service.ResponsibilityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/chore")

public class ResponsibilityController {
    private ResponsibilityService service = new ResponsibilityService();

    @GetMapping("/")
    public ResponseEntity<Map<String, ResponsibilityInterface>> getAllResponsibilities(){
        Map<String, ResponsibilityInterface> responsibilityMap = service.getAllResponsibilities();
        if (responsibilityMap.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(responsibilityMap, HttpStatus.OK);
    }

    @GetMapping("/{responsibilityId}")
    public ResponseEntity<ResponsibilityInterface> getResponsibilityById(
            @PathVariable(value = "responsibilityId") String responsibilityId){
        ResponsibilityInterface responsibility = service.getResponsibilityById(responsibilityId);
        if (responsibility == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(responsibility, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ResponsibilityInterface> createResponsibility(
            @Valid @RequestBody Responsibility responsibility){
        System.out.println(responsibility);
        ResponsibilityInterface serviceResponsibility = service.createResponsibility(responsibility);
        if (serviceResponsibility == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceResponsibility, HttpStatus.OK);
    }

    @PutMapping("/{responsibilityId}")
    public ResponseEntity<ResponsibilityInterface> updateResponsibility(
            @PathVariable (value = "responsibilityId") String responsibilityId,
            @Valid @RequestBody Responsibility responsibility){
        ResponsibilityInterface serviceResponsibility = service.updateResponsibility(responsibilityId, responsibility);
        if (serviceResponsibility == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceResponsibility, HttpStatus.OK);
    }

    @DeleteMapping("/{responsibilityId}")
    public ResponseEntity<ResponsibilityInterface> deleteResponsibility(
            @PathVariable (value = "responsibilityId") String responsibilityId){
        ResponsibilityInterface serviceResponsibility = service.deleteResponsibility(responsibilityId);
        if (serviceResponsibility == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceResponsibility, HttpStatus.OK);
    }
}
