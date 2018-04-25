/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkear.beans;

import com.linkear.model.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author pc
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "notasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public Usuario validarSesion(Usuario us) {
        String consulta = "FROM Usuario u WHERE u.usuario=?1 and u.clave=?2";
        Usuario usuario = null;
        try {
            Query query =  em.createQuery(consulta);
            query.setParameter(1, us.getUsuario());
            query.setParameter(2, us.getClave());
            List<Usuario> usuarios = query.getResultList();
            if(!usuarios.isEmpty()){
                usuario = usuarios.get(0);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return usuario;
    }

}
