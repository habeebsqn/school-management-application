package com.habeeb.schoolmanagementapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "level",uniqueConstraints = {@UniqueConstraint(columnNames = {"school", "name"})})
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name  ="id")
    private Long id;
    @Column(name = "school",nullable = false)
    private String school;
    @Column(name = "name", nullable = false)
    private String name;


    @JsonIgnore
    @OneToMany(mappedBy = "level",cascade = CascadeType.ALL)
    private List<Student> students;

    @JsonIgnore
    @OneToMany(mappedBy = "level",cascade = CascadeType.ALL)
    private List<Teacher> teachers;

    @JsonIgnore
    @OneToMany(mappedBy = "level",cascade = CascadeType.ALL)
    private List<Course> course;
}