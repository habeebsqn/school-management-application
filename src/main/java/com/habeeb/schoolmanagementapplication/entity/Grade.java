package com.habeeb.schoolmanagementapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "grade", uniqueConstraints = {@UniqueConstraint(columnNames = {"student_Id", "course_Id"})})
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", nullable = false)
    private String grade;
    @Column(name = "remark", nullable = false)
    private String remark;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "student_Id", referencedColumnName = "id")
    private Student student;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "course_Id", referencedColumnName = "id")
    private Course course;

}