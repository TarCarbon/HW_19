package com.example.note;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class NoteDto {

    private String title;
    private String content;

    public static List<NoteDto> from(Iterable<Note> notes){
        List<NoteDto> result = new ArrayList<>();

        for(Note note: notes){
            result.add(from(note));
        }
        return result;
    }

    public static NoteDto from(Note note) {
        return NoteDto
                .builder()
                .title(note.getTitle())
                .content(note.getContent())
                .build();
    }
}
