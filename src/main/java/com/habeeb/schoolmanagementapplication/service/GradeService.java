package com.habeeb.schoolmanagementapplication.service;


import com.habeeb.schoolmanagementapplication.entity.Course;
import com.habeeb.schoolmanagementapplication.entity.Grade;
import com.habeeb.schoolmanagementapplication.entity.Student;
import com.habeeb.schoolmanagementapplication.execption.StudentNotFoundException;
import com.habeeb.schoolmanagementapplication.repository.CourseRepo;
import com.habeeb.schoolmanagementapplication.repository.GradeRepo;
import com.habeeb.schoolmanagementapplication.repository.StudentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GradeService {

    GradeRepo gradeRepo;
    CourseRepo courseRepo;
    StudentRepo studentRepo;


    public Grade saveGrade(Grade grade,Long studentId, Long courseId){
        Optional<Course> course= courseRepo.findById(courseId);
        Optional<Student> student= studentRepo.findById(studentId);
        if(course.isPresent() && student.isPresent()){
            Course unwrappedCourse= course.get();
            Student unwrappedStudent=student.get();
            grade.setCourse(unwrappedCourse);
            grade.setStudent(unwrappedStudent);
        }else throw new StudentNotFoundException(studentId,courseId);
        return gradeRepo.save(grade);
    }

    public Grade updateGrade(Grade grade,Long studentId, Long courseId){
       Grade updatedGrade=getGrade(studentId,courseId);
       updatedGrade.setGrade(grade.getGrade());
       updatedGrade.setRemark(grade.getRemark());
       return gradeRepo.save(updatedGrade);

    }

    public Grade getGrade(Long studentId, Long courseId){
        Optional<Grade> grade= gradeRepo.findByStudentIdAndCourseId(studentId,courseId);
        if(grade.isPresent()){
            return   grade.get();
        }else throw new StudentNotFoundException(studentId,courseId);


    }

    public void deleteGrade(Long studentId, Long courseId){
        gradeRepo.deleteByStudentIdAndCourseId(studentId,courseId);
    }







}