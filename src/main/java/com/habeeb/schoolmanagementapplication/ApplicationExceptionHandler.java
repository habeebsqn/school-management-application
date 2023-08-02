package com.habeeb.schoolmanagementapplication;

import com.habeeb.schoolmanagementapplication.execption.CourseNotFoundException;
import com.habeeb.schoolmanagementapplication.execption.EntityNotFoundException;
import com.habeeb.schoolmanagementapplication.execption.ErrorResponse;
import com.habeeb.schoolmanagementapplication.execption.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class, StudentNotFoundException.class, CourseNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(RuntimeException ex){
        ErrorResponse errorResponse=new ErrorResponse(Arrays.asList(ex.getMessage()));
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

}