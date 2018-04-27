/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkear.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author pc
 */
@Entity
@Table(name="TIPO_USUARIO" )
public class TipoUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_TIPO_USUARIO")
    @GeneratedValue( strategy=GenerationType.SEQUENCE, generator="TIPO_USUARIO_SEQUENCE" )
     @SequenceGenerator(name="TIPO_USUARIO_SEQUENCE", sequenceName = "TIPO_USUARIO_SEQUENCE")
    private Long idTipoUsuario;
    @Column(name = "DETALLE")
    private String detalle;
    @Column(name = "ESTADO")
    private char estado = '1';
    
    @OneToMany(mappedBy = "tipoUsuario" , fetch=FetchType.LAZY)
    private List<Usuario> usuarios;

    public TipoUsuario() {
    }

    public TipoUsuario(String detalle, char estado) {
        this.detalle = detalle;
        this.estado = estado;
    }

    public Long getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Long idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

  

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.idTipoUsuario);
        return hash;
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
        final TipoUsuario other = (TipoUsuario) obj;
        if (!Objects.equals(this.idTipoUsuario, other.idTipoUsuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoUsuario{" + "idTipoUsuario=" + idTipoUsuario + ", detalle=" + detalle + ", estado=" + estado + ", usuarios=" + usuarios + '}';
    }

    
    
    
}
