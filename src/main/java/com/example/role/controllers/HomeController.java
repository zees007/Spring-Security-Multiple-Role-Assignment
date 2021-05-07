package com.example.role.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Nov 28, 2020
 */
@RestController
public class HomeController {

    @GetMapping(value = "/")
    public String home(){
        return "hello";
    }

    @GetMapping(value = "/private")
    public String privateArea(){
        return "private";
    }
}
