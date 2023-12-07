package fr.nuit.de.l.info.NaturellementQuiz.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Question {

    private String text;
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Reponse> reponses;

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public List<Reponse> getReponses() {
        List<Reponse> result = new ArrayList<>();
        if(this.reponses.size()>4){
            for (int i = 0; i < 5; i++) {
                int index = (int)(Math.random()*(reponses.size()-1));
                result.add(reponses.get(index));
            }
        }else{
            return reponses;
        }
        return result;
    }
}
