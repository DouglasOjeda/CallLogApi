package com.douglasojeda.calllog.repository;

import com.douglasojeda.calllog.model.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void userRepositorySave() {
//        User user = new User();
//        user.setDisplayName("Douglas");
//
//        User savedUser = userRepository.save(user);
//
//        assertNotNull(savedUser);
//        assertEquals("Douglas", savedUser.getDisplayName());
//        assertEquals(savedUser.getUserId(), user.getUserId());
//        assertNull(user.getContacts());

    }

    @Test
    public void userRepositoryFindAll() {
//        User user = new User();
//        user.setDisplayName("Douglas");
//
//        User user2 = new User();
//        user2.setDisplayName("Will");
//
//        User savedUser = userRepository.save(user);
//        User savedUser2 = userRepository.save(user2);
//
//        List<User> users = userRepository.findAll();
//
//        assertNotNull(savedUser);
//        assertNotNull(savedUser2);
//        assertEquals(2, users.size());
//        assertEquals(savedUser.getUserId(), users.get(0).getUserId());
//        assertEquals(savedUser2.getUserId(), users.get(1).getUserId());
    }

    @Test
    public void userRepositoryFindById() {
//        User user = new User();
//        user.setDisplayName("Douglas");
//
//        User savedUser = userRepository.save(user);
//
//        Optional<User> foundUser = userRepository.findById(savedUser.getUserId());
//        assertTrue(foundUser.isPresent());
//        assertEquals(savedUser.getUserId(), foundUser.get().getUserId());
    }

    @Test
    public void userRepositoryUpdate() {
//        User user = new User();
//        user.setDisplayName("Douglas");
//
//        User savedUser = userRepository.save(user);
//
//        User user2 = new User();
//        user2.setDisplayName("Will");
//        user2.setUserId(savedUser.getUserId());
//
//        userRepository.save(user2);
//
//        Optional<User> foundUser = userRepository.findById(savedUser.getUserId());
//
//        assertTrue(foundUser.isPresent());
//        assertEquals(savedUser.getUserId(), foundUser.get().getUserId());
//        assertEquals("Will",  foundUser.get().getDisplayName());
    }

    @Test
    public void userRepositoryDelete() {
//        User user = new User();
//        user.setDisplayName("Douglas");
//
//        User savedUser = userRepository.save(user);
//
//        userRepository.deleteById(savedUser.getUserId());
//
//        List<User> users = userRepository.findAll();
//
//        assertTrue(users.isEmpty());
    }

}