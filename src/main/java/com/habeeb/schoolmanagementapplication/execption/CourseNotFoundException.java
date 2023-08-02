package com.habeeb.schoolmanagementapplication.execption;


public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(Long courseId, Long levelId){
        super("the course of id " + courseId + " with a class id " + levelId +" doesn't exist in our record");
    }
}