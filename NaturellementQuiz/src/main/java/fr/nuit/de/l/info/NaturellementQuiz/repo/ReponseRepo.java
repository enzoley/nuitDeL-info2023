package fr.nuit.de.l.info.NaturellementQuiz.repo;

import fr.nuit.de.l.info.NaturellementQuiz.model.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReponseRepo extends JpaRepository<Reponse,Long> {
}
