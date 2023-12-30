package com.example.note.impl;

import com.example.note.Note;
import com.example.note.NoteDto;
import com.example.note.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/note")
public class NoteController {

    private final NoteService<Note> noteService;

    @GetMapping("/list")
    public List<NoteDto> getAll() {
        return NoteDto.from(noteService.getAll());
    }


}
