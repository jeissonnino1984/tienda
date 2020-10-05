/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "IMAGENES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Imagenes.findAll", query = "SELECT i FROM Imagenes i")
    , @NamedQuery(name = "Imagenes.findById", query = "SELECT i FROM Imagenes i WHERE i.id = :id")
    , @NamedQuery(name = "Imagenes.findByNombre", query = "SELECT i FROM Imagenes i WHERE i.nombre = :nombre")
    , @NamedQuery(name = "Imagenes.findByFechaCrea", query = "SELECT i FROM Imagenes i WHERE i.fechaCrea = :fechaCrea")
    , @NamedQuery(name = "Imagenes.findByFechaEdita", query = "SELECT i FROM Imagenes i WHERE i.fechaEdita = :fechaEdita")
    , @NamedQuery(name = "Imagenes.findByUserCrea", query = "SELECT i FROM Imagenes i WHERE i.userCrea = :userCrea")
    , @NamedQuery(name = "Imagenes.findByUserEdita", query = "SELECT i FROM Imagenes i WHERE i.userEdita = :userEdita")
    , @NamedQuery(name = "Imagenes.findByEstado", query = "SELECT i FROM Imagenes i WHERE i.estado = :estado")
    , @NamedQuery(name = "Imagenes.findByObservacion", query = "SELECT i FROM Imagenes i WHERE i.observacion = :observacion")})
public class Imagenes implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(generator = "SEC_IMAGENES", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEC_IMAGENES", sequenceName = "SEC_PRODUCTO", allocationSize = 1)
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 200)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCrea;
    @Column(name = "FECHA_EDITA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEdita;
    @Column(name = "USER_CREA")
    private BigInteger userCrea;
    @Column(name = "USER_EDITA")
    private BigInteger userEdita;
    @Column(name = "ESTADO")
    private BigInteger estado;
    @Size(max = 300)
    @Column(name = "OBSERVACION")
    private String observacion;
    @JoinColumn(name = "PRODUCTO_FK", referencedColumnName = "ID")
    @ManyToOne
    private Producto productoFk;

    public Imagenes() {
    }

    public Imagenes(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public Date getFechaEdita() {
        return fechaEdita;
    }

    public void setFechaEdita(Date fechaEdita) {
        this.fechaEdita = fechaEdita;
    }

    public BigInteger getUserCrea() {
        return userCrea;
    }

    public void setUserCrea(BigInteger userCrea) {
        this.userCrea = userCrea;
    }

    public BigInteger getUserEdita() {
        return userEdita;
    }

    public void setUserEdita(BigInteger userEdita) {
        this.userEdita = userEdita;
    }

    public BigInteger getEstado() {
        return estado;
    }

    public void setEstado(BigInteger estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Producto getProductoFk() {
        return productoFk;
    }

    public void setProductoFk(Producto productoFk) {
        this.productoFk = productoFk;
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
        if (!(object instanceof Imagenes)) {
            return false;
        }
        Imagenes other = (Imagenes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entidades.Imagenes[ id=" + id + " ]";
    }
    
}
