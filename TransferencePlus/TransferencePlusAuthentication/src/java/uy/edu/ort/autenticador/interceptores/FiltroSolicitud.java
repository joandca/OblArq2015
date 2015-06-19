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
import uy.edu.ort.autenticador.beans.Autenticador;  // Verificar como termina esta clase
import uy.edu.ort.autenticador.interfaces.NombresHTTPHeader;  // Verificar como termina esta clase
import java.io.IOException;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
/**
 *
 * @author Dell_1
 */
@Provider
@PreMatching
public class FiltroSolicitud implements ContainerRequestFilter {
    
    //VER COMO SE IMPLEMENTA EL LOGUEO
    // private final static Logger log = Logger.getLogger( DemoRESTRequestFilter.class.getName() );
    
    @EJB
    private Autenticador autenticador;
    @Override
    public void filter( ContainerRequestContext requestCtx ) throws IOException {
         String path = requestCtx.getUriInfo().getPath();
        //VER COMO SE IMPLEMENTA EL LOGUEO 
        //log.info( "Filtering request path: " + path );
        
         //VERIFICAR PARA QUE ES ESTE CONTROL
         if ( requestCtx.getRequest().getMethod().equals( "OPTIONS" ) ) {
            requestCtx.abortWith( Response.status( Response.Status.OK ).build() );
 
            return;
        }
        // Verifica si el Key existe y es valido
         
       // Autenticador autenticador = Autenticador.getInstance();
        String serviceKey = requestCtx.getHeaderString( NombresHTTPHeader.SERVICE_KEY );
        if ( !autenticador.isServiceKeyValid( serviceKey ) ) {
            // Kick anyone without a valid service key
            requestCtx.abortWith( Response.status( Response.Status.UNAUTHORIZED ).build() );
 
            return;
        }
 
        // For any pther methods besides login, the authToken must be verified
        if ( !path.startsWith( "loginResource/login" ) ) {
            String authToken = requestCtx.getHeaderString( NombresHTTPHeader.AUTH_TOKEN );
 
            // if it isn't valid, just kick them out.
//            if ( !autenticador.isAuthTokenValid( serviceKey, authToken ) ) {
//                requestCtx.abortWith( Response.status( Response.Status.UNAUTHORIZED ).build() );
//            }
        }
    }
}

