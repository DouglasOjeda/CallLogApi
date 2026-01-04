package com.douglasojeda.calllog.controller;

import com.douglasojeda.calllog.dto.user.CreateUserRequest;
import com.douglasojeda.calllog.dto.user.UpdateUserRequest;
import com.douglasojeda.calllog.dto.user.UserResponse;
import com.douglasojeda.calllog.mapper.user.UserMapper;
import com.douglasojeda.calllog.model.user.User;
import com.douglasojeda.calllog.service.UserService;
import jakarta.validation.Valid;
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
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers().stream()
                .map(UserMapper::toResponse)
                .toList();
    }

    @GetMapping("/users/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return UserMapper.toResponse(user);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@Valid @RequestBody CreateUserRequest req) {
        User created = userService.createUser(req.displayName());
        return UserMapper.toResponse(created);
    }

    @PutMapping("/users/{id}")
    public UserResponse updateUser(@PathVariable Long id, @Valid @RequestBody UpdateUserRequest req) {
        User updated = userService.updateUser(id, req.displayName());
        return UserMapper.toResponse(updated);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    //User Contacts

    @PostMapping("/users/{userId}/contacts/{contactId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addContact(@PathVariable Long userId, @PathVariable Long contactId) {
        userService.addContact(userId, contactId);
    }

    @DeleteMapping("/users/{userId}/contacts/{contactId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeContact(@PathVariable Long userId, @PathVariable Long contactId) {
        userService.removeContact(userId, contactId);
    }

    @GetMapping("/users/{userId}/contacts")
    public List<UserResponse> getContacts(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return user.getContacts().stream()
                .map(UserMapper::toResponse)
                .toList();
    }
}
