package com.douglasojeda.calllog.controller;

import com.douglasojeda.calllog.model.user.User;
import com.douglasojeda.calllog.service.UserService;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @MockitoBean
    private UserService userService;

    @Test
    public void getAllUsers_returnsList() throws Exception {
        User u1 = new User();
        User u2 = new User();
        u1.setUserId(1L);
        u2.setUserId(2L);
        u1.setDisplayName("Douglas");
        u2.setDisplayName("Robert");

        Mockito.when(userService.getAllUsers()).thenReturn(List.of(u1, u2));

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].userId").value(1))
                .andExpect(jsonPath("$[0].displayName").value("Douglas"))
                .andExpect(jsonPath("$[1].userId").value(2))
                .andExpect(jsonPath("$[1].displayName").value("Robert"));
    }

    @Test
    public void getUserById_returnsUser() throws Exception {
        User u1 = new User();
        u1.setUserId(1L);
        u1.setDisplayName("Douglas");
    }
}