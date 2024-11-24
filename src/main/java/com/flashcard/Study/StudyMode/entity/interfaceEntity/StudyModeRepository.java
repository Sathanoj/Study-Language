package com.flashcard.Study.StudyMode.entity.interfaceEntity;

import com.flashcard.Study.StudyMode.entity.StudyModeResults;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyModeRepository extends JpaRepository<StudyModeResults, Long> {
}
