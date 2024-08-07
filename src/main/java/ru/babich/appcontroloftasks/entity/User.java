package ru.babich.appcontroloftasks.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

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


    //TODO:??
    @OneToMany(mappedBy = )
    private List<Comment> commentList;
    //TODO:??
    @OneToMany(mappedBy = "task")
    private Set<Task> taskSet;

}
