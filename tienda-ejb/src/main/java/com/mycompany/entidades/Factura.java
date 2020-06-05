/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entidades;

import java.io.Serializable;
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
@Table(name = "FACTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByTotalCompra", query = "SELECT f FROM Factura f WHERE f.totalCompra = :totalCompra")
    , @NamedQuery(name = "Factura.findById", query = "SELECT f FROM Factura f WHERE f.id = :id")
    , @NamedQuery(name = "Factura.findByIva", query = "SELECT f FROM Factura f WHERE f.iva = :iva")
    , @NamedQuery(name = "Factura.findByCantidad", query = "SELECT f FROM Factura f WHERE f.cantidad = :cantidad")
    , @NamedQuery(name = "Factura.findByFechaCompra", query = "SELECT f FROM Factura f WHERE f.fechaCompra = :fechaCompra")
    , @NamedQuery(name = "Factura.findBySubtotal", query = "SELECT f FROM Factura f WHERE f.subtotal = :subtotal")
    , @NamedQuery(name = "Factura.findByCancelado", query = "SELECT f FROM Factura f WHERE f.cancelado = :cancelado")
    , @NamedQuery(name = "Factura.findByObservacion", query = "SELECT f FROM Factura f WHERE f.observacion = :observacion")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "TOTAL_COMPRA")
    private BigInteger totalCompra;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(generator = "SEC_FACTURA", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEC_FACTURA", sequenceName = "SEC_FACTURA", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "IVA")
    private Integer iva;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    @Column(name = "FECHA_COMPRA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCompra;
    @Column(name = "SUBTOTAL")
    private Integer subtotal;
    @Column(name = "CANCELADO")
    private Integer cancelado;
    @Size(max = 4000)
    @Column(name = "OBSERVACION")
    private String observacion;
    @JoinColumn(name = "NUM_FACTURA_FK", referencedColumnName = "NUMERO")
    @ManyToOne
    private NumFactura numFacturaFk;
    @JoinColumn(name = "PRODUCTO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Producto productoId;
    @JoinColumn(name = "VENDEDOR_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuarios vendedorId;
    @JoinColumn(name = "CLIENTE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuarios clienteId;

    public Factura() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIva() {
        return iva;
    }

    public void setIva(Integer iva) {
        this.iva = iva;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getCancelado() {
        return cancelado;
    }

    public void setCancelado(Integer cancelado) {
        this.cancelado = cancelado;
    }

    

    public BigInteger getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(BigInteger totalCompra) {
        this.totalCompra = totalCompra;
    }

    
    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public NumFactura getNumFacturaFk() {
        return numFacturaFk;
    }

    public void setNumFacturaFk(NumFactura numFacturaFk) {
        this.numFacturaFk = numFacturaFk;
    }

    public Producto getProductoId() {
        return productoId;
    }

    public void setProductoId(Producto productoId) {
        this.productoId = productoId;
    }

    public Usuarios getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(Usuarios vendedorId) {
        this.vendedorId = vendedorId;
    }

    public Usuarios getClienteId() {
        return clienteId;
    }

    public void setClienteId(Usuarios clienteId) {
        this.clienteId = clienteId;
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
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entidades.Factura[ id=" + id + " ]";
    }
    
}
