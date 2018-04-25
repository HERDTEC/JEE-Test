/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkear.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author pc
 */
@Entity
@Table( name = "NOTA" )
public class Nota implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOTA_SEQUENCE")
    @SequenceGenerator(name="NOTA_SEQUENCE", sequenceName = "NOTA_SEQUENCE")
    @Column(name = "ID_NOTA")
    private Long idNota;
    @ManyToOne
    @JoinColumn(name = "ID_PERSONA", nullable = false)
    private Persona persona;
    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA", nullable = false)
    private Categoria categoria;
    @Column(name = "NUMERO")
    private String numero;
    @Column(name = "ENCABEZADO")
    private String encabezado;
    @Column(name = "CUERPO")
    private String cuerpo;
    
    @Temporal( TemporalType.TIMESTAMP )
    @Column(name = "FECHA")
    private Date fecha;
    @Column(name = "COMENTARIO_ADMIN")
    private String comentarioAdmin;
    @Column(name = "VALORACION")
    private String valoracion;

    public Nota() {
    }

    public Nota(Persona persona, Categoria categoria, String numero, String encabezado, String cuerpo, Date fecha, String comentarioAdmin, String valoracion) {
        this.persona = persona;
        this.categoria = categoria;
        this.numero = numero;
        this.encabezado = encabezado;
        this.cuerpo = cuerpo;
        this.fecha = fecha;
        this.comentarioAdmin = comentarioAdmin;
        this.valoracion = valoracion;
    }

    public Long getIdNota() {
        return idNota;
    }

    public void setIdNota(Long idNota) {
        this.idNota = idNota;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentarioAdmin() {
        return comentarioAdmin;
    }

    public void setComentarioAdmin(String comentarioAdmin) {
        this.comentarioAdmin = comentarioAdmin;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }
    
    
    
}
