package com.habeeb.schoolmanagementapplication.repository;

import com.habeeb.schoolmanagementapplication.entity.Teacher;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeacherRepo extends CrudRepository<Teacher, Long> {
    List<Teacher> findAllByCourseId(Long courseId);
    List<Teacher> findAllByLevelId(Long teacherId);

    @Transactional
    void deleteByCourseIdAndLevelId(Long courseId, Long levelId);
}