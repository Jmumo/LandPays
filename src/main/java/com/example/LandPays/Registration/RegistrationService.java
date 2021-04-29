package com.example.LandPays.Registration;


import com.example.LandPays.AppUser.AppUser;
import com.example.LandPays.AppUser.AppUserRole;
import com.example.LandPays.AppUser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final EmailValidator emailValidator;
    private final AppUserService appUserService;
    private final String message = "email %s not valid";

public  String register(RegistrationRequest request){

    boolean isvalidemail = emailValidator.test(request.getEmail());

    if(isvalidemail){


       return appUserService.signup(
         new AppUser(
                 request.getFirstname(),
                 request.getLastname(),
                 request.getPassword(),
                 request.getEmail(),
                 AppUserRole.USER,
                 request.getHouse_booked()
         )
      );

    }else{
        throw new IllegalStateException(String.format(message,request.getEmail()));
    }

}


}
