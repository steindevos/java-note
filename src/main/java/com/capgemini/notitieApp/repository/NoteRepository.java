package com.capgemini.notitieApp.repository;

import com.capgemini.notitieApp.model.Note;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class NoteRepository {

    private static long id = 0;
    private static Map<Long, Note> noteMap = new HashMap<>();

    @PostConstruct
    public void addSomeNotesToGetStarted() {
        for (int i = 0; i < 5; i++) {
            Note newNote = new Note();
            newNote.setNoteText("This is note number " + (i + 1));
            NoteRepository.save(newNote);
        }
    }

    // CREATE
    private static void save(Note newNote) {
        noteMap.put(++id, newNote);
    }

    // READ
    public Collection<Note> findAllNotes() {
        return noteMap.values();
    }
}
