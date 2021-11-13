package com.example.proyectoopensource.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name = "articles")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Articles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_article")
    private Long id;
    private String description;
    private String brand;

    //Referencia a la relacion de base de datos
    @JsonBackReference
    @OneToMany(targetEntity = UnidadesMedidas.class)
    private List UnidadesList;

    @Column(name = "disponiblidad_articulo")
    private int disponibilidadArticulo;
    private boolean estado;

    public List getUnidadesList() {
        return UnidadesList;
    }

    public void setUnidadesList(List unidadesList) {
        UnidadesList = unidadesList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getDisponibilidadArticulo() {
        return disponibilidadArticulo;
    }

    public void setDisponibilidadArticulo(int disponibilidadArticulo) {
        this.disponibilidadArticulo = disponibilidadArticulo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
