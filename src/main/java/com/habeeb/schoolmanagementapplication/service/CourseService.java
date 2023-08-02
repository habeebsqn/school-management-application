package com.habeeb.schoolmanagementapplication.service;

import com.habeeb.schoolmanagementapplication.entity.Level;
import com.habeeb.schoolmanagementapplication.entity.Course;
import com.habeeb.schoolmanagementapplication.entity.Student;
import com.habeeb.schoolmanagementapplication.execption.EntityNotFoundException;
import com.habeeb.schoolmanagementapplication.repository.LevelRepo;
import com.habeeb.schoolmanagementapplication.repository.CourseRepo;
import com.habeeb.schoolmanagementapplication.repository.StudentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseService {

    CourseRepo courseRepo;
    LevelRepo levelRepo;
    StudentRepo studentRepo;


    public Course getCourse(Long courseId){
        Optional<Course> course=courseRepo.findById(courseId);
       if(course.isPresent()){
           return course.get();
       }else throw ( new EntityNotFoundException(courseId, Course.class));
       }


    public List<Course> getCoursesofStudent(Long studentId){
        return courseRepo.findAllByStudentsId(studentId);
    }

    public List<Course> getCoursesofLevel(Long levelId){
        return (List<Course>) courseRepo.findAllByLevelId(levelId);
    }

    public Course addCourse(long levelId, Course course){
        Optional<Level> level=levelRepo.findById(levelId);
        if(level.isPresent()){
           Level unwrapped= level.get();
           course.setLevel(unwrapped);
        }else throw new EntityNotFoundException(levelId,Level.class);
        return courseRepo.save(course);
    }
    public Course enrollStudentToCourse(Long courseId,Long studentId){
        Course course= getCourse(courseId);
        Optional<Student> student=studentRepo.findById(studentId);
        if(student.isPresent()){
            Student unwrappedStudent=student.get();
            course.getStudents().add(unwrappedStudent);
        }else throw new EntityNotFoundException(studentId,Student.class);
        return courseRepo.save(course);
    }

    public void deleteCourse(Long levelId, Long courseId){
        courseRepo.deleteByLevelIdAndId(levelId,courseId);
    }

    public void disenrollStudentFromCourse( Long courseId, Long studentId){
        Course selectedCourse= getCourse(courseId);
        Optional<Student> student=studentRepo.findById(studentId);
        if(student.isPresent()){
            Student unwrappedStudent=student.get();
            selectedCourse.getStudents().remove(unwrappedStudent);
        }else throw new EntityNotFoundException(studentId,Student.class);
         courseRepo.save(selectedCourse);
    }





//    static Course unwrapCourse(Optional<Course> entity, Long id) {
//        if (entity.isPresent()) {
//            return entity.get();
//
//        }else return null;
//    }


}