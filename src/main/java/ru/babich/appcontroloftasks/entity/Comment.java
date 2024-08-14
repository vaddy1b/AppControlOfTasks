package ru.babich.appcontroloftasks.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@NamedEntityGraphs({
        @NamedEntityGraph(name = "comment-user-graph",
                attributeNodes = {@NamedAttributeNode("user")}),
        @NamedEntityGraph(name = "comment-task-graph",
                attributeNodes = {@NamedAttributeNode("task")})
})
@Getter
@Setter
@Entity
@Table(name="comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "author", nullable = false)
    private String author;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @ManyToOne
    private Task task;
}
