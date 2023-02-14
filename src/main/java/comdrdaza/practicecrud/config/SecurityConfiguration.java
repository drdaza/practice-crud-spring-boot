package comdrdaza.practicecrud.config;


import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    
    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.cors()
                    .and()
                    .csrf(csrf -> csrf.disable())
                    .formLogin(form -> form.disable())
                    .logout(out -> out
                                   .logoutUrl("/api/logout")
                                   .deleteCookies("JSESSIONID"))
                    .authorizeHttpRequests(auth -> auth
                                                   .antMatchers("/api/users").hasRole("USER")
                                                   .antMatchers("/api/users").hasRole("ADMIN")
                                                   .anyRequest().authenticated())
                    .headers(header -> header.frameOptions().disable())
                    .httpBasic(Customizer.withDefaults());   

        return httpSecurity.build();
    }

        @Bean
        InMemoryUserDetailsManager userDetailsManager(){

            PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            String password = encoder.encode("1234");

            System.out.println("this is password"+password);

            UserDetails user = User.withUsername("admin")
                               .password(password)
                               .roles("ADMIN")
                               .build(); 

            UserDetails user2 = User.withUsername("user")
                               .password(password)
                               .roles("USER")
                               .build(); 

            Collection<UserDetails> users = new ArrayList<>();
            
            users.add(user);
            users.add(user2);

            return new InMemoryUserDetailsManager(users);
        }
}
