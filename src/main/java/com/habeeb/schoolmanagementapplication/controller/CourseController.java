package com.habeeb.schoolmanagementapplication.controller;

import com.habeeb.schoolmanagementapplication.entity.Course;
import com.habeeb.schoolmanagementapplication.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {

    CourseService courseService;

    @PostMapping("/level/{levelId}")
    public ResponseEntity<Course> addCourse(@PathVariable Long levelId, @RequestBody Course course){
        return new ResponseEntity<>(courseService.addCourse(levelId,course), HttpStatus.CREATED);
    }

    @PutMapping("/course/{courseId}/student/{studentId}")
    public ResponseEntity<Course> enrollStudentToCourse(@PathVariable Long courseId,@PathVariable Long studentId ){
        return new ResponseEntity<>(courseService.enrollStudentToCourse(courseId,studentId),HttpStatus.ACCEPTED);
    }

    @PutMapping("/disenroll/course/{courseId}/student/{studentId}")
    public ResponseEntity<HttpStatus> disenrollStudentFromCourse(@PathVariable Long courseId, @PathVariable Long studentId){
        courseService.disenrollStudentFromCourse(courseId,studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Course>> getCoursesofStudent(@PathVariable Long studentId){
        return new ResponseEntity<>(courseService.getCoursesofStudent(studentId),HttpStatus.FOUND);
    }

    @GetMapping("/level/{levelId}")
    public ResponseEntity<List<Course>> getCoursesOfLevel(@PathVariable Long levelId){
        return new ResponseEntity<>(courseService.getCoursesofLevel(levelId),HttpStatus.FOUND);
    }



    @DeleteMapping("/delete/course/{courseId}/level/{levelId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long levelId, @PathVariable Long courseId){
        courseService.deleteCourse(levelId,courseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}