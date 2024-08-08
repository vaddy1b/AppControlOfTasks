package ru.babich.appcontroloftasks.controller;

import org.springframework.stereotype.Controller;
import ru.babich.appcontroloftasks.entity.User;
import ru.babich.appcontroloftasks.service.UserService;

import java.util.List;

@Controller(value = "/mainpage")
public class MainController {

    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    public List<User> findAllUsers(){
       return userService.getAllUsers();
   }
}
