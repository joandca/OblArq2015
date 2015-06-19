/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.transferenceplus.mappers;

import javax.ejb.Stateless;
import uy.edu.ort.dominio.ClienteDTO;
import uy.edu.ort.transferenceplus.entities.ClienteEntity;

/**
 *
 * @author Usuario
 */
@Stateless
public class ClienteMapper implements ClienteMapperLocal {

    @Override
    public ClienteDTO toDTO(ClienteEntity cliente) {
        if (cliente == null) {
            return null;
        }
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setCi(null);
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setApellido(cliente.getApellido());
        clienteDTO.setDireccion(cliente.getDireccion());
        clienteDTO.setTelefono(cliente.getTelefono());

        return clienteDTO;
    }

    @Override
    public ClienteEntity toEntity(ClienteDTO clienteDTO) {

        if (clienteDTO == null) {
            return null;
        }
        ClienteEntity cliente = new ClienteEntity();
        cliente.setCi(clienteDTO.getCi());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setApellido(clienteDTO.getApellido());
        cliente.setDireccion(clienteDTO.getDireccion());
        cliente.setTelefono(clienteDTO.getTelefono());
        return cliente;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
