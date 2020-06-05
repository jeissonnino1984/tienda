/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "FUNCIONALIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionalidad.findAll", query = "SELECT f FROM Funcionalidad f")
    , @NamedQuery(name = "Funcionalidad.findById", query = "SELECT f FROM Funcionalidad f WHERE f.id = :id")
    , @NamedQuery(name = "Funcionalidad.findByUrl", query = "SELECT f FROM Funcionalidad f WHERE f.url = :url")
    , @NamedQuery(name = "Funcionalidad.findByEstado", query = "SELECT f FROM Funcionalidad f WHERE f.estado = :estado")})
public class Funcionalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 200)
    @Column(name = "URL")
    private String url;
    @Column(name = "PAGINA")
    private String pagina;
    @Column(name = "ESTADO")
    private BigInteger estado;
    @OneToMany(mappedBy = "funcionalidadFk")
    private List<FuncionalidadXRol> funcionalidadXRolList;

    public Funcionalidad() {
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }
    
    
    

    public Funcionalidad(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BigInteger getEstado() {
        return estado;
    }

    public void setEstado(BigInteger estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<FuncionalidadXRol> getFuncionalidadXRolList() {
        return funcionalidadXRolList;
    }

    public void setFuncionalidadXRolList(List<FuncionalidadXRol> funcionalidadXRolList) {
        this.funcionalidadXRolList = funcionalidadXRolList;
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
        if (!(object instanceof Funcionalidad)) {
            return false;
        }
        Funcionalidad other = (Funcionalidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entidades.Funcionalidad[ id=" + id + " ]";
    }
    
}
