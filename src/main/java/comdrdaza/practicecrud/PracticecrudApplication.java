package comdrdaza.practicecrud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import comdrdaza.practicecrud.models.User;
import comdrdaza.practicecrud.repositories.UserRepository;

@SpringBootApplication
public class PracticecrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticecrudApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(UserRepository users, PasswordEncoder encoder) {
		return args -> {
			users.save(new User(null, "user",encoder.encode("password"),"ROLE_USER"));
			users.save(new User(null, "admin",encoder.encode("password"),"ROLE_USER,ROLE_ADMIN"));
		};
	}
}
