package com.example.proyectoopensource.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "unidades_medidas")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UnidadesMedidas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "unidades_medida_id")
    private Long id;
    private String descripcion;
    private boolean estado;

    @JsonBackReference
    //Mapeo a base de datos
    @ManyToMany(mappedBy = "unidadesMedidas")
    private List<Articles>articles;

    @JsonBackReference
    @OneToOne(mappedBy = "unidadesMedidas")
    private OrdenCompra ordenCompra;

    public UnidadesMedidas() {
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
