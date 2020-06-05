/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entidades;

import java.io.Serializable;
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
@Table(name = "PROMOCIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promociones.findAll", query = "SELECT p FROM Promociones p")
    , @NamedQuery(name = "Promociones.findById", query = "SELECT p FROM Promociones p WHERE p.id = :id")
    , @NamedQuery(name = "Promociones.findByFechaInicio", query = "SELECT p FROM Promociones p WHERE p.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Promociones.findByFechaTermina", query = "SELECT p FROM Promociones p WHERE p.fechaTermina = :fechaTermina")
    , @NamedQuery(name = "Promociones.findByPorcentajeDes", query = "SELECT p FROM Promociones p WHERE p.porcentajeDes = :porcentajeDes")
    , @NamedQuery(name = "Promociones.findByUserCrea", query = "SELECT p FROM Promociones p WHERE p.userCrea = :userCrea")
    , @NamedQuery(name = "Promociones.findByEstado", query = "SELECT p FROM Promociones p WHERE p.estado = :estado")
    , @NamedQuery(name = "Promociones.findByNombre", query = "SELECT p FROM Promociones p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Promociones.findByCondiciones", query = "SELECT p FROM Promociones p WHERE p.condiciones = :condiciones")})
public class Promociones implements Serializable {

    

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(generator = "SEC_PROMOCION", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEC_PROMOCION", sequenceName = "SEC_PROMOCION", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_TERMINA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTermina;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 4000)
    @Column(name = "CONDICIONES")
    private String condiciones;
    @Column(name = "PORCENTAJE_DES")
    private Integer porcentajeDes;
    @Column(name = "USER_CREA")
    private Integer userCrea;
    @Column(name = "ESTADO")
    private Integer estado;
    @OneToMany(mappedBy = "promocionFk")
    private List<ProductoXPromocion> productoXPromocionList;
    

    public Promociones() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPorcentajeDes() {
        return porcentajeDes;
    }

    public void setPorcentajeDes(Integer porcentajeDes) {
        this.porcentajeDes = porcentajeDes;
    }

    public Integer getUserCrea() {
        return userCrea;
    }

    public void setUserCrea(Integer userCrea) {
        this.userCrea = userCrea;
    }

    

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermina() {
        return fechaTermina;
    }

    public void setFechaTermina(Date fechaTermina) {
        this.fechaTermina = fechaTermina;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
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
        if (!(object instanceof Promociones)) {
            return false;
        }
        Promociones other = (Promociones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entidades.Promociones[ id=" + id + " ]";
    }

   

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    @XmlTransient
    public List<ProductoXPromocion> getProductoXPromocionList() {
        return productoXPromocionList;
    }

    public void setProductoXPromocionList(List<ProductoXPromocion> productoXPromocionList) {
        this.productoXPromocionList = productoXPromocionList;
    }

    

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    


 
  
   
    
}
