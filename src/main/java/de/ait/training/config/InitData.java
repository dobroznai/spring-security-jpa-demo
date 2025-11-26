package de.ait.training.config;


import de.ait.training.model.AppUser;
import de.ait.training.repository.AppUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class InitData {

    @Bean
    CommandLineRunner initUsers(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if(appUserRepository.count() == 0) {
                String userPassword = passwordEncoder.encode("user123");
                String adminPassword = passwordEncoder.encode("admin123");
                AppUser appUser = new AppUser("user", userPassword, "ROLE_USER");
                AppUser adminUser = new AppUser("admin", adminPassword, "ROLE_ADMIN");

                appUserRepository.save(appUser);
                appUserRepository.save(adminUser);

            }

    };
}}
