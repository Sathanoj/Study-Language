package com.flashcard.Study.StudyMode.entity.interfaceEntity;

import com.flashcard.Study.StudyMode.entity.PaperBox;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaperBoxRepository extends JpaRepository<PaperBox, Long> {
    Optional<PaperBox> findByName(String name);
}