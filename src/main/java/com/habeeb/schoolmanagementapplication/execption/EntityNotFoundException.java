package com.habeeb.schoolmanagementapplication.execption;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Long id, Class<?> entity){
        super("the " +entity.getSimpleName().toLowerCase()+ " with id "+ id +" does not exist in our record");
    }
}
