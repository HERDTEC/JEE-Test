package com.linkear.managed;

import com.linkear.beans.CategoriaFacadeLocal;
import com.linkear.model.Categoria;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;



@Named("MBCategoria")

@ViewScoped
public class ManagedBeanCategoria implements Serializable{

    @EJB
    private CategoriaFacadeLocal categoriaEJB;
    private Categoria categoria;
    private String nombre ="";

    @PostConstruct
    public void init() {
        categoria = new Categoria();
    }

    public void registrar() {
        nombre= categoria.getNombres();
        try {
            categoriaEJB.create(categoria);
            categoria = new Categoria();
        } catch (Exception ex) {
            categoria = new Categoria();
        }
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
