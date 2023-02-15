package comdrdaza.practicecrud.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import comdrdaza.practicecrud.models.User;


public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByUsername(String username);
}
