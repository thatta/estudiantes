/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bean;

import com.mycompany.entity.Clase;
import com.mycompany.entity.Estudiante;
import com.mycompany.entity.Info;
import com.mycompany.interfaces.ClaseFacadeLocal;
import com.mycompany.interfaces.EstudianteFacadeLocal;
import com.mycompany.interfaces.InfoFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author USER
 */

@Named
@ViewScoped
public class index implements Serializable {
    
    private String nombre;
    private String cedula;
    private String duracion;
    
    private int estudianteSeleccionado;
    private int claseSeleccionada;
    
    
    @EJB
    private InfoFacadeLocal infoFacade;
    
    @EJB
    private ClaseFacadeLocal claseFacade;
    @EJB
    private EstudianteFacadeLocal estudianteFacade;
    
    private int Clase;
    
    
    Estudiante estudiante;
    private  List <Estudiante> lista;
   
    Clase clases;
    private  List <Clase> listaC;
    
    private List<Info>listaInfo;
    
    private List<Estudiante>listaEstudianteSi;
    
    private List<Info>listaTotal;
    

    public Clase getClases() {
        return clases;
    }

    public void setClases(Clase clases) {
        this.clases = clases;
    }
    
    
    public index() {
        estudiante = new Estudiante();
        lista = new ArrayList<Estudiante>();
        
        clases=new Clase();
        listaC= new ArrayList<Clase>();
    }

    public index(String nombre, String cedula, String nombreC, String duracion) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.duracion = duracion;
    }

    public int getClase() {
        return Clase;
    }

    public void setClase(int Clase) {
        this.Clase = Clase;
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



    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getEstudianteSeleccionado() {
        return estudianteSeleccionado;
    }

    public void setEstudianteSeleccionado(int estudianteSeleccionado) {
        this.estudianteSeleccionado = estudianteSeleccionado;
    }

    public int getClaseSeleccionada() {
        return claseSeleccionada;
    }

    public void setClaseSeleccionada(int claseSeleccionada) {
        this.claseSeleccionada = claseSeleccionada;
    }
    
    
    
    public EstudianteFacadeLocal getEstudianteFacade() {
        return estudianteFacade;
    }

    public void setEstudianteFacade(EstudianteFacadeLocal estudianteFacade) {
        this.estudianteFacade = estudianteFacade;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public  List<Estudiante> getLista() {
        return lista;
    }

    public  void setLista(List<Estudiante> lista) {
        this.lista = lista;
    }

    public List<Clase> getListaC() {
        return listaC;
    }

    public void setListaC(List<Clase> listaC) {
        this.listaC = listaC;
    }

    public InfoFacadeLocal getInfoFacade() {
        return infoFacade;
    }

    public void setInfoFacade(InfoFacadeLocal infoFacade) {
        this.infoFacade = infoFacade;
    }

    public List<Info> getListaInfo() {
        return listaInfo;
    }

    public void setListaInfo(List<Info> listaInfo) {
        this.listaInfo = listaInfo;
    }

    public List<Estudiante> getListaEstudianteSi() {
        return listaEstudianteSi;
    }

    public void setListaEstudianteSi(List<Estudiante> listaEstudianteSi) {
        this.listaEstudianteSi = listaEstudianteSi;
    }
    
    
    
    
    
    
    public void crearEstudiante(){
        Estudiante user = new Estudiante();
        estudiante.setNombre(nombre);
        estudiante.setCedula(cedula);
        
        
        user.setNombre(estudiante.getNombre());
        user.setCedula(estudiante.getCedula());
        estudianteFacade.create(user);
        
        listaEstudianteSi= estudianteFacade.findAll();
        for (Estudiante lista1 : listaEstudianteSi) {
            System.out.println("entro"+lista1.getNombre());
            
        }
        FacesMessage msg = new FacesMessage("estudiante agregado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     public void crearClase(){
        Clase clase = new Clase();
        clases.setNombre(nombre);
        clases.setDuracion(duracion);
        
        
        clase.setNombre(clases.getNombre());
        clase.setDuracion(clases.getDuracion());
        claseFacade.create(clase);
    }
     
     @PostConstruct
     public void init(){
        listaC = claseFacade.findAll();
        lista= estudianteFacade.findAll();
     }
     
     public void buscarEstudiante(ValueChangeEvent event){
         listaTotal = new ArrayList<>();
         System.out.println("Entra"+event.getNewValue());
        lista = estudianteFacade.filtro((int) event.getNewValue());
         
         listaEstudianteSi= estudianteFacade.listarEstudiantesSi((int)event.getNewValue());
         for (Estudiante le : listaEstudianteSi) {
             System.out.println("Est: "+le.getNombre());
             
         }
         listaInfo = infoFacade.consulta(claseSeleccionada);
         Iterator itr = listaInfo.iterator();
        while (itr.hasNext()) {
            Object[] obj = (Object[]) itr.next();
            Info temp = new Info(Integer.parseInt(String.valueOf(obj[0])),String.valueOf(obj[1]),String.valueOf(obj[2]),
            String.valueOf(obj[3]),String.valueOf(obj[4]));
            listaTotal.add(temp);
            
        }
         for (Info lista1 : listaTotal) {
             System.out.println("Vista:"+ lista1.getNombre_clase()+"\n"+lista1.getNombre_estudiante());
         }
        
     }
     
     
     public void relacion(){
         Estudiante entEst = estudianteFacade.find(estudianteSeleccionado);
         Clase entClase = claseFacade.find(claseSeleccionada);
         System.out.println("IdS: "+estudianteSeleccionado);
         System.out.println("Est: "+entEst.getNombre());
         System.out.println("IdEnt: "+entEst.getId());
         entEst.getListaClase().add(entClase);
         entClase.getListaEstudiante().add(entEst);
         estudianteFacade.edit(entEst);
         
         
     }
     public void estudiantesClase(){
         listaEstudianteSi= estudianteFacade.listarEstudiantesSi(claseSeleccionada);
     }
     
}
