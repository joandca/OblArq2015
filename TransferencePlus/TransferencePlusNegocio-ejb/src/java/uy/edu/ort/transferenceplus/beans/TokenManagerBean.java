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
import uy.edu.ort.transferenceplus.entities.IngresadorEntity;

/**
 *
 * @author Dell_1
 */
@Stateless
public class TokenManagerBean implements TokenManagerBeanLocal {

    @PersistenceContext
    private EntityManager entityManager;

    private final Map<String, String> almacenTokens = new HashMap();

    /**
     * Tipos de Usuarios
     */
    private static final String TIPO_APROBADOR = "aprobador";
    private static final String TIPO_INGRESADOR = "ingresador";

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
    public boolean validarUsuario(String usuario, String password, String tipoUsuario) {

        // Variables locales.
        Query query;
        boolean result = false;
        try {
            switch (tipoUsuario) {
                case TIPO_APROBADOR:
                    query = entityManager.createQuery("Select aprobador from AprobadorEntity aprobador where aprobador.usuario = :usuario and aprobador.password = :password").setParameter("usuario", usuario).setParameter("password", password);
                    result = (AprobadorEntity) query.getSingleResult() != null;
                    break;
                case TIPO_INGRESADOR:
                    query = entityManager.createQuery("Select ingresador from IngresadorEntity ingresador where ingresador.usuario = :usuario and ingresador.password = :password").setParameter("usuario", usuario).setParameter("password", password);
                    result = (IngresadorEntity) query.getSingleResult() != null;
                    break;
                default:
                    // TODO: throw exception.
                    break;
            }
            return result;
        } catch (NoResultException nre) {
            return false;
        }
    }
}
