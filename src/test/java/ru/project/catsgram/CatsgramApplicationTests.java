package ru.project.catsgram;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class CatsgramApplicationTests {

	@Test
	void contextLoads() {
		User user = new User("qweirktl@mail.com", "katharsys", LocalDate.now());
	}

}
