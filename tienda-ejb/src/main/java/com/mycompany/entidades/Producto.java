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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findById", query = "SELECT p FROM Producto p WHERE p.id = :id")
    , @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Producto.findByValorUnitario", query = "SELECT p FROM Producto p WHERE p.valorUnitario = :valorUnitario")
    , @NamedQuery(name = "Producto.findByUnidadesDisponibles", query = "SELECT p FROM Producto p WHERE p.unidadesDisponibles = :unidadesDisponibles")
    , @NamedQuery(name = "Producto.findByValorComprado", query = "SELECT p FROM Producto p WHERE p.valorComprado = :valorComprado")
    , @NamedQuery(name = "Producto.findByValorGanacia", query = "SELECT p FROM Producto p WHERE p.valorGanacia = :valorGanacia")
    , @NamedQuery(name = "Producto.findByImagen", query = "SELECT p FROM Producto p WHERE p.imagen = :imagen")
    , @NamedQuery(name = "Producto.findByFechaIngresa", query = "SELECT p FROM Producto p WHERE p.fechaIngresa = :fechaIngresa")
    , @NamedQuery(name = "Producto.findByFechaVence", query = "SELECT p FROM Producto p WHERE p.fechaVence = :fechaVence")
    , @NamedQuery(name = "Producto.findByUserCrea", query = "SELECT p FROM Producto p WHERE p.userCrea = :userCrea")
    , @NamedQuery(name = "Producto.findByUserEdita", query = "SELECT p FROM Producto p WHERE p.userEdita = :userEdita")
    , @NamedQuery(name = "Producto.findByNumFacturaProveedor", query = "SELECT p FROM Producto p WHERE p.numFacturaProveedor = :numFacturaProveedor")
    , @NamedQuery(name = "Producto.findByObservacion", query = "SELECT p FROM Producto p WHERE p.observacion = :observacion")})
public class Producto implements Serializable {

    @Column(name = "VALOR_UNITARIO")
    private Integer valorUnitario;
    @Column(name = "UNIDADES_DISPONIBLES")
    private Integer unidadesDisponibles;
    @Column(name = "VALOR_COMPRADO")
    private Integer valorComprado;
    @Column(name = "VALOR_GANACIA")
    private Integer valorGanacia;
    @Column(name = "NUM_FACTURA_PROVEEDOR")
    private Integer numFacturaProveedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoId")
    private List<Factura> facturaList;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(generator = "SEC_PRODUCTO", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEC_PRODUCTO", sequenceName = "SEC_PRODUCTO", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 200)
    @Column(name = "IMAGEN")
    private String imagen;
    @Column(name = "FECHA_INGRESA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngresa;
    @Column(name = "FECHA_VENCE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVence;
    @Column(name = "USER_CREA")
    private BigInteger userCrea;
    @Column(name = "USER_EDITA")
    private BigInteger userEdita;
    @Size(max = 4000)
    @Column(name = "OBSERVACION")
    private String observacion;
    
    @JoinColumn(name = "PROVEEDOR_ID", referencedColumnName = "ID")
    @ManyToOne
    private Proveedor proveedorId;
    @JoinColumn(name = "SKU_FK", referencedColumnName = "ID")
    @ManyToOne
    private Sku skuFk;
    @JoinColumn(name = "TIPO_PRODUCTO_ID", referencedColumnName = "ID")
    @ManyToOne
    private TipoProducto tipoProductoId;

    public Producto() {
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   

    public Integer getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(Integer unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Date getFechaIngresa() {
        return fechaIngresa;
    }

    public void setFechaIngresa(Date fechaIngresa) {
        this.fechaIngresa = fechaIngresa;
    }

    public Date getFechaVence() {
        return fechaVence;
    }

    public void setFechaVence(Date fechaVence) {
        this.fechaVence = fechaVence;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Integer valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getValorComprado() {
        return valorComprado;
    }

    public void setValorComprado(Integer valorComprado) {
        this.valorComprado = valorComprado;
    }

    public Integer getValorGanacia() {
        return valorGanacia;
    }

    public void setValorGanacia(Integer valorGanacia) {
        this.valorGanacia = valorGanacia;
    }

    public Integer getNumFacturaProveedor() {
        return numFacturaProveedor;
    }

    public void setNumFacturaProveedor(Integer numFacturaProveedor) {
        this.numFacturaProveedor = numFacturaProveedor;
    }

    

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

  

    public Proveedor getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Proveedor proveedorId) {
        this.proveedorId = proveedorId;
    }

    public Sku getSkuFk() {
        return skuFk;
    }

    public void setSkuFk(Sku skuFk) {
        this.skuFk = skuFk;
    }

    public TipoProducto getTipoProductoId() {
        return tipoProductoId;
    }

    public void setTipoProductoId(TipoProducto tipoProductoId) {
        this.tipoProductoId = tipoProductoId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entidades.Producto[ id=" + id + " ]";
    }

    

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }
    
}
