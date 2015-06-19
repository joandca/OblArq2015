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
 * @author Jose Carro
 * @author Alvaro Gerolami
 */
@Entity
@Table(name = "Aprobadores")
public class AprobadorEntity extends Operador {

    private static final long serialVersionUID = 1L;

    @Column(name = "montoAprobador", nullable = false)
    private String montoAprobador;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AprobadorEntity)) {
            return false;
        }
        AprobadorEntity other = (AprobadorEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.transferenceplus.entities.AprobadorEntity[ montoAprobador=" + montoAprobador + " ]";
    }

}
