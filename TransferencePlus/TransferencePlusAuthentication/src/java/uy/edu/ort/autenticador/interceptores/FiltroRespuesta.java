/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.autenticador.interceptores;

/**
 *
 * @author Dell_1
 */
import uy.edu.ort.autenticador.interfaces.NombresHTTPHeader;  // Verificar como termina esta clase
import java.io.IOException;
import java.util.logging.Logger;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
/**
 *
 * @author Dell_1
 */
@Provider
@PreMatching
public class FiltroRespuesta implements ContainerResponseFilter {

    //VERIFICAR COMO SE VA A MANEJAR EL TEMA DE LOGS
    //private final static Logger log = Logger.getLogger( NombresHTTPHeader.class.getName() );
    
    @Override
    public void filter( ContainerRequestContext requestCtx, ContainerResponseContext responseCtx ) throws IOException {
        
        //VERIFICAR COMO SE VA A MANEJAR EL TEMA DE LOGS
        //log.info( "Filtering REST Response" );
 
        responseCtx.getHeaders().add( "Access-Control-Allow-Origin", "*" );    // AQUI SE PODRIA FILTRAR EL ACCESO POR IP
        responseCtx.getHeaders().add( "Access-Control-Allow-Credentials", "true" );
        responseCtx.getHeaders().add( "Access-Control-Allow-Methods", "GET, POST, DELETE, PUT" );
        responseCtx.getHeaders().add( "Access-Control-Allow-Headers", NombresHTTPHeader.SERVICE_KEY + ", " + NombresHTTPHeader.AUTH_TOKEN );
    }
}
