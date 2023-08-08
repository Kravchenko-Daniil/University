package com.example.app.Task912.cinema;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cinema")
public class CinemaController {

    private final CinemaRepository cinemaRepository;

    public CinemaController(CinemaRepository cinemaRepository) {this.cinemaRepository = cinemaRepository;}


    @GetMapping("/main")
    public String cinemaMain(Model model) {
        model.addAttribute("cinema", cinemaRepository.findAll());
        return "/cinema/main";
    }

    @GetMapping("/film")
    public String film(@RequestParam(name = "id", required = false) Long id,
            Model model){
        Film film;
        if (id!=null) {
            film = cinemaRepository.getReferenceById(id);
        } else {
            film = new Film();
        }
        model.addAttribute("film", film);
        return "/cinema/film";
    }

    @GetMapping("/diagram")
    public String getDiagram(Model model){
        model.addAttribute("cinema", cinemaRepository.findAll());
        return "/cinema/diagram";
    }


    @PostMapping("/add")
    public String addFilm(@ModelAttribute("film") Film film){
        cinemaRepository.save(film);
        return "redirect:/cinema/main";
    }

    @PostMapping("/delete")
    public String delFilm(@RequestParam("id") Long id){
        cinemaRepository.deleteById(id);
        return "redirect:/cinema/main";
    }

}
