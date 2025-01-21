package com.flashcard.Study;

import com.flashcard.Study.controller.PaperBoxController;
import com.flashcard.Study.entity.PaperBoxV2;
import com.flashcard.Study.model.service.PaperBoxService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class FlashcardApplicationTests {

	@Autowired
	PaperBoxController paperBoxController;
	@Autowired
	PaperBoxService paperBoxService;
	List<PaperBoxV2> paperBoxV2s;

	@Test
	void findBoxRoute() {
		var flashCardV2List = paperBoxController.paperBoxByName("Trabalho");
		System.out.println(flashCardV2List);
	}
	@Test
	void getAllBoxTest() {
		paperBoxV2s = paperBoxService.findAll();
		assertNotNull(paperBoxV2s);
		assertFalse(paperBoxV2s.isEmpty(), "A lista de PaperBox está vazia");
		for (PaperBoxV2 boxV2 : paperBoxV2s) {
			System.out.println(boxV2);
			if (!boxV2.getFlashCardV2List().isEmpty()) {
				System.out.println(boxV2.getFlashCardV2List().toString());
			}
		}
	}

//	@Test
//	void testPaperBoxList() {
//		paperBoxV2s = paperBoxService.findAll();
////		for (int i = 0; i < paperBoxV2s.size(); i++) {
////			paperBoxV2s.get(i).toString();
////		}
//
//		paperBoxV2s.forEach(System.out::println);
//	}

}
