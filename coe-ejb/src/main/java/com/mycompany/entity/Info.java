/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author USER
 */

@Entity
@Table(name = "info")
@NamedQueries({
    @NamedQuery(name = "consulta", query = "SELECT e.id, c.nombre, e.nombre, c.duracion, e.cedula FROM Estudiante e JOIN e.listaClase c  ")
})
public class Info implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String nombre_clase;
    
    @Column
    private String nombre_estudiante;
    
    @Column
    private String duracion;
    
    @Column
    private String cedula;

    public Info() {
    }

    public Info(int id, String nombre_clase, String nombre_estudiante, String duracion, String cedula) {
        this.id = id;
        this.nombre_clase = nombre_clase;
        this.nombre_estudiante = nombre_estudiante;
        this.duracion = duracion;
        this.cedula = cedula;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_clase() {
        return nombre_clase;
    }

    public void setNombre_clase(String nombre_clase) {
        this.nombre_clase = nombre_clase;
    }

    public String getNombre_estudiante() {
        return nombre_estudiante;
    }

    public void setNombre_estudiante(String nombre_estudiante) {
        this.nombre_estudiante = nombre_estudiante;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
}
