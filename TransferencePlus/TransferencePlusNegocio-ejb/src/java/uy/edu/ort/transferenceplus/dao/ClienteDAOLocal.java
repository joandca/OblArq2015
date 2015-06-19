/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.transferenceplus.dao;

import java.util.List;
import javax.ejb.Local;
import uy.edu.ort.transferenceplus.entities.ClienteEntity;

/**
 *
 * @author Dell_1
 */
@Local
public interface ClienteDAOLocal {
   
   
   public void alta(ClienteEntity cliente);

    public void eliminar(ClienteEntity cliente);

    public void modificar(ClienteEntity cliente);

    public List<ClienteEntity> listar();
    
    public List<ClienteEntity> obtenerClientesPorCi(String ci);
    
    
}
