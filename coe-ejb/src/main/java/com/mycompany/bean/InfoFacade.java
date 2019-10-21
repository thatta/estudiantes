/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bean;

import com.mycompany.interfaces.InfoFacadeLocal;
import com.mycompany.entity.Info;
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
public class InfoFacade extends AbstractFacade<Info> implements InfoFacadeLocal {
    @PersistenceContext(unitName = "persistencia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InfoFacade() {
        super(Info.class);
    }

    @Override
    public List<Info> consulta(int id_clase) {
        TypedQuery<Info>consulta1;
        consulta1=em.createNamedQuery("consulta", Info.class);
        //consulta1.setParameter("id_clase", id_clase);
        List<Info> lista= consulta1.getResultList();
        return lista;
    }

    
     

   
}
