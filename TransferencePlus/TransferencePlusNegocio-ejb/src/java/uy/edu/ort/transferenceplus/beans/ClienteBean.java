/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.transferenceplus.beans;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uy.edu.ort.transferenceplus.entities.ClienteEntity;

/**
 *
 * @author Usuario
 */
@Stateless
@LocalBean  // AGREGADO X JOSE
public class ClienteBean implements ClienteBeanLocal {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void alta(ClienteEntity cliente) {
        entityManager.persist(cliente);
        System.out.println("Se dio de alta el cliente:" + cliente.getNombre());
    }

    @Override
    public void eliminar(ClienteEntity cliente) {
        System.out.println("Se dio de baja el cliente:" + cliente.getNombre());
    }

    @Override
    public void modificar(ClienteEntity cliente) {
        System.out.println("Se modificó el cliente:" + cliente.getNombre());
    }

    @Override
    public List<ClienteEntity> listar() {
        // Creo la consulta.
        Query query = entityManager.createQuery("select c from ClienteEntity c");
        try {
            return query.getResultList();
        } catch (NoResultException noResultException) {
            return new ArrayList<ClienteEntity>();
        }
    }

    @Override
    public List<ClienteEntity> obtenerClientesPorCi(String ci) {
        Query q = entityManager.createQuery("select c from Cliente c");
        try {
            return q.getResultList();
        } catch (NoResultException nre) {
            return new ArrayList<ClienteEntity>();
        }
    }


}
