/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkear.managed;

import com.linkear.model.Usuario;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author pc
 */
@Named("MBPlantilla")
@ViewScoped
public class ManageBeanPlantilla implements Serializable {

    FacesContext context = FacesContext.getCurrentInstance();
    public void verificarSesion() {
        try {
            Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
            if(us==null){
                context.getExternalContext().redirect("./../permisos.xhtml");
            }
        } catch (Exception ex) {
        }
    }

}
