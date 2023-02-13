package comdrdaza.practicecrud.integration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import comdrdaza.practicecrud.models.User;
import comdrdaza.practicecrud.repositories.UserRepository;


@DataJpaTest
@ContextConfiguration(classes = {UserRepository.class})
public class UserRepositoryIntegration {
    
    @Autowired
    UserRepository repository;

    @Test 
    public void testFindById() {
       User user = repository.findById(1L).orElseThrow();
       assertThat(user.getUsername()).isEqualTo("drdaza");
    }
}
