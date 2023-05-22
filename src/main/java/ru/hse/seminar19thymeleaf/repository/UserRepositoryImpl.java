package ru.hse.seminar19thymeleaf.repository;

import org.springframework.stereotype.Repository;
import ru.hse.seminar19thymeleaf.model.User;

import java.util.*;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final List<User> users = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public Optional<User> findById(Long id) {
        return users.stream()
                .filter(user -> Objects.equals(user.getId(), id))
                .findAny();
    }

    @Override
    public List<User> findAll() {
        return users.stream().toList();
    }

    @Override
    public void save(User user) {
        if (user.getId() == null) {
            user.setId(nextId++);
            users.add(user);
        } else {
            delete(user);
            users.add(user);
        }
    }

    @Override
    public void delete(User user) {
        users.removeIf(user1 -> Objects.equals(user.getId(), user1.getId()));
    }
}
