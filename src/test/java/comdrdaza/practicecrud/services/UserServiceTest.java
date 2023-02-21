package comdrdaza.practicecrud.services;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

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

    @Test 
    public void test_find_all(){
        User drdaza = new User(1L, "drdaza", "drdaza123", "user");
        User davidD = new User(1L, "davidD", "davidD123", "user");

        List<User> users = new ArrayList<>();

        users.add(davidD);
        users.add(drdaza);

        when(repository.findAll()).thenReturn(users);

        List<User> allUsers = service.listAllUsers();


        assertThat(allUsers.size()).isEqualTo(2);
        
    }
}
