package com.flashcard.Study.StudyMode.model;

import com.flashcard.Study.StudyMode.entity.FlashCard;
import com.flashcard.Study.StudyMode.entity.PaperBox;
import com.flashcard.Study.StudyMode.entity.StudyModeResults;
import com.flashcard.Study.StudyMode.entity.interfaceEntity.PaperBoxRepository;
import com.flashcard.Study.StudyMode.entity.interfaceEntity.StudyModeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudyModeService {

    private PaperBox paperBox;
    @Autowired
    private PaperBoxRepository paperBoxRepository;
    @Autowired
    private StudyModeRepository studyModeRepository;


    public void startGame() {

    }

    private void startGameMode(String paperBoxName) {
        Optional<PaperBox> paperBox = paperBoxRepository.findByName(paperBoxName);
        if (paperBox.isPresent()) {
            PaperBox paperBoxDB = paperBox.get();
            StudyModeResults startNew = new StudyModeResults();
            startNew.setPaperBoxReference(paperBoxDB);
            startNew.setEnd(false);
            studyModeRepository.save(startNew);
        }
    }

    private FlashCard getNextFlashCard(Long sessionId) {
        StudyModeResults session = studyModeRepository
                .findById(sessionId)
                .orElseThrow(()-> new RuntimeException("Session not found"));

        if (!session.getEnd()) {

        }
        return null;
    }
    public void salveAnswer(StudyModeResults session, String choose) {
        switch (choose) {
            case "Easy": session.setEasy(session.getEasy() + 1);
            break;
            case "Hard": session.setHard(session.getHard() + 1);
            break;
            case "donKnow": session.setDonKnow(session.getDonKnow() + 1);
            break;
        }
    }

}























