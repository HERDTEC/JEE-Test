/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkear.managed;

import com.linkear.beans.UsuarioFacadeLocal;
import com.linkear.model.Usuario;
import java.io.Serializable;
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
@Named("MBIndex")
@ViewScoped
public class ManageBeanIndex implements Serializable{
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    private Usuario usuario ;
    @PostConstruct
    public void init(){
        usuario= new Usuario();
    }
    
    public String iniciarSesion(){
        String redireccion = null;
        try{
            Usuario us = usuarioEJB.validarSesion(usuario);
            if (us!=null){
                //nav implicita
                //redireccion ="protegido/principal";
                //nav explicita
                //Almacenar session
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                redireccion ="protegido/principal?faces-redirect=true";
               
            }
            else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Usuario o password no son correctos"));
            }
            
        }
        catch(Exception ex){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error"));
            System.out.println(ex.getMessage());
        }
        return redireccion;
    } 

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
    
}
