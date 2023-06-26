package ru.car.buycar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.car.buycar.models.Car;
import ru.car.buycar.services.CarService;

import java.io.IOException;

@Controller
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping
    public  String cars(@RequestParam(value = "search_request", required = false) String key, Model model){
        if (key == null) model.addAttribute("cars", carService.getAll());
        else {
            model.addAttribute("search_request", key);
            model.addAttribute("cars", carService.search(key));
        }
        return "cars";
    }

    @GetMapping("/{id}")
    public String carInfo(@PathVariable("id") Long id, Model model){
        model.addAttribute(carService.getById(id));
        return "car-info";
    }


    @PostMapping("/")
    public String save(@RequestParam("file") MultipartFile image, Car car) throws IOException {
        carService.save(car, image);
        return "redirect:/";
    }
}




























