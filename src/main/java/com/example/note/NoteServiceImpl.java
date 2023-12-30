package com.example.note;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoteServiceImpl implements NoteService<Note> {

    private final NoteRepository noteRepository;

    @Override
    public void add(Note note) {
            noteRepository.save(note);
    }

    @Override
    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    @Override
    public void update(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public Note getById(Long id) {
        return noteRepository.getReferenceById(id);
    }
}
