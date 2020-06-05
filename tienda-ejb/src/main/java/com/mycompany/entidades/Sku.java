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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "SKU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sku.findAll", query = "SELECT s FROM Sku s")
    , @NamedQuery(name = "Sku.findById", query = "SELECT s FROM Sku s WHERE s.id = :id")
    , @NamedQuery(name = "Sku.findByReferencia", query = "SELECT s FROM Sku s WHERE s.referencia = :referencia")
    , @NamedQuery(name = "Sku.findByEstado", query = "SELECT s FROM Sku s WHERE s.estado = :estado")
    , @NamedQuery(name = "Sku.findByUserCrea", query = "SELECT s FROM Sku s WHERE s.userCrea = :userCrea")
    , @NamedQuery(name = "Sku.findByUserEdita", query = "SELECT s FROM Sku s WHERE s.userEdita = :userEdita")
    , @NamedQuery(name = "Sku.findByFechaCrea", query = "SELECT s FROM Sku s WHERE s.fechaCrea = :fechaCrea")
    , @NamedQuery(name = "Sku.findByFechaEdita", query = "SELECT s FROM Sku s WHERE s.fechaEdita = :fechaEdita")
    , @NamedQuery(name = "Sku.findByDescripcionReferencia", query = "SELECT s FROM Sku s WHERE s.descripcionReferencia = :descripcionReferencia")})
public class Sku implements Serializable {

    @Column(name = "ESTADO")
    private Integer estado;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(generator = "SEC_SKU", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEC_SKU", sequenceName = "SEC_SKU", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "REFERENCIA")
    private String referencia;
    @Column(name = "USER_CREA")
    private BigInteger userCrea;
    @Column(name = "USER_EDITA")
    private BigInteger userEdita;
    @Column(name = "FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCrea;
    @Column(name = "FECHA_EDITA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEdita;
    @Size(max = 4000)
    @Column(name = "DESCRIPCION_REFERENCIA")
    private String descripcionReferencia;
    @OneToMany(mappedBy = "skuFk")
    private List<Producto> productoList;

    public Sku() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

  
    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
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

    public String getDescripcionReferencia() {
        return descripcionReferencia;
    }

    public void setDescripcionReferencia(String descripcionReferencia) {
        this.descripcionReferencia = descripcionReferencia;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
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
        if (!(object instanceof Sku)) {
            return false;
        }
        Sku other = (Sku) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entidades.Sku[ id=" + id + " ]";
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    
}
