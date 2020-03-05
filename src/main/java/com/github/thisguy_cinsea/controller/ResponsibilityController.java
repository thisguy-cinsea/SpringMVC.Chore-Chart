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

public class ResponsibilityController implements ControllerInterface<ResponsibilityInterface, ResponsibilityService, Responsibility>{
    private ResponsibilityService service = new ResponsibilityService();

    @Override
    public ResponsibilityService getService() {
        return this.service;
    }
}
