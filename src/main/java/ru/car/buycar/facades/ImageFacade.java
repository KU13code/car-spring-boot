package ru.car.buycar.facades;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.car.buycar.models.Image;

import java.io.IOException;

@Component
public class ImageFacade {
    public Image toEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }
}

