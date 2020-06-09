/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "PRUEBA_CLOB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PruebaClob.findAll", query = "SELECT p FROM PruebaClob p")
    , @NamedQuery(name = "PruebaClob.findById", query = "SELECT p FROM PruebaClob p WHERE p.id = :id")})
public class PruebaClob implements Serializable {

    private static final long serialVersionUID = 1L;
    @Lob
    @Column(name = "ONSERVACION")
    private String onservacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;

    public PruebaClob() {
    }

    public PruebaClob(BigDecimal id) {
        this.id = id;
    }

    public String getOnservacion() {
        return onservacion;
    }

    public void setOnservacion(String onservacion) {
        this.onservacion = onservacion;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
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
        if (!(object instanceof PruebaClob)) {
            return false;
        }
        PruebaClob other = (PruebaClob) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entidades.PruebaClob[ id=" + id + " ]";
    }
    
}
