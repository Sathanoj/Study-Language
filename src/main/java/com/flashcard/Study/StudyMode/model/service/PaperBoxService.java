package com.flashcard.Study.StudyMode.model.service;

import com.flashcard.Study.StudyMode.entity.FlashCardV2;
import com.flashcard.Study.StudyMode.entity.PaperBoxV2;

import java.util.List;

public interface PaperBoxService {

    List<PaperBoxV2> findAll();
    int save(PaperBoxV2 paperBoxV2);
    List<FlashCardV2> findFlashCardsByPaperBoxId(Long paperBoxId);
}
