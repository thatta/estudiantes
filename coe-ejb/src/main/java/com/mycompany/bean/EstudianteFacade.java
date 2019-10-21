/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bean;

import com.mycompany.interfaces.EstudianteFacadeLocal;
import com.mycompany.entity.Estudiante;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author USER
 */
@Stateless
public class EstudianteFacade extends AbstractFacade<Estudiante> implements EstudianteFacadeLocal {
    @PersistenceContext(unitName = "persistencia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudianteFacade() {
        super(Estudiante.class);
    }

    /*@Override
    public List<Estudiante> buscarEstudiante(int id_clase) {
       TypedQuery<Estudiante> consulta;
       consulta = em.createNamedQuery("ex", Estudiante.class);
       consulta.setParameter("id_clase", id_clase);
       return consulta.getResultList();
    }*/
    @Override
    public List<Estudiante> filtro(int id_clase) {
        List<Estudiante> listaCompleta = findAll();//traemos la lista de todos los estudiantes
        TypedQuery<Estudiante> consulta = em.createNamedQuery("consultar", Estudiante.class);//traemos la lista de los que si están en la materia
        consulta.setParameter("id_clase", id_clase);
        List<Estudiante> listaPorMaterias = consulta.getResultList();//acá es donde se llena la lista con esos estudiantes
        List<Estudiante> lisTemporal = new ArrayList();//inicializo una lista temporal
        if (listaCompleta.size() > listaPorMaterias.size()) {//pregunto si el tamaño de la lista completa es mayor a la de los estudiantes registrados
            for (Estudiante general : listaCompleta) {//inicio el recorrido de la lista completa
                if (!listaPorMaterias.contains(general)) {//pregunto si el estudiante no está
                    lisTemporal.add(general);//si no está lo agrego a la lista temporal
                }
            }
        } else {//si la lista completa es menor a la de los estudiantes registrados, hace lo mismo de arriba pero a la inversa // creo que a ese else nunca va a entrar
            for (Estudiante xMaterias : listaPorMaterias) {
                if (!listaCompleta.contains(xMaterias)) {
                    lisTemporal.add(xMaterias);
                }
            }
        }
        return lisTemporal;//retorno finalmente la lista temporal que es la de los estudiantes que no están en la materia
    }
    
    
    @Override
    public List<Estudiante> listarEstudiantesSi(int id_clase) {
       TypedQuery<Estudiante> consulta;
       consulta = em.createNamedQuery("consultar", Estudiante.class);
       consulta.setParameter("id_clase", id_clase);
       return consulta.getResultList();
    }
   
}
