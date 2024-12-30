package com.flashcard.Study.StudyMode.entity;

import java.time.LocalDateTime;
import java.util.List;

public class PaperBoxV2 {

    private Long id;
    private String name;
    private LocalDateTime date;
    private List<FlashCardV2> flashCardV2List;

    public PaperBoxV2(){}

    public PaperBoxV2(Long id, String name, LocalDateTime date, List<FlashCardV2> flashCardV2List) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.flashCardV2List = flashCardV2List;
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

    public List<FlashCardV2> getFlashCardV2List() {
        return flashCardV2List;
    }

    public void setFlashCardV2List(List<FlashCardV2> flashCardV2List) {
        this.flashCardV2List = flashCardV2List;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
