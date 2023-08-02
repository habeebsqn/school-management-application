package com.habeeb.schoolmanagementapplication.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course",uniqueConstraints = {@UniqueConstraint(columnNames = {"course", "level_Id"})})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank(message = "course can not be black")
    @Column(name = "course", nullable = false)
    private String course;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "level_Id", referencedColumnName = "id")
    private Level level;

    @JsonIgnore
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Grade> grades;

    @JsonIgnore
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Teacher> teachers;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "course_Id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_Id",referencedColumnName = "id")

    )
    private List<Student> students;
}