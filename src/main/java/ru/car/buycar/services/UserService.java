package ru.car.buycar.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.car.buycar.models.User;
import ru.car.buycar.models.enums.Role;
import ru.car.buycar.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public void registration(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.USER);
        user.setActive(true);
        userRepository.save(user);
    }
}
