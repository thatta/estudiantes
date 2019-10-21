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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author USER
 */
@Table
@Entity
@NamedQueries({
    @NamedQuery(name = "ex", query = "SELECT e FROM Estudiante e INNER JOIN e.listaClase c ON c.listaEstudiante.id <> e.id WHERE c.id = :id_clase"),
    @NamedQuery(name = "consultar", query = "SELECT e FROM Estudiante e JOIN e.listaClase c WHERE c.id = :id_clase")
})
public class Estudiante implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    
    private int id;
    
    @Column
    private String nombre;
    
    @Column
    private String cedula;
    
    @JoinTable(name = "estudiante_clase", 
            joinColumns = @JoinColumn(name = "id_estudiante", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_clase", nullable = false)
            )
    
    
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Clase> listaClase;

    public Estudiante() {
    }

    public Estudiante(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public List<Clase> getListaClase() {
        return listaClase;
    }

    public void setListaClase(List<Clase> listaClase) {
        this.listaClase = listaClase;
    }
    
    
}
