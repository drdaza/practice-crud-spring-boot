package comdrdaza.practicecrud.integration;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


/* import comdrdaza.practicecrud.models.User; */
import comdrdaza.practicecrud.repositories.UserRepository;


@DataJpaTest
public class UserRepositoryIntegration {
    
    @Autowired
    UserRepository repository;

    /* @Test 
    public void testFindById() {
       User user = repository.findById(1L).orElseThrow();
       assertThat(user.getUsername()).isEqualTo("drdaza");
    } */
}
