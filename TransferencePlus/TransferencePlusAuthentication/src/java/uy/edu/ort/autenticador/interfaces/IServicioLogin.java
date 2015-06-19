/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.autenticador.interfaces;

/**
 *
 * @author Jose Carro
 * @author Alvaro Gerolami
 */
import java.io.Serializable;
import javax.ejb.Local;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Local
@Path("loginResource")
public interface IServicioLogin extends Serializable {

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(
            @Context HttpHeaders httpHeaders,
            @FormParam("usuario") String usuario,
            @FormParam("password") String password,
            @FormParam("tipoOperador") String tipoOperador);

    @GET
    @Path("demo-get-method")
    @Produces(MediaType.APPLICATION_JSON)
    public Response demoGetMethod();

    @POST
    @Path("demo-post-method")
    @Produces(MediaType.APPLICATION_JSON)
    public Response demoPostMethod();

    @POST
    @Path("logout")
    public Response logout(
            @Context HttpHeaders httpHeaders
    );
}
