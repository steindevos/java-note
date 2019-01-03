package com.capgemini.notitieApp.controller;

import com.capgemini.notitieApp.model.Note;
import com.capgemini.notitieApp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/notes/")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Note> getAllNotes() {
        return noteRepository.findAllNotes();
    }
}
