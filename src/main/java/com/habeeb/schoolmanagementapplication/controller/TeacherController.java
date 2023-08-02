package com.habeeb.schoolmanagementapplication.controller;


import com.habeeb.schoolmanagementapplication.entity.Teacher;
import com.habeeb.schoolmanagementapplication.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/teacher")
public class TeacherController {

   TeacherService teacherService;

    @PostMapping("/course/{courseId}/level/{levelId}")
    public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher,@PathVariable Long courseId,@PathVariable Long levelId){
        return new ResponseEntity<>(teacherService.saveTeacher(teacher,courseId,levelId), HttpStatus.OK);
    }

    @PutMapping("/teacher/{teacherId}/course/{courseId}/level/{levelId}")
    public ResponseEntity<HttpStatus> assignTeacherToLevel(@PathVariable Long teacherId,@PathVariable Long courseId, @PathVariable Long levelId){
        teacherService.assignTeacherToLevel(teacherId,courseId,levelId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Teacher>> getCourseTeachers(@PathVariable Long courseId) {
        return new ResponseEntity<>(teacherService.getCourseTeachers(courseId), HttpStatus.OK);
    }

    @GetMapping("/level/{levelId}")
    public ResponseEntity<List<Teacher>> getLevelTeachers(@PathVariable Long levelId) {
        return new ResponseEntity<>(teacherService.getLevelTeachers(levelId), HttpStatus.OK);
    }

    @DeleteMapping("/course/{courseId}/level/{levelId}")
    public ResponseEntity<HttpStatus> removeTeacher(@PathVariable Long courseId, @PathVariable Long levelId){
        teacherService.removeTeacher(courseId,levelId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}