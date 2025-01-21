package com.flashcard.Study.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class Usuario {

    Long id;
    String name;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime date;

    public Usuario() {
    }

    public Usuario(Long id, String name, LocalDateTime date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
