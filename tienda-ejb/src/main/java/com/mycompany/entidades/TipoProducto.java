/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "TIPO_PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProducto.findAll", query = "SELECT t FROM TipoProducto t")
    , @NamedQuery(name = "TipoProducto.findById", query = "SELECT t FROM TipoProducto t WHERE t.id = :id")
    , @NamedQuery(name = "TipoProducto.findByTipo", query = "SELECT t FROM TipoProducto t WHERE t.tipo = :tipo")
    , @NamedQuery(name = "TipoProducto.findByEstado", query = "SELECT t FROM TipoProducto t WHERE t.estado = :estado")})
public class TipoProducto implements Serializable {

    @Column(name = "ESTADO")
    private Integer estado;
    @OneToMany(mappedBy = "tipoProductoId")
    private List<Producto> productoList;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(generator = "SEC_TIPO_PRODUCTO", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEC_TIPO_PRODUCTO", sequenceName = "SEC_TIPO_PRODUCTO", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "TIPO")
    private String tipo;

    public TipoProducto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        if (!(object instanceof TipoProducto)) {
            return false;
        }
        TipoProducto other = (TipoProducto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entidades.TipoProducto[ id=" + id + " ]";
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }
    
}
