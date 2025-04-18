package com.flashcard.Study.entity.impl;

import com.flashcard.Study.entity.FlashCardV2;
import com.flashcard.Study.entity.PaperBoxV2;
import com.flashcard.Study.model.service.PaperBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PaperBoxRepositoryImpl implements PaperBoxService {

    private final JdbcTemplate template;

    @Autowired
    private FlashCardRepositoryImpl flashCardRepository;

    public PaperBoxRepositoryImpl(JdbcTemplate template) {
        this.template = template;
    }

    private final RowMapper<PaperBoxV2> paperBoxV2Mapper = (rs, rowNum) ->
            new PaperBoxV2(
                rs.getLong("id"),
                rs.getString("name"),
                (rs.getTimestamp("date") != null) ? rs.getTimestamp("date").toLocalDateTime() : null,
                null // FlashCards serão carregados separadamente
    );


    private final RowMapper<FlashCardV2> flashCardMapper = (rs, rowNum) ->
            new FlashCardV2(
                rs.getLong("id"),
                rs.getString("word"),
                rs.getString("word_translated"),
                rs.getTimestamp("date").toLocalDateTime(),
                rs.getLong("paper_box_id")
    );

    @Override
    public List<PaperBoxV2> findAll() {
        String sql = "SELECT * FROM paper_box";
        PaperBoxV2 boxV2;
        List<PaperBoxV2> paperBoxV2s = template.query(sql, paperBoxV2Mapper);
        for (int i = 0; i < paperBoxV2s.size(); i++) {
            paperBoxV2s.get(i).setFlashCardV2List(
                    findFlashCardsByPaperBoxId(paperBoxV2s.get(i).getId()));
        }
        return paperBoxV2s;
    }

    @Override
    public Optional<PaperBoxV2> findByName(String name) {
        String sql = "SELECT * FROM paper_box WHERE name LIKE ?";
        List<PaperBoxV2> paperBoxV2 = template.query(sql, new Object[]{"%" + name + "%"}, paperBoxV2Mapper);
        paperBoxV2.get(0).setFlashCardV2List(
                findFlashCardsByPaperBoxId(paperBoxV2.get(0).getId()));
        return paperBoxV2.isEmpty() ? Optional.empty() : Optional.of(paperBoxV2.get(0));
    }

    @Override
    public int save(PaperBoxV2 paperBoxV2) {
        String sql = "INSERT INTO paper_box (name, date) VALUES (?, ?)";
        return template.update(sql,
            paperBoxV2.getName(), paperBoxV2.getDate());
    }

    @Override
    public FlashCardV2 saveFlashCardInBox(String boxName, FlashCardV2 flashCardV2) {
        FlashCardV2 getFC = flashCardV2;
        Optional<PaperBoxV2> optionalPaperBoxV2 = findByName(boxName);
        if (optionalPaperBoxV2.isPresent()) {
            PaperBoxV2 paperBOX = optionalPaperBoxV2.get();
            getFC.setPaperBoxId(paperBOX.getId());
            paperBOX.getFlashCardV2List().add(getFC);
            flashCardRepository.save(getFC);
        }
        return getFC;
    }

    @Override
    public List<FlashCardV2> findFlashCardsByPaperBoxId(Long paperBoxId) {
        String sql = "SELECT * FROM flash_card WHERE paper_box_id = ?";
        return template.query(sql, flashCardMapper, paperBoxId);
    }

    @Override
    public void deletePaperBox(String delBoxName) {
//        All FlashCards there are related to the box will be deleted
        String sql = "DELETE FROM paper_box WHERE name = ?";
        template.update(sql, delBoxName);
    }

    @Override
    public void deletePaperBoxById(Long boxId) {
        String sql = "DELETE FROM paper_box WHERE id = ?";
        template.update(sql, boxId);
    }

    @Override
    public void deleteFlashCard(Long idFC) {
        String sql = "DELETE FROM flash_card WHERE id = ?";
        template.update(sql, idFC);
    }
}





























