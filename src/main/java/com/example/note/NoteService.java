package com.example.note;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public void create(NoteDto dto) {
        Note note = new Note();
        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());
        noteRepository.save(note);
    }

    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    public void update(Note note) {
        Note newNote = noteRepository.findById(note.getId()).orElseThrow();
        newNote.setContent(note.getContent());
        noteRepository.save(newNote);
    }

    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }

    public Note getById(Long id) {
        return noteRepository.getReferenceById(id);
    }

    public boolean exists(Long id) {
        return noteRepository.existsById(id);
    }

    public boolean isTypeValid(String title) {
        return !(title == null) && !(title.isBlank());
    }

    public boolean isNoteCorrect(Note note){
        return note.getId() !=null;
    }
}
