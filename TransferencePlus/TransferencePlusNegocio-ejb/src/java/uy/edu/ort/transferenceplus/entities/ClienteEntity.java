/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.transferenceplus.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "clientes")
public class ClienteEntity extends EntidadPersistente {

    @Column(name = "ci", nullable = false)
    private String ci;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCi() {
        return ci;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteEntity)) {
            return false;
        }
        ClienteEntity other = (ClienteEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        // return "uy.edu.ort.trfplus.entidades.ClienteEntity[ id=" + id + " ]";
        return "Cliente{" + "nombre=" + nombre + "apellido=" + apellido + "ci=" + ci + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }

}
