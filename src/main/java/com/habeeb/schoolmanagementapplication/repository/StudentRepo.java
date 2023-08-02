package com.habeeb.schoolmanagementapplication.repository;

import com.habeeb.schoolmanagementapplication.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface StudentRepo extends CrudRepository<Student,Long> {

    List<Student> findAllByLevelId(Long levelId);
    List<Student> findAllByCoursesId(Long courseId);

    @Transactional
    void deleteByIdAndLevelId(Long studentId, Long levelId);
}