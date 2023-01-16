package de.neuefische.neuefischespringsecuritydemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.Optional;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        return http
            .csrf().disable()
            .httpBasic().and()
            .authorizeHttpRequests()
            .anyRequest()
            .authenticated()
            .and()
            .build();
    }

    @Bean
    public UserDetailsService userDetailsService () {
        return username -> {
            List<AppUser> appUsers = List.of(
                new AppUser("1", "elvedin", "password"),
                new AppUser("2", "muslim", "drowssap")
            );

            Optional<AppUser> user = appUsers.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst();

            if (user.isEmpty()) {
                throw new UsernameNotFoundException(username);
            }

            AppUser appUser = user.get();

            return User.builder()
                .username(appUser.getUsername())
                .password(appUser.getPassword())
                .build();
        };
    }
}
