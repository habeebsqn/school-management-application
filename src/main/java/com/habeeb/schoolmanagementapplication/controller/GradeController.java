package com.habeeb.schoolmanagementapplication.controller;


import com.habeeb.schoolmanagementapplication.entity.Grade;
import com.habeeb.schoolmanagementapplication.service.GradeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/grade")
public class GradeController {

    GradeService gradeService;

    @PostMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<Grade> saveGrade(@RequestBody Grade grade,@PathVariable Long courseId,@PathVariable Long studentId){
        return new ResponseEntity<>(gradeService.saveGrade(grade,studentId,courseId),HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/student/{studentId}/course/{courseId}")
    public ResponseEntity<Grade> updateGrade(@RequestBody Grade grade,@PathVariable Long courseId,@PathVariable Long studentId){
        return new ResponseEntity<>(gradeService.updateGrade(grade,studentId,courseId),HttpStatus.ACCEPTED);
    }


    @GetMapping("/get/student/{studentId}/course/{courseId}")
    public ResponseEntity<Grade> getGrade(@PathVariable Long courseId,@PathVariable Long studentId){
        return new ResponseEntity<>(gradeService.getGrade(studentId,courseId),HttpStatus.OK);
    }

    @DeleteMapping("/delete/student/{studentId}/course/{courseId}")
    public ResponseEntity<HttpStatus> deleteGrade(@PathVariable Long courseId,@PathVariable Long studentId){
        gradeService.deleteGrade(studentId,courseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}