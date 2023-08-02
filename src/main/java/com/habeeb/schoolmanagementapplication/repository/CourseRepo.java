package com.habeeb.schoolmanagementapplication.repository;

import com.habeeb.schoolmanagementapplication.entity.Course;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CourseRepo extends CrudRepository<Course,Long> {

    List<Course> findAllByStudentsId(Long studentId);

    List<Course> findAllByLevelId(Long levelId);

    @Transactional
    void deleteByLevelIdAndId(Long levelId,Long courseId);
}