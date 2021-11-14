package com.example.proyectoopensource.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    //Se crea la relacion con la tabla Unidades medidas
//    @JsonBackReference
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "unidadesMedidas")
//    private List<Articles>articles;

    //Se crea la relacion con la tabla Orden de compras
//    @JsonBackReference
//    @OneToOne(mappedBy = "unidadesMedidas")
//    private OrdenCompra ordenCompra;

    public UnidadesMedidas() {
    }

//    public OrdenCompra getOrdenCompra() {
//        return ordenCompra;
//    }
//
//    public void setOrdenCompra(OrdenCompra ordenCompra) {
//        this.ordenCompra = ordenCompra;
//    }

//    public List<Articles> getArticles() {
//        return articles;
//    }
//
//    public void setArticles(List<Articles> articles) {
//        this.articles = articles;
//    }

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
