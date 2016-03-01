package io.community;

import io.community.domain.User;
import io.community.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class CommunityApplication {

    @Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CommunityApplication.class, args);
	}

    //@PostConstruct
    public void initData() {
        User alice = new User("Alice").addExpense(34d);
        alice.setEmail("alice@gmail.com");
        userRepository.save(alice);

        User bob = new User("Bob").addExpense(42d)
                .addExpense(3.14d);
        bob.setEmail("bob@gmail.com");
        userRepository.save(bob);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedMethods("GET", "POST")
                        .allowedOrigins("http://localhost:9000", "http://localhost:8080");
            }
        };
    }
}
