package ru.babich.appcontroloftasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.babich.appcontroloftasks.entity.User;

@Repository
public interface UserRepositiry extends JpaRepository<User,Long> {
}
