package com.example.proyectoopensource.Exceptions;

public class ProveedoresNotFoundException extends RuntimeException{
    public ProveedoresNotFoundException (Long id){
        super("The item you are looking for is not stored in the database");
    }
}
