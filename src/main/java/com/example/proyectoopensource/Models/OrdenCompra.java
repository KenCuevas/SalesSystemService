package com.example.proyectoopensource.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;


@Entity(name = "numero_orden")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrdenCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "numero_orden")
    private int numeroOrden;
    private LocalDate fecha;
    private boolean estado;
    private BigInteger costo_unitario;


    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_article", referencedColumnName = "id_article")
    private Articles articles;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "unidades_medida_id", referencedColumnName = "unidades_medida_id")
    private UnidadesMedidas unidadesMedidas;

    public Articles getArticles() {
        return articles;
    }

    public void setArticles(Articles articles) {
        this.articles = articles;
    }

    public UnidadesMedidas getUnidadesMedidas() {
        return unidadesMedidas;
    }

    public void setUnidadesMedidas(UnidadesMedidas unidadesMedidas) {
        this.unidadesMedidas = unidadesMedidas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public BigInteger getCosto_unitario() {
        return costo_unitario;
    }

    public void setCosto_unitario(BigInteger costo_unitario) {
        this.costo_unitario = costo_unitario;
    }
}
