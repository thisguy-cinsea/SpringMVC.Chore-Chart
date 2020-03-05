package com.github.thisguy_cinsea.controller;

import com.github.thisguy_cinsea.model.Group;
import com.github.thisguy_cinsea.model.GroupInterface;
import com.github.thisguy_cinsea.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/group")

public class GroupController implements ControllerInterface<GroupInterface,GroupService, Group> {
    private GroupService service = new GroupService();

    @Override
    public GroupService getService() {
        return this.service;
    }
}
