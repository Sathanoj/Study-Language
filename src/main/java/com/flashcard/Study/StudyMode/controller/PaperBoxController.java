package com.flashcard.Study.StudyMode.controller;

import com.flashcard.Study.StudyMode.entity.FlashCardV2;
import com.flashcard.Study.StudyMode.entity.PaperBoxV2;
import com.flashcard.Study.StudyMode.entity.impl.FlashCardRepositoryImpl;
import com.flashcard.Study.StudyMode.model.service.PaperBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/box")
public class PaperBoxController {

    private Long idIncrement;

    @Autowired
    private FlashCardRepositoryImpl flashCardRepository;

    @Autowired
    private PaperBoxService paperBoxService;


    @GetMapping("/all")
    public List<PaperBoxV2 > getAll() {
        return paperBoxService.findAll();
    }

    @GetMapping("/{nameBox}")
    public Optional<PaperBoxV2> paperBoxByName(@PathVariable String nameBox) {
        return paperBoxService.findByName(nameBox);
    }

    @PostMapping("/create_box")
    public ResponseEntity<PaperBoxV2> createPaperBox(@RequestBody PaperBoxV2 paperBoxV2) {
        paperBoxV2.setDate(LocalDateTime.now());
        paperBoxService.save(paperBoxV2);
        return ResponseEntity.ok(paperBoxV2);
    }

    @PostMapping("/{nameBox}/add_flash_card")
    public ResponseEntity<FlashCardV2> addFlashCard(@PathVariable String nameBox, @RequestBody FlashCardV2 flashCardV2) {
        paperBoxService.saveFlashCardInBox(nameBox, flashCardV2);
        return ResponseEntity.ok(flashCardV2);

    }

    @GetMapping("/{idBox}/getFC")
    public List<FlashCardV2> getAllFC(@PathVariable Long idBox) {
        List<FlashCardV2> flashCardV2List = paperBoxService.findFlashCardsByPaperBoxId(idBox);
        return flashCardV2List;
    }
}