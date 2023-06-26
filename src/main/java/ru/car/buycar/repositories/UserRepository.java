package ru.car.buycar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.car.buycar.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
