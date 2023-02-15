package comdrdaza.practicecrud.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


import comdrdaza.practicecrud.repositories.UserRepository;
import comdrdaza.practicecrud.models.SecurityUser;

@Service
public class JpaUserDetailsService implements UserDetailsService{

    private UserRepository repository;
    
    public JpaUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        SecurityUser user = repository.findByUsername(username)
                         .map(SecurityUser::new)
                         .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String password = encoder.encode("1234");

        user.setPassword(password); 

        System.out.println("this is the pass: " + user.getPassword());

        return user;
        
    }
    
}
