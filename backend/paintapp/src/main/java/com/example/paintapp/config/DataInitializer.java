package com.example.paintapp.config;

import com.example.paintapp.model.User;
import com.example.paintapp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    @Bean
    public CommandLineRunner initUsers(UserRepository userRepository) {
        return args -> {
            if (userRepository.count() == 0) {
                userRepository.save(new User("User1", "default1", 1L));
                userRepository.save(new User("User2","default2",2L));
                userRepository.save(new User("User3", "default3",3L));
            }
        };
    }
}