package ru.babich.appcontroloftasks.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.babich.appcontroloftasks.progress.Status;

import java.util.List;

@NamedEntityGraphs({
        @NamedEntityGraph(name = "task-user-graph",
                attributeNodes = {@NamedAttributeNode("user")}),
        @NamedEntityGraph(name = "task-comment-graph",
                attributeNodes = {@NamedAttributeNode("commentList")})
})
@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "priority", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Column(name = "executor", nullable = false)
    private boolean isExecutor;

    @Column(name = "author", nullable = false)
    private String author;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REMOVE})
    private User user;

    @OneToMany(targetEntity = Comment.class, mappedBy = "task")
    private List<Comment> commentList;
}
