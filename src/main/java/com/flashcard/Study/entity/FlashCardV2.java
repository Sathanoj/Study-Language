package com.flashcard.Study.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class FlashCardV2 {

    private Long id;
    private String word;
    private String wordTranslated;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime date;
    private Long paperBoxId;

    public FlashCardV2() {}

    public FlashCardV2(Long id, String word, String wordTranslated, LocalDateTime date, Long paperBoxId) {
        this.id = id;
        this.word = word;
        this.wordTranslated = wordTranslated;
        this.date = date;
        this.paperBoxId = paperBoxId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWordTranslated() {
        return wordTranslated;
    }

    public void setWordTranslated(String wordTranslated) {
        this.wordTranslated = wordTranslated;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Long getPaperBoxId() {
        return paperBoxId;
    }

    public void setPaperBoxId(Long paperBoxId) {
        this.paperBoxId = paperBoxId;
    }
}
