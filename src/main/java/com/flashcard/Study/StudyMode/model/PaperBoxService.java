package com.flashcard.Study.StudyMode.model;

import com.flashcard.Study.StudyMode.entity.FlashCard;
import com.flashcard.Study.StudyMode.entity.PaperBox;
import com.flashcard.Study.StudyMode.entity.interfaceEntity.PaperBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaperBoxService {

    @Autowired
    private PaperBoxRepository paperBoxRepository;

//  CRUD
    public void createPaperBox(PaperBox paperBox) {
        paperBoxRepository.save(paperBox);
    }

    public List<PaperBox> getAllPaperBox() {
        return paperBoxRepository.findAll();
    }

    public FlashCard addFlashCardinBox(String boxName, FlashCard flashCard) {
        Optional<PaperBox> paperBoxOptional = paperBoxRepository.findByName(boxName);
        if (paperBoxOptional.isPresent()) {
            PaperBox paperBox = paperBoxOptional.get();
            paperBox.getFlashCardsPaperBox().add(flashCard);
            paperBoxRepository.save(paperBox);
            return flashCard;
        } else {
            throw new RuntimeException("PaperBox not found for add this FlashCard: " + boxName);
        }
    }

    public void deletePaperBox(String boxName) {
        Optional<PaperBox> paperBoxOptional = paperBoxRepository.findByName(boxName);
        if (paperBoxOptional.isPresent()) {
            PaperBox paperBox = paperBoxOptional.get();
            paperBoxRepository.delete(paperBox);
        }
    }



}






