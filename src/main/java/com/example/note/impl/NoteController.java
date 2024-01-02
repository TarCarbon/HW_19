package com.example.note.impl;

import com.example.note.ModifyResponse;
import com.example.note.Note;
import com.example.note.NoteDto;
import com.example.note.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/note")
public class NoteController {

    private final NoteService noteService;

    @GetMapping("/list")
    public List<NoteDto> getAll() {
        return NoteDto.from(noteService.getAll());
    }

    @PostMapping("/create")
    public ModifyResponse create(@RequestBody NoteDto dto) {

        if(!noteService.isTypeValid(dto.getTitle())) {
            return ModifyResponse.failed("Title can`t be null or empty!");
        }

        noteService.create(dto);
        return ModifyResponse.success("Create note is success");
    }

    @GetMapping("/update")
    public ModifyResponse update(@RequestBody Note note){

        if(!noteService.isNoteCorrect(note)) {
            return ModifyResponse.failed("Don't correctly data");
        }

        if(!noteService.exists(note.getId())) {
            return ModifyResponse.failed("Note with id:" + note.getId() + " not exists");
        }

        if(!noteService.isTypeValid(note.getTitle())) {
            return ModifyResponse.failed("Title can`t be null or empty!");
        }
        
        noteService.update(note);
        return ModifyResponse.success("Update is success");
    }

    @PostMapping("/delete")
    public ModifyResponse delete(@RequestBody Long id) {
        if(!noteService.exists(id)) {
            return ModifyResponse.failed("note with id=" + id + " not exists");
        }

        noteService.deleteById(id);
        return ModifyResponse.success("Delete note with id=" + id + " is success");
    }
}
