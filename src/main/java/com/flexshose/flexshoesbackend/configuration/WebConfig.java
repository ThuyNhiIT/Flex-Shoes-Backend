package com.flexshose.flexshoesbackend.configuration;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.flexshose.flexshoesbackend.entity.Account;
import com.flexshose.flexshoesbackend.entity.Role;
import com.flexshose.flexshoesbackend.repository.AccountRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class WebConfig implements WebMvcConfigurer {
	
	PasswordEncoder passwordEncoder;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
    
    @Bean
	ApplicationRunner applicationRunner(AccountRepository accountRepository) {
		return args -> {
			if(accountRepository.findByUsername("admin").isEmpty()) {
				accountRepository.save(
						Account.builder()
						.username("admin")
						.password(passwordEncoder.encode("admin"))
						.role(Role.ADMIN)
						.build()
						);
			}
			log.warn("Admin account has been created with default password: admin . Please change it after first login.");
                
		};
	}
}