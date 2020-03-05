package com.github.thisguy_cinsea.controller;

import com.github.thisguy_cinsea.dao.DaoInterface;
import com.github.thisguy_cinsea.model.EntityInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

public interface ControllerInterface<SomeEntityInterface extends EntityInterface, SomeService extends DaoInterface, SomeConcreteEntity extends EntityInterface> {
    SomeService getService();

    @GetMapping("/")
    default ResponseEntity<Map<String, SomeEntityInterface>> getAll(){
        Map<String, SomeEntityInterface> map = getService().getAll();
        if (map.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    default ResponseEntity<SomeEntityInterface> getById(
            @PathVariable(value = "id") String id){
        SomeEntityInterface entity = (SomeEntityInterface) getService().getById(id);
        if (entity == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping("/")
    default ResponseEntity<SomeEntityInterface> create(
            @Valid @RequestBody SomeConcreteEntity entity){
        SomeEntityInterface serviceEntity = (SomeEntityInterface) getService().create(entity);
        if (serviceEntity == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceEntity, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    default ResponseEntity<SomeEntityInterface> update(
            @PathVariable (value = "id") String id,
            @Valid @RequestBody SomeConcreteEntity entity){
        SomeEntityInterface serviceEntity = (SomeEntityInterface) getService().update(id, entity);
        if (serviceEntity == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceEntity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    default ResponseEntity<SomeEntityInterface> delete(
            @PathVariable (value = "id") String id){
        SomeEntityInterface serviceEntity = (SomeEntityInterface) getService().delete(id);
        if (serviceEntity == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceEntity, HttpStatus.OK);
    }
}
