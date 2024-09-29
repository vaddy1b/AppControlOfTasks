package ru.babich.appcontroloftasks.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.babich.appcontroloftasks.entity.Task;
import ru.babich.appcontroloftasks.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, value = "user-tasks-comments-graph")
    List<Task> findAllInfoConnectingToUser(User user);

    List<User> findAll();

    User findUserById(Long id);

    User findUserByEmail(String email);

    User saveUser(User user);

    void updateUser(Long id);

    void deleteUser(Long id);

    List<Task> findAllUsersByTask(Task task);
}
