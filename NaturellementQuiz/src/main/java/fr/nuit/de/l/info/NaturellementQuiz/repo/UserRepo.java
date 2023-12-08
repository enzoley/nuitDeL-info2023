package fr.nuit.de.l.info.NaturellementQuiz.repo;

import fr.nuit.de.l.info.NaturellementQuiz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
