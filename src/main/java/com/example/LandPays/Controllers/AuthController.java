package com.example.LandPays.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth/landpays")
public class AuthController {

    @GetMapping("/home")
    public String index(){
        return "welcome to LandPays";
    }

}
