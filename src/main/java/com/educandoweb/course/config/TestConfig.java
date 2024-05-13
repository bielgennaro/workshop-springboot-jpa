package com.educandoweb.course.config;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.ProductRepository;
import com.educandoweb.course.repositories.UserRepository;
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
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private ProductRepository productRepository;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Gabriel Marques", "4399999", "zirondigabriel@gmail.com", "12345");
        User u2 = new User(null, "Felipe Silva", "4399999", "felipe@gmail.com", "12345");
        User u3 = new User(null, "Lucas Andrade", "4399999", "lucas@gmail.com", "12345");

        Order o1 = new Order(null, Instant.parse("2024-06-12T19:53:07Z"), OrderStatus.DELIVERED, u1);
        Order o2 = new Order(null, Instant.parse("2024-02-20T11:32:02Z"), OrderStatus.PAID, u2);
        Order o3 = new Order(null, Instant.parse("2024-08-22T09:23:02Z"), OrderStatus.SHIPPED, u3);

        Category c1 = new Category(null, "Scholar");
        Category c2 = new Category(null, "Eletronics");
        Category c3 = new Category(null, "Computers");
        
        Product p1 = new Product(null, "The lord of the rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Lorem ipsum dolor sit amet, consectetur.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Lorem ipsum dolor sit amet, consectetur.", 3400.0, "");
        
        userRepository.saveAll(Arrays.asList(u1, u2, u3));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3));

        p1.getCategories().add(c1);
        p2.getCategories().add(c2);
        p3.getCategories().add(c3);
        
        productRepository.saveAll(Arrays.asList(p1, p2, p3));
    }
}
