package fr.nuit.de.l.info.NaturellementQuiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class NaturellementQuizzApplication {

	public static void main(String[] args) {

		SpringApplication.run(NaturellementQuizzApplication.class, args);
	}

}
