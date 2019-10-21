/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.entity.Estudiante;
import com.mycompany.entity.Info;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author USER
 */
@Local
public interface EstudianteFacadeLocal {

    void create(Estudiante estudiante);

    void edit(Estudiante estudiante);

    void remove(Estudiante estudiante);

    Estudiante find(Object id);

    List<Estudiante> findAll();

    List<Estudiante> findRange(int[] range);

    int count();
    
    //public List<Estudiante>buscarEstudiante(int id_clase);
    
    
    public List<Estudiante> filtro(int id_clase);
   
    public List<Estudiante> listarEstudiantesSi(int id_clase);
}
