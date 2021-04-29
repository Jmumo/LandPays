package com.example.LandPays.AppUser;

import com.example.LandPays.HouseManager.House;
import com.example.LandPays.HouseManager.HouseRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final AppUserRepository appUserRepository;
    private final HouseRepository houseRepository;
    private final static String Message = " user with the email %s not found";
    private final static String emailError = "email %s is already taken";
    private final static String HouseError = "house number %s not found";
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException(String.format(Message,email)));
    }
    public String signup(AppUser appuser){
        boolean userExist = appUserRepository.findByEmail(appuser.getEmail()).isPresent();
        if(userExist){
            throw new IllegalStateException(String.format(emailError,appuser.getEmail()));
        }
        else {
            String encodedPassword = bCryptPasswordEncoder.encode(appuser.getPassword());
            appuser.setPassword(encodedPassword);
            //find house booked and update user details in house table
            House house_booked =  houseRepository.findById(appuser.getHouse_booked()).orElseThrow(()->new
                    IllegalStateException(String.format(HouseError,appuser.getHouse_booked()))
            );
            house_booked.setTenant(appuser.getFirstname());

            houseRepository.save(house_booked);

            appUserRepository.save(appuser);
        }
        return "user saved";
    }

    public List fetchAll() {
        return appUserRepository.findAll();
    }
}
