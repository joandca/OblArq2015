/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.transferenceplus.mappers;

import javax.ejb.Local;
import uy.edu.ort.dominio.ClienteDTO;
import uy.edu.ort.transferenceplus.entities.ClienteEntity;

/**
 *
 * @author Usuario
 */
@Local
public interface ClienteMapperLocal {

    ClienteDTO toDTO(ClienteEntity cliente);

    ClienteEntity toEntity(ClienteDTO clienteDTO);
}
