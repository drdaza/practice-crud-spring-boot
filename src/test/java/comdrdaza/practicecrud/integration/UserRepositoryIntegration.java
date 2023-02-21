package comdrdaza.practicecrud.integration;

import java.util.List;

import org.junit.jupiter.api.Test;
import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import comdrdaza.practicecrud.models.User;
import comdrdaza.practicecrud.repositories.UserRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(value = false)
public class UserRepositoryIntegration {
    
    @Autowired
    UserRepository repository;

    @Autowired
    EntityManager entityManager;

    @Test 
    public void test_find_by_id() {
       User user = repository.findById(1L).orElseThrow();
       assertThat(user.getUsername()).isEqualTo("drdaza");
    }

    @Test 
    public void test_create_user(){
        User user = new User(null, "drdazaTest","drdaza123", "admin");
        User userSave = repository.save(user);

        assertThat(userSave.getId()).isEqualTo(3L);
        assertThat( userSave.getUsername()).isEqualTo("drdazaTest");
    }
    @Test
    public void test_delete_user(){
        User user = new User(null, "drdazaTest", "drdaza123", "user");
        User userSave  = repository.save(user);

        repository.deleteById(userSave.getId());
        Integer length = repository.findAll().size();

        assertThat(length).isEqualTo(2);
    }
    @Test
    public void test_update_user(){
        User userToEdit = repository.findById(2L).orElse(null);

        userToEdit.setUsername("davidDazaTest");

        User userEditSave = repository.save(userToEdit);

        assertThat(userEditSave.getId()).isEqualTo(2L);
        assertThat(userEditSave.getUsername()).isEqualTo("davidDazaTest");
    }
    @Test
    public void test_find_all(){
        List<User> users = repository.findAll();

        assertThat(users.size()).isEqualTo(2);
    }
}
