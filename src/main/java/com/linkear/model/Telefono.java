/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkear.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author pc
 */
@Entity
@Table( name = "Telefono" )
public class Telefono implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @Column( name= "ID_TELEFONO" )
    @GeneratedValue( strategy=GenerationType.SEQUENCE, generator="TELEFONO_SEQUENCE" )
    @SequenceGenerator( name="TELEFONO_SEQUENCE", sequenceName = "TELEFONO_SEQUENCE" )
    private Long idTelefono;
    
    
    @ManyToOne
    @JoinColumn( name = "ID_PERSONA" )
    private Persona persona;
    @Column(name="NUMERO")
    private String numero;
    
}
