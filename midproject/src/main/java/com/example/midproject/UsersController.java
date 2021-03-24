package com.example.midproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/add")
    public @ResponseBody
    String addNewUser(@RequestBody Users user){
        usersRepository.save(user);
        return "ok";
    }
    @GetMapping("/all")
    public @ResponseBody Iterable<Users> getAllUsers(){
        return usersRepository.findAll();
    }
    @GetMapping("/{id}")
    Users one(@PathVariable Integer id) {
        return usersRepository.findById(id).orElseThrow(() -> new UsersNotFoundException (id));
    }
    @DeleteMapping("/{id}")
    void del(@PathVariable Integer id) {
        usersRepository.deleteById(id);
    }
}

