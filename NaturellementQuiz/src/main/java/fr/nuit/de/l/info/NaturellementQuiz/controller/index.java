package fr.nuit.de.l.info.NaturellementQuiz.controller;

import fr.nuit.de.l.info.NaturellementQuiz.repo.QuestionRepo;
import fr.nuit.de.l.info.NaturellementQuiz.repo.ReponseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class index {
    @Autowired
    private QuestionRepo questionRepo;
    @Autowired
    private ReponseRepo reponseRepo;

    @GetMapping("/")
    public ModelAndView accueil(){
        ModelAndView model = new ModelAndView("index.html");
        model.addObject("questions",questionRepo.findAll());
        model.addObject("reponses", reponseRepo.findAll());
        return model;
    }
}
