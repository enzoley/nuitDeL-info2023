package fr.nuit.de.l.info.NaturellementQuiz.controller;

import fr.nuit.de.l.info.NaturellementQuiz.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class game {

    @Autowired
    private QuestionRepo questionRepo;

    @GetMapping("/game/{round}")
    public ModelAndView gameStart(@PathVariable(value = "round") int round){
        ModelAndView gameModel = new ModelAndView("game.html");
        int size = questionRepo.findAll().size();
        Long random = (long) (Math.random()*size);
        if(questionRepo.findById(random).isPresent()){
            String erreur = "";
            gameModel.addObject("question",questionRepo.findById(random).get());
            gameModel.addObject("erreur",erreur);

        }else{
            String erreur = "Une erreur est survenue";
            gameModel.addObject("erreur",erreur);
        }
        return gameModel;
    }
}
