package com.educandoweb.course.config;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.resources.OrderResource;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Gabriel Marques", "4399999", "zirondigabriel@gmail.com", "12345");
        User u2 = new User(null, "Felipe Silva", "4399999", "felipe@gmail.com", "12345");
        User u3 = new User(null, "Lucas Andrade", "4399999", "lucas@gmail.com", "12345");

        Order o1 = new Order(null, Instant.parse("2024-06-12T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2024-02-20T11:32:02Z"), u2);
        Order o3 = new Order(null, Instant.parse("2024-08-22T09:23:02Z"), u3);
        
        userRepository.saveAll(Arrays.asList(u1, u2, u3));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
