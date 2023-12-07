package fr.nuit.de.l.info.NaturellementQuiz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Reponse extends JpaRepository<Reponse,Long> {
}
