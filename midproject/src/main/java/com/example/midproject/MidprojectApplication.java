package com.example.midproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@SpringBootApplication
public class MidprojectApplication {
    @Autowired
    private UsersRepository repo;
    public static void main(String[] args) {
        SpringApplication.run(MidprojectApplication.class, args);
    }
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("users",repo.findAll());
        return "index";
    }
}
