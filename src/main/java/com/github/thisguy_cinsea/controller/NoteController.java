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

public class NoteController {
    private NoteService service = new NoteService();

    @GetMapping("/")
    public ResponseEntity<Map<String, NoteInterface>> getAllNotes(){
        Map<String, NoteInterface> noteMap = service.getAllNotes();
        if (noteMap.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(noteMap, HttpStatus.OK);
    }

    @GetMapping("/{noteId}")
    public ResponseEntity<NoteInterface> getNoteById(
            @PathVariable (value = "noteId") String noteId){
        NoteInterface note = service.getNoteById(noteId);
        if (note == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<NoteInterface> createNote(
            @Valid @RequestBody Note note){
        NoteInterface noteMap = service.createNote(note);
        if (noteMap == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(noteMap, HttpStatus.OK);
    }

    @PutMapping("/{noteId}")
    public ResponseEntity<NoteInterface> updateNote(
            @PathVariable (value = "noteId") String noteId,
            @Valid @RequestBody Note note){
        NoteInterface noteMap = service.updateNote(noteId, note);
        if (noteMap == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(noteMap, HttpStatus.OK);
    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity<NoteInterface> deleteNote(
            @PathVariable (value = "noteId") String noteId){
        NoteInterface noteMap = service.deleteNote(noteId);
        if (noteMap == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(noteMap, HttpStatus.OK);
    }


}
