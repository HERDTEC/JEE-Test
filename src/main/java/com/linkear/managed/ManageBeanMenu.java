/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkear.managed;

import com.linkear.beans.MenuFacadeLocal;
import com.linkear.model.Menu;
import com.linkear.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/*
* @Named y @SessionScoped no funciona con import javax.faces.bean.SessionScoped; si no con javax.enterprise.context.SessionScoped;

 */
@Named("MBMenu")
@SessionScoped

public class ManageBeanMenu implements Serializable {

    @EJB
    private MenuFacadeLocal menuEJB;
    private List<Menu> menus;
    private MenuModel menuModel;

    @PostConstruct
    public void init() {
        this.listarMenu();
        menuModel = new DefaultMenuModel();
        this.establecerPermisos();
    }

    public void listarMenu() {
        try {
            menus = menuEJB.findAll();
        } catch (Exception ex) {
            //mensaje jsf
            System.out.println(ex.getMessage());
        }
    }

    public void establecerPermisos() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        for (Menu m : menus) {
            if (us!=null && m.getTipoUsuario().equals(us.getTipoUsuario())) {
                if (m.getTipo().equals("S")) {
                    DefaultSubMenu firstSubMenu = new DefaultSubMenu(m.getNombre());
                    for (Menu sm : menus) {
                        if (sm.getSubMenu() != null && sm.getSubMenu().getIdMenu() == m.getIdMenu()) {
                            DefaultMenuItem item = new DefaultMenuItem(sm.getNombre());
                            item.setUrl(sm.getUrl());
                            firstSubMenu.addElement(item);
                        }
                    }
                    menuModel.addElement(firstSubMenu);
                } else {
                    if (m.getSubMenu() == null) {
                        DefaultMenuItem item = new DefaultMenuItem(m.getNombre());
                        item.setUrl(m.getUrl());
                        menuModel.addElement(item);
                    }
                }
            }
        }

    }
    public void cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public MenuModel getMenuModel() {
        return menuModel;
    }

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }

}
