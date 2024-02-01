package ru.project.catsgram;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.project.catsgram.model.User;

import java.time.LocalDate;

@SpringBootTest
class CatsgramApplicationTests {

	@Test
	void contextLoads() {
		User user = new User("qweirktl@mail.com", "katharsys", LocalDate.now());
	}

}
