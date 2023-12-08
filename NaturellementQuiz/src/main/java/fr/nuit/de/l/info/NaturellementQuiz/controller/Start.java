package fr.nuit.de.l.info.NaturellementQuiz.controller;

import fr.nuit.de.l.info.NaturellementQuiz.Game;
import fr.nuit.de.l.info.NaturellementQuiz.model.User;
import fr.nuit.de.l.info.NaturellementQuiz.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Start {
    @Autowired
    private UserRepo userRepo;

    @PostMapping("/start")
    public void starting(@ModelAttribute User user){
        Game.player = user;
        userRepo.save(user);
    }
}
