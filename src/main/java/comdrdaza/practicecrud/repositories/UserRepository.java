package comdrdaza.practicecrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import comdrdaza.practicecrud.models.User;


public interface UserRepository extends JpaRepository<User, Long> {
    
}
