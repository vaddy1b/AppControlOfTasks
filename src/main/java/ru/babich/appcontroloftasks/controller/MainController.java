package ru.babich.appcontroloftasks.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.babich.appcontroloftasks.entity.User;
import ru.babich.appcontroloftasks.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> findAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/user/create")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity <User> updateUser(@PathVariable Long id, @RequestBody User user){
        User updatedUser = userService.findUserById(id);
        userService.updateUser(id);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
