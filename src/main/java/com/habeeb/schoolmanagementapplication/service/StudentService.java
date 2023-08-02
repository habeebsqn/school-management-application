package com.habeeb.schoolmanagementapplication.service;


import com.habeeb.schoolmanagementapplication.entity.Level;
import com.habeeb.schoolmanagementapplication.entity.Student;
import com.habeeb.schoolmanagementapplication.execption.EntityNotFoundException;
import com.habeeb.schoolmanagementapplication.repository.LevelRepo;
import com.habeeb.schoolmanagementapplication.repository.StudentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

    StudentRepo studentRepo;
    LevelRepo levelRepo;

    public Student getStudent(Long studentId){
        Optional<Student> student=studentRepo.findById(studentId);
        if(student.isPresent()){
            return student.get();
        }else throw new EntityNotFoundException(studentId,Student.class);
    }

    public List<Student> getStudentsOfLevel(Long levelId){
        return studentRepo.findAllByLevelId(levelId);
    }

    public List<Student> getStudentsOfCourse(Long courseId){
        return studentRepo.findAllByCoursesId(courseId);
    }


    public Student saveStudent(Student student, Long levelId){
        Optional<Level> level=levelRepo.findById(levelId);
        if(level.isPresent()){
            Level unwrapped=level.get();
            student.setLevel(unwrapped);
        }else throw new EntityNotFoundException(levelId,Level.class);
        return studentRepo.save(student);
    }

    public Student updateStudentsLevel(Long studentId,Long levelId){
        Student student=getStudent(studentId);
        Optional<Level> level=levelRepo.findById(levelId);
        if(level.isPresent()){
            Level unwrappedLevel=level.get();
            student.setLevel(unwrappedLevel);
        }else throw new EntityNotFoundException(levelId,Level.class);
        return studentRepo.save(student);
    }

    public void deleteStudent(Long studentId, Long levelId){
        studentRepo.deleteByIdAndLevelId(studentId,levelId);
    }


}