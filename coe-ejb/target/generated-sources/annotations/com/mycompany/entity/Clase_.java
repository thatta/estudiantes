package com.mycompany.entity;

import com.mycompany.entity.Estudiante;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-16T16:06:50")
@StaticMetamodel(Clase.class)
public class Clase_ { 

    public static volatile SingularAttribute<Clase, String> duracion;
    public static volatile ListAttribute<Clase, Estudiante> listaEstudiante;
    public static volatile SingularAttribute<Clase, Integer> id;
    public static volatile SingularAttribute<Clase, String> nombre;

}