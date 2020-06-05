/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "LUGARES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lugares.findAll", query = "SELECT l FROM Lugares l")
    , @NamedQuery(name = "Lugares.findByCodigo", query = "SELECT l FROM Lugares l WHERE l.codigo = :codigo")
    , @NamedQuery(name = "Lugares.findByDescripcion", query = "SELECT l FROM Lugares l WHERE l.descripcion = :descripcion")
    , @NamedQuery(name = "Lugares.findByTipo", query = "SELECT l FROM Lugares l WHERE l.tipo = :tipo")
    , @NamedQuery(name = "Lugares.findByLugePapa", query = "SELECT l FROM Lugares l WHERE l.lugePapa = :lugePapa")})
public class Lugares implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "LUGE_PAPA")
    private Integer lugePapa;
    @OneToMany(mappedBy = "ciudadFk")
    private List<Proveedor> proveedorList;
    @OneToMany(mappedBy = "ciudadResidFk")
    private List<Usuarios> usuariosList;
    @OneToMany(mappedBy = "ciudadFk")
    private List<PuntoVenta> puntoVentaList;

    public Lugares() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

   

    public Lugares(Integer codigo, String descripcion, String tipo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getLugePapa() {
        return lugePapa;
    }

    public void setLugePapa(Integer lugePapa) {
        this.lugePapa = lugePapa;
    }

    @XmlTransient
    public List<Proveedor> getProveedorList() {
        return proveedorList;
    }

    public void setProveedorList(List<Proveedor> proveedorList) {
        this.proveedorList = proveedorList;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @XmlTransient
    public List<PuntoVenta> getPuntoVentaList() {
        return puntoVentaList;
    }

    public void setPuntoVentaList(List<PuntoVenta> puntoVentaList) {
        this.puntoVentaList = puntoVentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lugares)) {
            return false;
        }
        Lugares other = (Lugares) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entidades.Lugares[ codigo=" + codigo + " ]";
    }
    
}
