package fr.nuit.de.l.info.NaturellementQuiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class easterEgg {

    @GetMapping("/easteregg")
    public ModelAndView easter(){
        ModelAndView model = new ModelAndView("easteregg.html");
        return model;
    }
}
