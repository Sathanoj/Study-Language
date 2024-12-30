package com.flashcard.Study.StudyMode.controller;

import com.flashcard.Study.StudyMode.entity.FlashCardV2;
import com.flashcard.Study.StudyMode.entity.impl.FlashCardRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/box")
public class PaperBoxController {


    @Autowired
    private FlashCardRepositoryImpl flashCardRepository;

//    @PostMapping("/create")
//    public PaperBox entityTest(@RequestBody PaperBox paperBox) {
//        paperBox.setDate(LocalDateTime.now());
//        paperBoxService.createPaperBox(paperBox);
//        return paperBox;
//    }

//    @GetMapping("/all")
//    public List<PaperBox> getAllFlashCard() {
//        return paperBoxService.getAllPaperBox();
//    }

//    @PostMapping("/{boxName}/addFlashCard")
//    public FlashCard addFlashCard(@PathVariable String boxName, @RequestBody FlashCard flashCard) {
//        flashCard.setDate(LocalDateTime.now());
//        return paperBoxService.addFlashCardinBox(boxName, flashCard);
//    }
//
//    @DeleteMapping("/deleteBox/{boxName}")
//    public void deleteBox(@PathVariable String boxName) {
//        paperBoxService.deletePaperBox(boxName);
//    }


    @GetMapping("/all")
    public List<FlashCardV2> getALL() {
        return flashCardRepository.findAll();
    }
}