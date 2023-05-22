package ru.hse.seminar19thymeleaf.repository;

import ru.hse.seminar19thymeleaf.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id);
    List<User> findAll();
    void save(User user);
    void delete(User user);
}
