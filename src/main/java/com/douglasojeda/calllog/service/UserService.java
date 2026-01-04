package com.douglasojeda.calllog.service;

import com.douglasojeda.calllog.model.user.User;
import com.douglasojeda.calllog.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById (Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));
    }

    @Transactional
    public User addUser(String displayName) {
        User user = new User(displayName);
        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(Long id, String displayName) {
        User u = getUserById(id);
        u.setDisplayName(displayName);
        return userRepository.save(u);
    }

    @Transactional
    public void deleteUserById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found: " + id);
        }
        userRepository.deleteById(id);
    }

    @Transactional
    public void addContact(Long userId, Long contactId) {
        if (userId.equals(contactId)) {
            throw new IllegalArgumentException("Cannot add yourself as a contact.");
        }
        User user = getUserById(userId);
        User contact = getUserById(contactId);

        user.addContact(contact);
    }

    @Transactional
    public void removeContact(Long userId, Long contactId) {
        User user = getUserById(userId);
        User contact = getUserById(contactId);

        user.removeContact(contact);
    }
}
