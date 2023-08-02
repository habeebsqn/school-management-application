package com.habeeb.schoolmanagementapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "name", nullable = false)
    private String name;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "course_Id", referencedColumnName = "id", unique = true)
    private Course course;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "level_Id", referencedColumnName = "id")
    private Level level;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "teacher_student",
            joinColumns = @JoinColumn(name = "teacher_Id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_Id",referencedColumnName = "id")

    )
    private List<Student> students;
}