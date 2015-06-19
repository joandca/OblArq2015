/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.autenticador.beans;

/**
 *
 * @author Jose Carro
 * @author Alvaro Gerolami
 */
import uy.edu.ort.autenticador.interfaces.IServicioLogin;
import uy.edu.ort.autenticador.interfaces.NombresHTTPHeader;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.security.auth.login.LoginException;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@Stateless(name = "ServicioLogin", mappedName = "ejb/ServicioLogin")

public class ServicioLogin implements IServicioLogin {

    private static final long serialVersionUID = -6663599014192066936L;
    @EJB
    private Autenticador autenticador;

    @Override
    public Response login(
            @Context HttpHeaders httpHeaders,
            @FormParam("usuario") String usuario,
            @FormParam("password") String password,
            @FormParam("tipoOperador") String tipoOperador) {

        String serviceKey = httpHeaders.getHeaderString(NombresHTTPHeader.SERVICE_KEY);
        try {
            String authToken = autenticador.login(serviceKey, usuario, password, tipoOperador);

            JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
            jsonObjBuilder.add("auth_token", authToken);
            JsonObject jsonObj = jsonObjBuilder.build();

            return getNoCacheResponseBuilder(Response.Status.OK).entity(jsonObj.toString()).build();

        } catch (final LoginException ex) {
            JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
            jsonObjBuilder.add("message", "Problem matching service key, username and password");
            JsonObject jsonObj = jsonObjBuilder.build();
            return getNoCacheResponseBuilder(Response.Status.UNAUTHORIZED).entity(jsonObj.toString()).build();
        }
    }

    @Override
    public Response demoGetMethod() {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", "Executed demoGetMethod");
        JsonObject jsonObj = jsonObjBuilder.build();

        return getNoCacheResponseBuilder(Response.Status.OK).entity(jsonObj.toString()).build();
    }

    @Override
    public Response demoPostMethod() {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", "Executed demoPostMethod");
        JsonObject jsonObj = jsonObjBuilder.build();

        return getNoCacheResponseBuilder(Response.Status.ACCEPTED).entity(jsonObj.toString()).build();
    }

    @Override
    public Response logout(@Context HttpHeaders httpHeaders) {
        String serviceKey = "service_key";
        String authToken = "auth_token";
        return getNoCacheResponseBuilder(Response.Status.NO_CONTENT).build();
    }

    private Response.ResponseBuilder getNoCacheResponseBuilder(Response.Status status) {
        CacheControl cc = new CacheControl();
        cc.setNoCache(true);
        cc.setMaxAge(-1);
        cc.setMustRevalidate(true);

        return Response.status(status).cacheControl(cc);
    }

}
