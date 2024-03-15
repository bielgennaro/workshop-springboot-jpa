package com.educandoweb.course.config;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    
    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Gabriel Zirondi", "4399999", "zirondigabriel@gmail.com", "12345");
        User u2 = new User(null, "Felipe Silva", "4399999", "felipe@gmail.com", "12345");
        User u3 = new User(null, "Lucas Andrade", "4399999", "lucas@gmail.com", "12345");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));
    }
}
