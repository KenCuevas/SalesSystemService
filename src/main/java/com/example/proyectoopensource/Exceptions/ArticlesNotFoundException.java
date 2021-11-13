package com.example.proyectoopensource.Exceptions;

public class ArticlesNotFoundException extends RuntimeException{
    public ArticlesNotFoundException(Long id){
        super("The item you are looking for is not stored in the database");
    }
}
