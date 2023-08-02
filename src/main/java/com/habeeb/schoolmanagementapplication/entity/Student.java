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
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", nullable = false,unique = true)
    private String name;
    @Column(name = "age", nullable = false)
    private String age;
    @Column(name = "sex", nullable = false)
    private String sex;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "level_Id", referencedColumnName = "id")
    private Level level;

    @JsonIgnore
    @ManyToMany(mappedBy = "students")
    private List<Teacher> teachers;

    @JsonIgnore
    @ManyToMany(mappedBy = "students",cascade = CascadeType.ALL)
    private List<Course> courses;

    @JsonIgnore
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Grade> grades;
}