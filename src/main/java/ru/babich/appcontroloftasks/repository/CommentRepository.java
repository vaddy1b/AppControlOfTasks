package ru.babich.appcontroloftasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.babich.appcontroloftasks.entity.Comment;
import ru.babich.appcontroloftasks.entity.Task;
import ru.babich.appcontroloftasks.entity.User;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    Comment findCommentById(Long id);

    Comment findCommentByTask(Task Task);

    Comment saveComment(Comment comment);

    void updateComment(Long id);

    void deleteComment(Long id);
}
