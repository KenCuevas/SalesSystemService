package com.example.proyectoopensource.Exceptions;

public class DepartamentosNotFoundException extends RuntimeException{
    public DepartamentosNotFoundException(Long id){
        super("The item you are looking for is not stored in the database");
    }
}
