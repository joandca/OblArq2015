/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.transferenceplus.resources;

import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import uy.edu.ort.dominio.ClienteDTO;
import uy.edu.ort.transferenceplus.beans.ClienteBeanLocal;
import uy.edu.ort.transferenceplus.entities.ClienteEntity;
import uy.edu.ort.transferenceplus.mappers.ClienteMapperLocal;

/**
 *
 * @author Usuario
 */
@Path("clientes")
@RequestScoped
public class ClientesResource {

    @EJB
    private ClienteBeanLocal clienteBean;

    @EJB
    private ClienteMapperLocal clienteMapper;

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public ClienteDTO alta(ClienteDTO cliente) {
        clienteBean.alta(clienteMapper.toEntity(cliente));
        return cliente;
    }

    @PUT
    @Path("/{ci}")
    @Consumes("application/json")
    public Response modificar(@PathParam("ci") String ci, ClienteDTO cliente) {
        Response response;
        try {
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setCi(ci);
            clienteBean.modificar(clienteMapper.toEntity(clienteDTO));
            response = Response.ok(clienteDTO).build();
        } catch (Exception ex) {
            response = Response.serverError().entity(ex).build();
        }
        return response;
    }
    
    

    @DELETE
    @Path("/{ci}")
    public Response eliminar(@PathParam("ci") String ci) {

        Response response = Response.ok("falta implementar!").build();
        return response;

        /* Response response;
         try {
         clienteBean.
         clienteBean.eliminar(cliente);
         response = Response.ok(ci).build();
         } catch (Exception ex) {
         response = Response.serverError().entity(ex).build();
         }
         return response;
         */
    }

    @GET
    @Produces("application/json")
    public List<ClienteDTO> listar() {
        List<ClienteEntity> clientes = this.clienteBean.listar();
        List<ClienteDTO> clientesDTOs = new LinkedList<ClienteDTO>();
        for (ClienteEntity cliente : clientes) {
            clientesDTOs.add(this.clienteMapper.toDTO(cliente));
        }

        return clientesDTOs;
    }

}
