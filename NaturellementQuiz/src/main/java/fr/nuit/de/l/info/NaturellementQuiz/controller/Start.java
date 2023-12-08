package fr.nuit.de.l.info.NaturellementQuiz.controller;

import fr.nuit.de.l.info.NaturellementQuiz.Game;
import fr.nuit.de.l.info.NaturellementQuiz.model.User;
import fr.nuit.de.l.info.NaturellementQuiz.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Start {
    @Autowired
    private UserRepo userRepo;

    @PostMapping("/start")
    public ModelAndView starting(@ModelAttribute User user){
        ModelAndView model = new ModelAndView("starting.html");
        Game.player = user;
        userRepo.save(user);
        return model;
    }
}
