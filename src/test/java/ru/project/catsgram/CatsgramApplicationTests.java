package ru.project.catsgram;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import ru.project.catsgram.model.User;
import ru.project.catsgram.model.Post;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class CatsgramApplicationTests {

	@Test
	void correctSortingPosts() {
		Post post1 = new Post("Paul", "Description1", "1.jpg");
		Post post2 = new Post("Alex", "Description2", "2.jpg");
		Post post3 = new Post("Andrew", "Description3", "3.jpg");
		List<Post> list = new ArrayList<>();
		list.add(post1);
		list.add(post2);
		list.add(post3);
		Collections.sort(list);

		for (Post post : list) {
			System.out.println(post.getAuthor());
		}
		System.out.println();

		Collections.reverse(list);

		for (Post post : list) {
			System.out.println(post.getAuthor());
		}
	}

}
