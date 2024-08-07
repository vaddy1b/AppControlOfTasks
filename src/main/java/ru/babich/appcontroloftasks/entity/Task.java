package ru.babich.appcontroloftasks.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.babich.appcontroloftasks.progress.Status;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number",nullable = false)
    private Long number;

    @Column(name="priority",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToOne(cascade ={ CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REMOVE})
    private User user;

    //TODO:??
    @OneToMany(targetEntity = Comment.class,mappedBy = "task")
    private List<Comment> commentList;
}
