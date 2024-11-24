package com.flashcard.Study.StudyMode.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudyModeResults {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer easy;
    private Integer hard;
    private Integer donKnow;
    private PaperBox paperBoxReference;
    private Boolean isEnd;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEasy() {
        return easy;
    }

    public void setEasy(Integer easy) {
        this.easy = easy;
    }

    public Integer getHard() {
        return hard;
    }

    public void setHard(Integer hard) {
        this.hard = hard;
    }

    public Integer getDonKnow() {
        return donKnow;
    }

    public void setDonKnow(Integer donKnow) {
        this.donKnow = donKnow;
    }

    public PaperBox getPaperBoxReference() {
        return paperBoxReference;
    }

    public void setPaperBoxReference(PaperBox paperBoxReference) {
        this.paperBoxReference = paperBoxReference;
    }

    public Boolean getEnd() {
        return isEnd;
    }

    public void setEnd(Boolean end) {
        isEnd = end;
    }

    @Override
    public String toString() {
        return "StudyModeResults{" +
                "id=" + id +
                ", easy=" + easy +
                ", hard=" + hard +
                ", donKnow=" + donKnow +
                '}';
    }
}
