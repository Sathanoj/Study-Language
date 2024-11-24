package com.flashcard.Study.StudyMode.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class PaperBox {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @OneToMany(cascade =  CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "paperbox_id")
    private List<FlashCard> flashCardsPaperBox;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime date;

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

    public List<FlashCard> getFlashCardsPaperBox() {
        return flashCardsPaperBox;
    }

    public void setFlashCardsPaperBox(List<FlashCard> flashCardsPaperBox) {
        this.flashCardsPaperBox = flashCardsPaperBox;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
