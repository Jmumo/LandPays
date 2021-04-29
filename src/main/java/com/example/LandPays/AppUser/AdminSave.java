package com.example.LandPays.AppUser;

import lombok.AllArgsConstructor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@AllArgsConstructor
@Configuration
public class AdminSave implements CommandLineRunner {
     private BCryptPasswordEncoder bCryptPasswordEncoder;
     private final AppUserRepository appUserRepository;
    @Override
    public void run(String... args) throws Exception {
     AppUser admin = new AppUser(
             "admin",
             "admin",
            bCryptPasswordEncoder.encode("admin"),
             "admin@gmail.com",
             AppUserRole.ADMIN

     );
     appUserRepository.save(admin);

    }
}
