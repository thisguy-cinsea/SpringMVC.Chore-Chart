package com.github.thisguy_cinsea.controller;

import com.github.thisguy_cinsea.model.Note;
import com.github.thisguy_cinsea.model.NoteInterface;
import com.github.thisguy_cinsea.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/note")

public class NoteController implements ControllerInterface<NoteInterface, NoteService, Note>{
    private NoteService service = new NoteService();

    @Override
    public NoteService getService() {
        return this.service;
    }
}
