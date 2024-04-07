package com.backend.todolist;

import com.backend.todolist.model.Todo;
import com.backend.todolist.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages = "com.backend.todolist")
@EnableAutoConfiguration
public class ToDoListApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToDoListApplication.class, args);
    }

    // Code that generates dummy data for testing, to be removed
    @Bean
    public CommandLineRunner demo(TodoRepository item) {
        return (args) -> {
            // save a few customers
            item.save(new Todo("Titanium1", false));
            item.save(new Todo("Titanium2", false));
            item.save(new Todo("Titanium3", false));
            item.save(new Todo("Titanium4", false));
            item.save(new Todo("Titanium5", false));
            item.save(new Todo("Titanium6", false));
            item.save(new Todo("Titanium7", false));
            item.save(new Todo("Titanium8", false));
        };
    }

    // CORS configuration
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**") // Allow CORS for all endpoints under /api
                        .allowedOrigins("http://localhost:3000") // Allow requests from this origin
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow these methods
                        .allowedHeaders("*"); // Allow all headers
            }
        };
    }

}
