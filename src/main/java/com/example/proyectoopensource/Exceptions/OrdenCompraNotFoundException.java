package com.example.proyectoopensource.Exceptions;

public class OrdenCompraNotFoundException extends RuntimeException{
    public OrdenCompraNotFoundException(Long id){
        super("The item you are looking for is not stored in the database");
    }
}
