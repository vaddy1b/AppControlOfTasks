package ru.babich.appcontroloftasks.service;

import org.springframework.stereotype.Service;
import ru.babich.appcontroloftasks.entity.Task;
import ru.babich.appcontroloftasks.entity.User;
import ru.babich.appcontroloftasks.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Task> findAllUsersByTask(User user){
        return userRepository.findAllTasksOfUser(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.saveUser(user);
    }

    public User findUserById(Long id){
        return userRepository.findUserById(id);
    }

    public User findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public void updateUser(Long id){
        userRepository.updateUser(id);
    }

    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }
}
