package com.habeeb.schoolmanagementapplication.controller;


import com.habeeb.schoolmanagementapplication.entity.Student;
import com.habeeb.schoolmanagementapplication.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/student")
public class StudentController {

    StudentService studentService;

    @PostMapping("/level/{levelId}")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student, @PathVariable Long levelId){
        return new ResponseEntity<>(studentService.saveStudent(student, levelId), HttpStatus.CREATED);
    }

    @PutMapping("/student/{studentId}/level/{levelId}")
    public ResponseEntity<Student> updateStudentsLevel(@PathVariable Long studentId, @PathVariable Long levelId){
        return new ResponseEntity<>(studentService.updateStudentsLevel(studentId,levelId), HttpStatus.CREATED);
    }


    @GetMapping("/level/{levelId}")
    public ResponseEntity<List<Student>> getStudentsOfLevel(@PathVariable Long levelId){
        return new ResponseEntity<>(studentService.getStudentsOfLevel(levelId), HttpStatus.CREATED);
    }


    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Student>> getStudentsOfCourse(@PathVariable Long courseId){
        return new ResponseEntity<>(studentService.getStudentsOfCourse(courseId),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/student/{studentId}/level/{levelId}")
    public ResponseEntity<HttpStatus> removeStudent(@PathVariable Long studentId,@PathVariable Long levelId){
        studentService.deleteStudent(studentId,levelId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}