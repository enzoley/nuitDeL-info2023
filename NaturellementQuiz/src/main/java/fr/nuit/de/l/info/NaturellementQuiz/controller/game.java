package fr.nuit.de.l.info.NaturellementQuiz.controller;

import fr.nuit.de.l.info.NaturellementQuiz.Game;
import fr.nuit.de.l.info.NaturellementQuiz.repo.QuestionRepo;
import fr.nuit.de.l.info.NaturellementQuiz.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class game {

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/game")
    public ModelAndView gameStart(@RequestParam int failure) {
        ModelAndView gameModel = new ModelAndView("game.html");
        gameModel.addObject("user",Game.player );
        gameModel.addObject("round",Game.listIdQuestion.size()+1);
        gameModel.addObject("vie",Game.player.getScore()-failure);
        int size = questionRepo.findAll().size();
        Long random = getRandom(size);
        if (questionRepo.findById(random).isPresent()) {
            String erreur = "";
            gameModel.addObject("question", questionRepo.findById(random).get());
            gameModel.addObject("erreur", erreur);

        } else {
            String erreur = "Une erreur est survenue";
            gameModel.addObject("erreur", erreur);
        }


        return gameModel;
    }

    private Long getRandom(int size) {
        Long random = (long) (Math.random() * size);
        if (Game.listIdQuestion.contains(random)) {
            return getRandom(size);
        } else {
            Game.listIdQuestion.add(random);
            return random;
        }
    }
}
