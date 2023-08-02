package com.habeeb.schoolmanagementapplication.service;


import com.habeeb.schoolmanagementapplication.entity.Level;
import com.habeeb.schoolmanagementapplication.entity.Course;
import com.habeeb.schoolmanagementapplication.entity.Teacher;
import com.habeeb.schoolmanagementapplication.execption.CourseNotFoundException;
import com.habeeb.schoolmanagementapplication.execption.EntityNotFoundException;
import com.habeeb.schoolmanagementapplication.repository.LevelRepo;
import com.habeeb.schoolmanagementapplication.repository.CourseRepo;
import com.habeeb.schoolmanagementapplication.repository.TeacherRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeacherService {

    TeacherRepo teacherRepo;
    CourseRepo courseRepo;
    LevelRepo levelRepo;


    public Teacher getTeacher(Long teacherId){
        Optional<Teacher> teacher=teacherRepo.findById(teacherId);
        if(teacher.isPresent()){
            return teacher.get();
        }else throw new EntityNotFoundException(teacherId,Teacher.class);
    }

    public List<Teacher> getCourseTeachers(Long courseId){
        return teacherRepo.findAllByCourseId(courseId);
    }

    public List<Teacher> getLevelTeachers(Long levelId){return teacherRepo.findAllByLevelId(levelId);}

    public Teacher saveTeacher(Teacher teacher,Long courseId,Long levelId){
        Optional<Course> course=courseRepo.findById(courseId);
        Optional<Level> level=levelRepo.findById(levelId);
        if(course.isPresent()&&level.isPresent()){
            Course unwrappedCourse= course.get();
            Level unwrappedLevel=level.get();
            teacher.setCourse(unwrappedCourse);
            teacher.setLevel(unwrappedLevel);
        }else throw new CourseNotFoundException(courseId,levelId);
        return teacherRepo.save(teacher);
    }

    public void assignTeacherToLevel(Long teacherId,Long courseId,Long levelId){
        Teacher selectedTeacher=getTeacher(teacherId);
        Optional<Level> level=levelRepo.findById(levelId);
        Optional<Course> course=courseRepo.findById(courseId);
        if(level.isPresent()){
            Level selectedLevel=level.get();
            selectedTeacher.setLevel(selectedLevel);
        }else throw new CourseNotFoundException(courseId,levelId);
        teacherRepo.save(selectedTeacher);
    }


}