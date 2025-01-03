package com.flashcard.Study;

import com.flashcard.Study.StudyMode.entity.PaperBoxV2;
import com.flashcard.Study.StudyMode.model.service.PaperBoxService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FlashcardApplicationTests {

	@Autowired
	PaperBoxService paperBoxService;
	List<PaperBoxV2> paperBoxV2s;

	@Test
	void contextLoads() {

	}
	@Test
	void getAllBoxTest() {
		paperBoxV2s = paperBoxService.findAll();
		for (PaperBoxV2 boxV2 : paperBoxV2s) {
			System.out.println(boxV2.toString());
		}
	}

	@Test
	void testPaperBoxList() {
		paperBoxV2s = paperBoxService.findAll();
//		for (int i = 0; i < paperBoxV2s.size(); i++) {
//			paperBoxV2s.get(i).toString();
//		}

		paperBoxV2s.forEach(System.out::println);
	}

}
