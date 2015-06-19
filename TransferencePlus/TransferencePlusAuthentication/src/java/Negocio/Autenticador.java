/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Dell_1
 */


import java.util.UUID;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.security.auth.login.LoginException;
import uy.edu.ort.transferenceplus.beans.TokenManagerBeanLocal;

/**
 *
 * @author Dell_1
 */

@Stateless
public class Autenticador {

    private static final String SERVICE_KEY = "service_key";

    @EJB
    private TokenManagerBeanLocal tokenManagerBean;

    //private static Autenticador instance = null;

    public Autenticador() {
    }

//    public static Autenticador getInstance() {
//        if (instance == null) {
//            instance = new Autenticador();
//        }
//        return instance;
//    }

    /**
     *
     * @param serviceKey
     * @param ci
     * @param password
     * @return
     * @throws LoginException
     */
    public String login(String serviceKey, String ci, String password) throws LoginException {
        if (this.validarUsuario(ci, password) && serviceKey.equals(SERVICE_KEY)) {
            String token = UUID.randomUUID().toString();
            tokenManagerBean.almacenarToken(ci, token);
            return token;
        }
        // VERIFICAR MANEJO DE EXEPCIONES
        throw new LoginException("Usuario no habilitado");
    }

    /**
     *
     * @param ci
     * @param password
     * @return
     */
    private boolean validarUsuario(String ci, String password) {
        return tokenManagerBean.validarUsuario(ci, password);
    }

    /**
     * The method that pre-validates if the client which invokes the REST API is
     * from a authorized and authenticated source.
     *
     * @param serviceKey corresponde al service key
     * @param authToken El token generado despues de hacer login
     * @return TRUE para la confirmacion y FALSE para la denogacion.
     */
//    public boolean isAuthTokenValid(String serviceKey, String authToken) {
//        
//        if (isServiceKeyValid(serviceKey)) {
//            String usuarioMatch1 = almacenServiceKeys.get(serviceKey);
//            
//            if (almacenTokens.containsKey(authToken)) {
//                String usuarioMatch2 = almacenTokens.get(authToken);
//                
//                if (usuarioMatch1.equals(usuarioMatch2)) {
//                    return true;
//                }
//            }
//        }
//        
//        return false;
//    }
    /**
     * Este metodo verifica si el serviceKey es valido
     *
     * @param serviceKey
     * @return Verdadero si el service key existe con los service Keys
     * existentes en el almacen de lo contrario retorna falose
     */
    public boolean isServiceKeyValid(String serviceKey) {
        return serviceKey.equals(SERVICE_KEY);
    }

//    public void logout(String serviceKey, String authToken) throws GeneralSecurityException {
//        if (almacenServiceKeys.containsKey(serviceKey)) {
//            String usernameMatch1 = almacenServiceKeys.get(serviceKey);
//            
//            if (almacenTokens.containsKey(authToken)) {
//                String usernameMatch2 = almacenTokens.get(authToken);
//                
//                if (usernameMatch1.equals(usernameMatch2)) {
//
//                    /**
//                     * Cuando el cliente se desloguea, el token es removido
//                     */
//                    almacenTokens.remove(authToken);
//                    return;
//                }
//            }
//        }
//        //VERIFICAR MANEJO DE EXCEPCIONES
//        throw new GeneralSecurityException("Key Service es invalido y token");
//    }
}
