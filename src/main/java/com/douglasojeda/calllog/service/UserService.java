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
        return userRepository.findById(id).orElse(null);
    }

    public User addUser(String displayName) {
        User user = new User(displayName);
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public User addContact(Long userId, Long contactId) {
        if (userId.equals(contactId)) {
            throw new IllegalArgumentException("You cannot add yourself as a contact.");
        }
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found: " + userId));
        User contact = userRepository.findById(contactId)
                .orElseThrow(() -> new RuntimeException("Contact not found: " + contactId));
        boolean alreadyAdded = user.getContacts().stream()
                .anyMatch(u -> u.getUserId().equals(contactId));
        if (!alreadyAdded) {
            user.getContacts().add(contact);
        }
        return userRepository.save(user);
    }
}
