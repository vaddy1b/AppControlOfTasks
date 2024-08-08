package ru.babich.appcontroloftasks.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;


@NamedEntityGraphs({
        @NamedEntityGraph(name = "user-tasks-comments-graph",
                attributeNodes = {@NamedAttributeNode("taskSet"),
                        @NamedAttributeNode("commentList")}),
        @NamedEntityGraph(name = "user-only-graph")
})

@Getter
@Setter
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "email",unique = true)
    private String email;

    @OneToMany
    private List<Comment> commentList;

    @OneToMany
    private Set<Task> taskSet;

}
