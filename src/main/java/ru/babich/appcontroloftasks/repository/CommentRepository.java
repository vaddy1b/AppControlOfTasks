package ru.babich.appcontroloftasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.babich.appcontroloftasks.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
