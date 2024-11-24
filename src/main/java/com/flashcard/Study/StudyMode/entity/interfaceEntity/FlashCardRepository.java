package com.flashcard.Study.StudyMode.entity.interfaceEntity;

import com.flashcard.Study.StudyMode.entity.FlashCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlashCardRepository extends JpaRepository<FlashCard, Long> {
}
