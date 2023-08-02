package com.habeeb.schoolmanagementapplication.execption;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(Long studentId,Long courseId){
        super("the student with an id " + studentId + " is not enrolled to course with id " + courseId + " in our record ");
    }
}