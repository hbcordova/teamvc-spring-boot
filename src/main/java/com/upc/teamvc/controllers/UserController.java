package com.upc.teamvc.controllers;

import com.upc.teamvc.mapping.UserMapper;
import com.upc.teamvc.resources.UserResource;
import com.upc.teamvc.resources.UserSaveResource;
import com.upc.teamvc.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;
    private final UserMapper mapper;

    public UserController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping()
    public List<UserResource> getAllUser() {
        return mapper.toResource(userService.getAll());
    }

    @GetMapping("{id}")
    UserResource getByUserId(@PathVariable Long id) {
        return mapper.toResource(userService.getById(id).orElse(null));
    }

    @PostMapping()
    public UserResource createUser(@RequestBody UserSaveResource saveResource) {
        return mapper.toResource(userService.create(mapper.toModel(saveResource)));
    }

    @PutMapping("{userId}")
    public UserResource updateUser(@RequestBody UserSaveResource saveResource, @PathVariable Long userId) {
        return mapper.toResource(userService.update(userId, mapper.toModel(saveResource)));
    }

    @DeleteMapping("{userId}")
    public UserResource deleteUser(@PathVariable Long userId) {
        return mapper.toResource(userService.delete(userId));
    }

}
