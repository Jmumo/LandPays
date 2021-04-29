package com.example.LandPays.Registration;

import com.example.LandPays.AppUser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/auth/landpays")
public class RegistrationController {
    private final RegistrationService registrationService;
    private final AppUserService appUserService;

    @PostMapping("/reg")
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);

    }
    @GetMapping("/user")
    public List Tenants(){
        return appUserService.fetchAll();
    }
}
