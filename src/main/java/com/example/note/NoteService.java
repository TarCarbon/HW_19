package com.example.note;

import java.util.List;

public interface NoteService<T> {

    public List<T> getAll();

    public void add(T t);

    public void update(T t);
    public void deleteById(Long id);
    public T getById(Long id);
}
