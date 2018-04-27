/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkear.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;



import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;


import javax.persistence.Table;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;



/**
 *
 * @author pc
 */
@Entity
@Table(name = "PERSONA")
@SequenceGenerator(name = "PERSONA_SEQUENCE", sequenceName = "\"SEDUG-MAIN\".PERSONA_SEQUENCE" )

public class Persona implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @Column( name = "ID_PERSONA" )
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSONA_SEQUENCE")
    private Long idPersona;
    @Column(name = "CEDULA")
    private String cedula;
    @Column(name = "NOMBRES")
    private String nombres;
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Column(name = "SEXO")
    private String sexo;

    @OneToOne(mappedBy = "persona", fetch = FetchType.LAZY,cascade = CascadeType.ALL,  optional = false)
  
    private Usuario usuario;

    public Persona() {

    }

    public Persona(Long idPersona, String cedula, String nombres, String apellidos, String sexo, Usuario usuario) {
        this.idPersona = idPersona;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.usuario = usuario;
    }

 

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }   

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.idPersona);
        return hash;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
     @PrePersist
    public void personaPrePersist() {
         System.out.println("hohoiqwheoihqeoihqweoihewqoihewqouqwhiuchiue   PERSONA xxxgiydguyegudygueygduygeuygduyeguydgeuygduyeguyqguygwuygqdwuygduyqgeduyeguyeguyed");
        System.out.println("hohoiqwheoihqeoihqweoihewqoihewqouqwhiuchiuegiydguyegudygueygduygeuygduyeguydgeuygduyeguyqguygwuygqdwuygduyqgeduyeguyeguyed");
        System.out.println("hohoiqwheoihqeoihqweoihewqoihewqouqwhiuchiuegiydguyegudygueygduygeuygduyeguydgeuygduyeguyqguygwuygqdwuygduyqgeduyeguyeguyed");
        //System.out.println(this.nombres);
		
    }
    
    @PostPersist
    public void personaPostPersist() {
         System.out.println("hohoiqwheoihqeoihqweoihewqoihewqouqwhiuchiue  xx --ID PERSONA xxxgiydguyegudygueygduygeuygduyeguydgeuygduyeguyqguygwuygqdwuygduyqgeduyeguyeguyed");
        System.out.println("hohoiqwheoihqeoihqweoihewqoihewqouqwhiuchiuegiydguyegudygueygduygeuygduyeguydgeuygduyeguyqguygwuygqdwuygduyqgeduyeguyeguyed");
        System.out.println("hohoiqwheoihqeoihqweoihewqoihewqouqwhiuchiuegiydguyegudygueygduygeuygduyeguydgeuygduyeguyqguygwuygqdwuygduyqgeduyeguyeguyed");
        System.out.println(this.idPersona);
        if (this.idPersona!= null)
            this.usuario.setPersona(this);
        
		
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.idPersona, other.idPersona)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", cedula=" + cedula + ", nombres=" + nombres + ", apellidos=" + apellidos + ", sexo=" + sexo + '}';
    }
    
}
