package fr.nuit.de.l.info.NaturellementQuiz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pseudo;

    private int score;

    public User(String pseudo){
        this.pseudo = pseudo;
        this.score = 0;
    }

    public User() {

    }
}
