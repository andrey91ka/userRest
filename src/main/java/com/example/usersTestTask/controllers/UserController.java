package com.example.usersTestTask.controllers;


import com.example.usersTestTask.model.User;
import com.example.usersTestTask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String Users(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/user-add")
    public String createUser(User user) {
        return "user-add";
    }

    @PostMapping("/user-add")
    public String saveUser(User user) {
        userService.saveUser(user);
        return "redirect:users";
    }

    @GetMapping("show-user/{id}")
    public String showUser(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute(user);
        return "show-user";
    }

}
