package ru.car.buycar.controllers;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.car.buycar.models.Image;
import ru.car.buycar.services.CarService;

import java.io.ByteArrayInputStream;
@RestController
public class ImageController {
    private final CarService carService;

    public ImageController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<?> getImage(@PathVariable Long id) {
        Image image = carService.getImageById(id);
        return ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(
                        new ByteArrayInputStream(image.getBytes())));
    }
}

