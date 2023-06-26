package ru.car.buycar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.car.buycar.models.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}

