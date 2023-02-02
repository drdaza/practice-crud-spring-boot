package comdrdaza.practicecrud.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import comdrdaza.practicecrud.repositories.UserRepository;

@Service
@Transactional
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    
}
