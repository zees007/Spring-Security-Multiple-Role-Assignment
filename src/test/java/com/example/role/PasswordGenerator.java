package com.example.role;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Nov 27, 2020
 */
public class PasswordGenerator {
    public static void main(String[] args){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "test2day";
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println(encodedPassword);
    }
}
