package comdrdaza.practicecrud.controllers;


import java.util.ArrayList;
import java.util.List;
import comdrdaza.practicecrud.models.User;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import comdrdaza.practicecrud.services.UserService;

@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService service;

    @Test
    void test_index_return_all_user() throws Exception{

        List<User> users = new ArrayList<>();
        User drdaza = new User(null, "drdaza", "drdaza123");
        User aniquilador = new User(null, "aniquilador", "aniquiler123");
        users.add(drdaza);
        users.add(aniquilador);

        when(service.listAllUsers()).thenReturn(users);
        MockHttpServletResponse response = mockMvc.perform(get("/api/users").contentType("aplication/json"))
        .andExpect(status().isOk())
        .andReturn()
        .getResponse();

        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(response.getContentAsString()).contains("drdaza");
        assertThat(response.getContentAsString()).contains("aniquilador");
        assertThat(response.getContentAsString()).isEqualTo("[{\"id\":null,\"username\":\"drdaza\",\"password\":\"drdaza123\"},{\"id\":null,\"username\":\"aniquilador\",\"password\":\"aniquiler123\"}]");
    }
}
