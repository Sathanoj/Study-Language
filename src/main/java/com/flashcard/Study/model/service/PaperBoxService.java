package com.flashcard.Study.model.service;

import com.flashcard.Study.entity.FlashCardV2;
import com.flashcard.Study.entity.PaperBoxV2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
