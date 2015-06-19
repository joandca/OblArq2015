/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.transferenceplus.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Jose Carro
 * @author Alvaro Gerolami
 */
@MappedSuperclass
public class Operador extends EntidadPersistente {

    @Column(name = "ci", nullable = false)
    private String ci;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "usuario", nullable = false)
    private String usuario;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "minimoTransferencia", nullable = false)
    private int minimoTransferencia;

    public String getCi() {
        return ci;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public int getMinimoTransferencia() {
        return minimoTransferencia;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMinimoTransferencia(int minimoTransferencia) {
        this.minimoTransferencia = minimoTransferencia;
    }

}
