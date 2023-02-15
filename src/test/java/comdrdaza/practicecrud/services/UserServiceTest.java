package comdrdaza.practicecrud.services;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
/* import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status; */

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import comdrdaza.practicecrud.models.User;
/* import comdrdaza.practicecrud.services.UserService; */
import comdrdaza.practicecrud.repositories.UserRepository;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    UserService service;

    @Mock
    UserRepository repository;

    @Test
    public void test_get_one(){
        User drdaza = new User(1L, "drdaza", "drdaza123", "user");

        when(repository.findById(1L)).thenReturn(Optional.of(drdaza));

        User user = service.getUser(1L);

        assertThat(user.getId()).isEqualTo(1L);
        assertThat(user.getUsername()).isEqualTo("drdaza");
    }
}
