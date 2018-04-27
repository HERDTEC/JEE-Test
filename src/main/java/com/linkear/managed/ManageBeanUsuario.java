/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkear.managed;

import com.linkear.beans.PersonaFacadeLocal;
import com.linkear.beans.TipoUsuarioFacadeLocal;
import com.linkear.beans.UsuarioFacadeLocal;
import com.linkear.model.Persona;
import com.linkear.model.TipoUsuario;
import com.linkear.model.Usuario;
import java.io.Serializable;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


/**
 *
 * @author pc
 */
@Named("MBUsuario")
@ViewScoped
public class ManageBeanUsuario implements Serializable{

    @EJB
    UsuarioFacadeLocal usuarioEJB;
    @EJB
    PersonaFacadeLocal personaEJB;
    @EJB
    TipoUsuarioFacadeLocal tipoUsuarioEJB;
    private List<TipoUsuario> tipoUsuarios;
    private Long idTipoUsuario;
    private TipoUsuario tipoUsuario;
    private Persona persona;
    private Usuario usuario;
   
    @PostConstruct
    public void init(){
        persona = new Persona();
        usuario = new Usuario();
        cargarTipoUsuario();
    }
    public void cargarTipoUsuario(){
        try{
            tipoUsuarios = tipoUsuarioEJB.findAll();
        }catch(Exception ex){
            //msg jsf
            System.out.println(ex.getMessage());
        }
    }
    public void registrar(){
        try{
            tipoUsuario= tipoUsuarioEJB.find(idTipoUsuario);
            usuario.setTipoUsuario(tipoUsuario);
            usuario.setPersona(persona);
            usuarioEJB.create(usuario);

            
            
//            
//            tipoUsuario= tipoUsuarioEJB.find(idTipoUsuario);
//            usuario.setTipoUsuario(tipoUsuario);
//            persona.setUsuario(usuario);
//            personaEJB.create(persona);
            persona = new Persona();
            usuario = new Usuario();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "El registroso fue exitoso"));
        }
//        catch( org.hibernate.exception.ConstraintViolationException ex)
//        {
//            persona = new Persona();
//            usuario = new Usuario();
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Uno o mas campos ya estan almacenados en la bd "));
//            System.out.println(ex.getMessage());
//        }
        catch(Exception ex) {
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error! "+ex.getMessage()));
            System.out.println(ex.getMessage());
        }
        
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<TipoUsuario> getTipoUsuarios() {
        return tipoUsuarios;
    }

    public void setTipoUsuarios(List<TipoUsuario> tipoUsuarios) {
        this.tipoUsuarios = tipoUsuarios;
    }

    public Long getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Long idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }
    
    
}
