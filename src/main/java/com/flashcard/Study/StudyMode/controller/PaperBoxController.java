package com.flashcard.Study.StudyMode.controller;

import com.flashcard.Study.StudyMode.entity.FlashCard;
import com.flashcard.Study.StudyMode.entity.PaperBox;
import com.flashcard.Study.StudyMode.model.PaperBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/box")
public class PaperBoxController {

    @Autowired
    private PaperBoxService paperBoxService;

    @PostMapping("/create")
    public PaperBox entityTest(@RequestBody PaperBox paperBox) {
        paperBox.setDate(LocalDateTime.now());
        paperBoxService.createPaperBox(paperBox);
        return paperBox;
    }

    @GetMapping("/all")
    public List<PaperBox> getAllFlashCard() {
        return paperBoxService.getAllPaperBox();
    }

    @PostMapping("/{boxName}/addFlashCard")
    public FlashCard addFlashCard(@PathVariable String boxName, @RequestBody FlashCard flashCard) {
        flashCard.setDate(LocalDateTime.now());
        return paperBoxService.addFlashCardinBox(boxName, flashCard);
    }

    @DeleteMapping("/deleteBox/{boxName}")
    public void deleteBox(@PathVariable String boxName) {
        paperBoxService.deletePaperBox(boxName);
    }
}