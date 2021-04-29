package com.example.LandPays.Registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Pattern;

@Service
public class EmailValidator implements Predicate<String>{
    @Override
    public boolean test(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

        Pattern pattern = Pattern.compile(regex);
        if(pattern.matcher(email).matches()){
            return true;
        }else{
            return false;
        }
    }
}
