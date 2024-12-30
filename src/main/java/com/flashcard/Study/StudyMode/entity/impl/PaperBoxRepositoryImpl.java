package com.flashcard.Study.StudyMode.entity.impl;

import com.flashcard.Study.StudyMode.entity.FlashCardV2;
import com.flashcard.Study.StudyMode.entity.PaperBoxV2;
import com.flashcard.Study.StudyMode.model.service.PaperBoxService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaperBoxRepositoryImpl implements PaperBoxService {

    private final JdbcTemplate template;

    public PaperBoxRepositoryImpl(JdbcTemplate template) {
        this.template = template;
    }

    private final RowMapper<PaperBoxV2> paperBoxV2Mapper = (rs, rowNum) -> new PaperBoxV2(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getTimestamp("date").toLocalDateTime(),
            null
    );

    private final RowMapper<FlashCardV2> flashCardMapper = (rs, rowNum) ->
            new FlashCardV2(
                rs.getLong("id"),
                rs.getString("word"),
                rs.getString("wordTranslated"),
                rs.getTimestamp("date").toLocalDateTime(),
                rs.getLong("paper_box_id")
    );

    @Override
    public List<PaperBoxV2> findAll() {
        String sql = "SELECT * FROM paper_box";
        List<PaperBoxV2>paperBoxV2s = template.query(sql, paperBoxV2Mapper);

        for (PaperBoxV2 boxV2 : paperBoxV2s) {
            boxV2.setFlashCardV2List(findFlashCardsByPaperBoxId(boxV2.getId()));
        }

        return paperBoxV2s;
    }

    @Override
    public int save(PaperBoxV2 paperBoxV2) {
        String sql = "INSERT INTO paper_box (name, date) VALUES (?, ?)";
        return template.update(sql,
                paperBoxV2.getName(), paperBoxV2.getDate());
    }

    @Override
    public List<FlashCardV2> findFlashCardsByPaperBoxId(Long paperBoxId) {
        String sql = "INSERT INTO paper_box (name, date VALUES (?, ?)";
        return template.query(sql,
                flashCardMapper,
                paperBoxId);
    }
}
