/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.transferenceplus.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Dell_1
 */
@MappedSuperclass
public class Operador extends EntidadPersistente {

    @Column(unique = true, nullable = false)
    private Integer ci;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private int minimoTransferencia;

    public Integer getCi() {
        return ci;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public int getMinimoTransferencia() {
        return minimoTransferencia;
    }

    public void setCi(Integer ci) {
        this.ci = ci;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMinimoTransferencia(int minimoTransferencia) {
        this.minimoTransferencia = minimoTransferencia;
    }

}
