package sample.testpractice.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class TestpracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestpracticeApplication.class, args);
	}

}
