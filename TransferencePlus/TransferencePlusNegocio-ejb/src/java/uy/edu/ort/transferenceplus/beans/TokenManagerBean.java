/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.transferenceplus.beans;

import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uy.edu.ort.transferenceplus.entities.AprobadorEntity;

/**
 *
 * @author Dell_1
 */
@Stateless
public class TokenManagerBean implements TokenManagerBeanLocal {

    @PersistenceContext
    private EntityManager entityManager;

    private final Map<String, String> almacenTokens = new HashMap();

    @Override
    public void almacenarToken(String usuario, String token) {
        almacenTokens.put(token, usuario);
    }

    @Override
    public String obtenerToken(String usuario) {
        return almacenTokens.get(usuario);
    }

    @Override
    public void borrarToken(String usuario, String token) {
        almacenTokens.remove(token);
    }

    @Override
    public boolean validarUsuario(String ci, String password) {
        Query query = entityManager.createQuery("Select aprobador from AprobadorEntity aprobador where aprobador.ci = :ci and aprobador.password = :password").setParameter("ci", ci).setParameter("password", password);
        try {
            return (AprobadorEntity) query.getSingleResult() != null;
        } catch (NoResultException nre) {
            return false;
        }
    }
}
