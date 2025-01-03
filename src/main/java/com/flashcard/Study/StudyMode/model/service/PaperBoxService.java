package com.flashcard.Study.StudyMode.model.service;

import com.flashcard.Study.StudyMode.entity.FlashCardV2;
import com.flashcard.Study.StudyMode.entity.PaperBoxV2;

import java.util.List;
import java.util.Optional;

public interface PaperBoxService {

    List<PaperBoxV2> findAll();
    Optional<PaperBoxV2> findByName(String name);
    int save(PaperBoxV2 paperBoxV2);
    FlashCardV2 saveFlashCardInBox(String boxName, FlashCardV2 flashCardV2);
    List<FlashCardV2> findFlashCardsByPaperBoxId(Long paperBoxId);

    void deletePaperBox(String delBoxName);
    void deletePaperBoxById(Long boxId);
    void deleteFlashCard(Long idFC);
}
