package com.flashcard.Study.entity.impl;

import com.flashcard.Study.entity.FlashCardV2;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class FlashCardRepositoryImpl {

    private final JdbcTemplate template;

    public FlashCardRepositoryImpl(JdbcTemplate template) {
        this.template = template;
    }

    public int save(FlashCardV2 flashCardV2) {
        String sql = "INSERT INTO flash_card (word, word_translated,date, paper_box_id) VALUES (?, ?, ?, ?)";
        flashCardV2.setDate(LocalDateTime.now());
        return template.update(sql,
                flashCardV2.getWord(),
                flashCardV2.getWordTranslated(),
                flashCardV2.getDate(),
                flashCardV2.getPaperBoxId());
    }

    public int update(FlashCardV2 flashCardV2) {
        String sql = "UPDATE flash_card set word = ?, word_translated = ? WHERE id = ?";
        return template.update(sql,
                flashCardV2.getWord(),
                flashCardV2.getWordTranslated(),
                flashCardV2.getId());
    }

    public int deleteById(Long id) {
        String sql = "DELETE FROM flash_card WHERE id = ?";
        return template.update(sql, id);
    }
}
