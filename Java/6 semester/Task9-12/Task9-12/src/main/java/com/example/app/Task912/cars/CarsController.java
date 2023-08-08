package com.example.app.Task912.cars;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")
public class CarsController {

    private final CarsRepository carsRepository;

    public CarsController(CarsRepository carsRepository) {this.carsRepository = carsRepository;}


    @GetMapping("/main")
    public String carsMain(Model model) {
        model.addAttribute("cars", carsRepository.findAll());
        return "/cars/main";
    }

    @GetMapping("/diagram")
    public String getDiagram(Model model){
        model.addAttribute("cars", carsRepository.findAll());
        return "/cars/diagram";
    }


    @GetMapping("/car")
    public String car(@RequestParam(name = "id", required = false) Long id,
            Model model){
        Car car;
        if (id!=null) {
            car = carsRepository.getReferenceById(id);
        } else {
            car = new Car();
        }
        model.addAttribute("car", car);
        return "/cars/car";
    }

    @PostMapping("/add")
    public String addCar(@ModelAttribute("car") Car car){
        carsRepository.save(car);
        return "redirect:/cars/main";
    }

    @PostMapping("/delete")
    public String delCar(@RequestParam("id") Long id){
        carsRepository.deleteById(id);
        return "redirect:/cars/main";
    }


}
