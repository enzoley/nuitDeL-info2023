package fr.nuit.de.l.info.NaturellementQuiz.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private boolean reponse;

    public String getText() {
        return text;
    }
}

