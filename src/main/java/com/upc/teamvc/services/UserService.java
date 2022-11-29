package com.upc.teamvc.services;

import com.upc.teamvc.domain.models.User;
import com.upc.teamvc.domain.repository.IUserRepository;
import com.upc.teamvc.domain.services.IUserService;
import com.upc.teamvc.resources.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private final IUserRepository repository;

    public UserService(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<User> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        return repository.findById(id).map(oldUser -> repository.save(oldUser
                .withDni(user.getDni())
                .withEmail(user.getEmail())
                .withName(user.getName())
                .withPassword(user.getPassword()))).orElse(null);
    }

    @Override
    public User delete(Long id) {
        return repository.findById(id).map(user -> {repository.delete(user); return user;}).orElseThrow();
    }
}
