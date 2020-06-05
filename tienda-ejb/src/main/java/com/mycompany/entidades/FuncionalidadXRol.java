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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "FUNCIONALIDAD_X_ROL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FuncionalidadXRol.findAll", query = "SELECT f FROM FuncionalidadXRol f")
    , @NamedQuery(name = "FuncionalidadXRol.findById", query = "SELECT f FROM FuncionalidadXRol f WHERE f.id = :id")})
public class FuncionalidadXRol implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "FUNCIONALIDAD_FK", referencedColumnName = "ID")
    @ManyToOne
    private Funcionalidad funcionalidadFk;
    @JoinColumn(name = "ROL_FK", referencedColumnName = "ID")
    @ManyToOne
    private Rol rolFk;

    public FuncionalidadXRol() {
    }

    public FuncionalidadXRol(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Funcionalidad getFuncionalidadFk() {
        return funcionalidadFk;
    }

    public void setFuncionalidadFk(Funcionalidad funcionalidadFk) {
        this.funcionalidadFk = funcionalidadFk;
    }

    public Rol getRolFk() {
        return rolFk;
    }

    public void setRolFk(Rol rolFk) {
        this.rolFk = rolFk;
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
        if (!(object instanceof FuncionalidadXRol)) {
            return false;
        }
        FuncionalidadXRol other = (FuncionalidadXRol) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entidades.FuncionalidadXRol[ id=" + id + " ]";
    }
    
}
