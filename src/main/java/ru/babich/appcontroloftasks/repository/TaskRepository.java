package ru.babich.appcontroloftasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.babich.appcontroloftasks.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
