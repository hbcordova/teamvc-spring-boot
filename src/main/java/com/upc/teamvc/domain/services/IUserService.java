package com.upc.teamvc.domain.services;

import com.upc.teamvc.domain.models.User;
import com.upc.teamvc.resources.UserResource;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAll();
    Optional<User> getById(Long id);
    User create(User user);
    User update(Long id, User user);
    User delete(Long id);
}
