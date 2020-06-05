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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "PRODUCTO_X_PROMOCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoXPromocion.findAll", query = "SELECT p FROM ProductoXPromocion p")
    , @NamedQuery(name = "ProductoXPromocion.findById", query = "SELECT p FROM ProductoXPromocion p WHERE p.id = :id")
    , @NamedQuery(name = "ProductoXPromocion.findByFechaCrea", query = "SELECT p FROM ProductoXPromocion p WHERE p.fechaCrea = :fechaCrea")
    , @NamedQuery(name = "ProductoXPromocion.findByUserCrea", query = "SELECT p FROM ProductoXPromocion p WHERE p.userCrea = :userCrea")})
public class ProductoXPromocion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(generator = "SEC_PRODUCTO_PROMOCION", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEC_PRODUCTO_PROMOCION", sequenceName = "SEC_PRODUCTO_PROMOCION", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCrea;
    @Column(name = "USER_CREA")
    private BigInteger userCrea;
    @JoinColumn(name = "PRODUCTO_FK", referencedColumnName = "ID")
    @ManyToOne
    private Producto productoFk;
    @JoinColumn(name = "PROMOCION_FK", referencedColumnName = "ID")
    @ManyToOne
    private Promociones promocionFk;

    public ProductoXPromocion() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   

    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public BigInteger getUserCrea() {
        return userCrea;
    }

    public void setUserCrea(BigInteger userCrea) {
        this.userCrea = userCrea;
    }

    public Producto getProductoFk() {
        return productoFk;
    }

    public void setProductoFk(Producto productoFk) {
        this.productoFk = productoFk;
    }

    public Promociones getPromocionFk() {
        return promocionFk;
    }

    public void setPromocionFk(Promociones promocionFk) {
        this.promocionFk = promocionFk;
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
        if (!(object instanceof ProductoXPromocion)) {
            return false;
        }
        ProductoXPromocion other = (ProductoXPromocion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entidades.ProductoXPromocion[ id=" + id + " ]";
    }
    
  
    
}
