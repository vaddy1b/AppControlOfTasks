package ru.babich.appcontroloftasks.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.babich.appcontroloftasks.entity.Task;
import ru.babich.appcontroloftasks.entity.User;
import ru.babich.appcontroloftasks.repository.TaskRepository;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.saveTask(task);
    }

    public Task findTaskById(Long id){
        return taskRepository.findTaskById(id);
    }

    public Task findTaskByUser(User user){
        return taskRepository.findTaskByUser(user);
    }

    public void updateTask(Long id){
        taskRepository.updateTask(id);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteTask(id);
    }
    
}
