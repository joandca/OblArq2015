/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.transferenceplus.beans;

import javax.ejb.Local;

/**
 *
 * @author Dell_1
 */
@Local
public interface TokenManagerBeanLocal {

    public void almacenarToken(String usuario, String token);

    public String obtenerToken(String usuario);

    public void borrarToken(String usuario, String token);

    public boolean validarUsuario(String ci, String password);

}
