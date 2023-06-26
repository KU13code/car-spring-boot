package ru.car.buycar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.car.buycar.models.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
       // List<Car> findByBrand(String brand);

}
