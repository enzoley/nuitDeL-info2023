package fr.nuit.de.l.info.NaturellementQuiz.repo;

import fr.nuit.de.l.info.NaturellementQuiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Long> {
}
