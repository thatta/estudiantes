/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author USER
 */
@Entity
@Table(name="clases")
public class Clase implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="duracion")
    private String duracion;
    
    
     
    @ManyToMany(mappedBy = "listaClase")
    private List<Estudiante> listaEstudiante;

    public Clase() {
    }

    public Clase(String nombre, String duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public List<Estudiante> getListaEstudiante() {
        return listaEstudiante;
    }

    public void setListaEstudiante(List<Estudiante> listaEstudiante) {
        this.listaEstudiante = listaEstudiante;
    }

   
     
     
}
