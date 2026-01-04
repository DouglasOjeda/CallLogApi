package com.douglasojeda.calllog.controller;

import com.douglasojeda.calllog.dto.user.CreateUserRequest;
import com.douglasojeda.calllog.dto.user.UserResponse;
import com.douglasojeda.calllog.mapper.user.UserMapper;
import com.douglasojeda.calllog.model.user.User;
import com.douglasojeda.calllog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse addUser(@RequestBody CreateUserRequest req) {
        User created = userService.addUser(req.displayName());
        return UserMapper.toResponse(created);
    }

    @PostMapping("/users/{userId}/contacts/{contactId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addContact(@PathVariable Long userId, @PathVariable Long contactId) {
        userService.addContact(userId, contactId);
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
