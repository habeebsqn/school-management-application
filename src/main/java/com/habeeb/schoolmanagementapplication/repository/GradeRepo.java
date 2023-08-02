package com.habeeb.schoolmanagementapplication.repository;

import com.habeeb.schoolmanagementapplication.entity.Grade;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface GradeRepo extends CrudRepository<Grade,Long> {

    Optional<Grade> findByStudentIdAndCourseId(Long studentId, Long courseId);

    @Transactional
    void deleteByStudentIdAndCourseId(Long studentId,Long courseId);
}