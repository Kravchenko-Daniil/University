package com.example.app.Task912.conferences;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/conferences")
public class ConferencesController {

    private final ConferencesRepository conferencesRepository;

    public ConferencesController(ConferencesRepository conferencesRepository) {
        this.conferencesRepository = conferencesRepository;}


    @GetMapping("/main")
    public String conferencesMain(Model model) {
        model.addAttribute("conferences", conferencesRepository.findAll());
        return "/conferences/main";
    }

    @GetMapping("/conference")
    public String conference(@RequestParam(name = "id", required = false) Long id,
            Model model){
        Conference conference;
        if (id!=null) {
            conference = conferencesRepository.getReferenceById(id);
        } else {
            conference = new Conference();
        }
        model.addAttribute("conference", conference);
        return "/conferences/conference";
    }

    @GetMapping("/diagram")
    public String getDiagram(Model model){
        model.addAttribute("conferences", conferencesRepository.findAll());
        return "/conferences/diagram";
    }

    @PostMapping("/add")
    public String addConference(@ModelAttribute("conference") Conference conference){
        conferencesRepository.save(conference);
        return "redirect:/conferences/main";
    }

    @PostMapping("/delete")
    public String delFilm(@RequestParam("id") Long id){
        conferencesRepository.deleteById(id);
        return "redirect:/conferences/main";
    }

}
