package ru.babich.appcontroloftasks.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.babich.appcontroloftasks.entity.Task;
import ru.babich.appcontroloftasks.entity.User;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {


    Task findTaskById(Long id);
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,attributePaths = "task-user-graph")
    Task findTaskByUser(User user);

    Task saveTask(Task task);

    void updateTask(Long id);

    void deleteTask(Long id);
}
