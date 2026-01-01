package com.douglasojeda.calllog.service;

import com.douglasojeda.calllog.model.user.User;
import com.douglasojeda.calllog.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    @Test
    public void addUserShouldAddUserSuccessfully() {
        User user = new User();
        user.setUserId(1L);
        user.setDisplayName("Douglas");
        Mockito.when(userRepository.save(user)).thenReturn(user);
        User addedUser = userService.addUser(user);
        assertEquals(addedUser.getDisplayName(), user.getDisplayName());
    }

    @Test
    public void deleteUserShouldDeleteUserSuccessfully() {
        Mockito.doNothing().when(userRepository).deleteById(1L);
        userService.deleteUserById(1L);
        Mockito.verify(userRepository, times(1)).deleteById(1L);
    }
}