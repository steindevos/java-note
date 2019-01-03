package com.capgemini.notitieApp.controller;

import com.capgemini.notitieApp.model.Note;
import com.capgemini.notitieApp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("api/notes/")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    // Return all notes
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Note> getAll() {
        return noteRepository.findAll();
    }

    // Return note by id
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Optional<Note> findById(@PathVariable long id) {
        Optional<Note> result = noteRepository.findById(id);
        return result;
    }

    // Post one note
    @RequestMapping(method = RequestMethod.POST)
    public Note postNote(@RequestBody Note newNote) {
        noteRepository.save(newNote);
        return newNote;
    }
}
