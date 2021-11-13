package com.example.proyectoopensource.Exceptions;

public class UnidadesMedidasNotFoundException extends RuntimeException{
    public UnidadesMedidasNotFoundException (Long id){
        super("The item you are looking for is not stored in the database");
    }
}
