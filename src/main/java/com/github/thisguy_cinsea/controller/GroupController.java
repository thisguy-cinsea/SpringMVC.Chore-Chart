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

public class GroupController {
    private GroupService service = new GroupService();

    @GetMapping("/")
    public ResponseEntity<Map<String, GroupInterface>> getAllGroups(){
        Map<String, GroupInterface> groupMap = service.getAllGroups();
        if (groupMap.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(groupMap, HttpStatus.OK);
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<GroupInterface> getGroupById(
            @PathVariable(value = "groupId") String groupId){
        GroupInterface group = service.getGroupById(groupId);
        if (group == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(group, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<GroupInterface> createGroup(
            @Valid @RequestBody Group group){
        GroupInterface serviceGroup = service.createGroup(group);
        if (serviceGroup == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceGroup, HttpStatus.OK);
    }

    @PutMapping("/{groupId}")
    public ResponseEntity<GroupInterface> updateGroup(
            @PathVariable (value = "groupId") String groupId,
            @Valid @RequestBody Group group){
        GroupInterface serviceGroup = service.updateGroup(groupId, group);
        if (serviceGroup == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceGroup, HttpStatus.OK);
    }

    @DeleteMapping("/{groupId}")
    public ResponseEntity<GroupInterface> deleteGroup(
            @PathVariable (value = "groupId") String groupId){
        GroupInterface serviceGroup = service.deleteGroup(groupId);
        if (serviceGroup == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceGroup, HttpStatus.OK);
    }
}
