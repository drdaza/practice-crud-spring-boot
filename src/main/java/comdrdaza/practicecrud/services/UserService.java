package comdrdaza.practicecrud.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import comdrdaza.practicecrud.models.User;
import comdrdaza.practicecrud.repositories.UserRepository;

@Service
@Transactional
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> listAllUsers(){
        return repository.findAll();
    }
    public void saveUser(User user){
       repository.save(user);
    }
    public User getUser(Long id){
        return repository.findById(id).get();
    }
    public List<User> deleteUser(Long id){
        repository.deleteById(id);
        return listAllUsers();
    }
}
