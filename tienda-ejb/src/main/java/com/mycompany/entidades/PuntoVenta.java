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
@Table(name = "PUNTO_VENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PuntoVenta.findAll", query = "SELECT p FROM PuntoVenta p")
    , @NamedQuery(name = "PuntoVenta.findById", query = "SELECT p FROM PuntoVenta p WHERE p.id = :id")
    , @NamedQuery(name = "PuntoVenta.findByNombrePunto", query = "SELECT p FROM PuntoVenta p WHERE p.nombrePunto = :nombrePunto")
    , @NamedQuery(name = "PuntoVenta.findByDireccion", query = "SELECT p FROM PuntoVenta p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "PuntoVenta.findByEstado", query = "SELECT p FROM PuntoVenta p WHERE p.estado = :estado")
    , @NamedQuery(name = "PuntoVenta.findByUsuarioCrea", query = "SELECT p FROM PuntoVenta p WHERE p.usuarioCrea = :usuarioCrea")
    , @NamedQuery(name = "PuntoVenta.findByFechaCrea", query = "SELECT p FROM PuntoVenta p WHERE p.fechaCrea = :fechaCrea")})
public class PuntoVenta implements Serializable {

    

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(generator = "SEC_PUNTO_VENTA", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEC_PUNTO_VENTA", sequenceName = "SEC_PUNTO_VENTA", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "NOMBRE_PUNTO")
    private String nombrePunto;
    @Size(max = 100)
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "USUARIO_CREA")
    private BigInteger usuarioCrea;
    @Column(name = "FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCrea;
    @Column(name = "ESTADO")
    private Integer estado;
    @OneToMany(mappedBy = "puntoTrabjandoFk")
    private List<Usuarios> usuariosList;
    @JoinColumn(name = "CIUDAD_FK", referencedColumnName = "CODIGO")
    @ManyToOne
    private Lugares ciudadFk;
    @JoinColumn(name = "JEFE_FK", referencedColumnName = "ID")
    @ManyToOne
    private Usuarios jefeFk;

    public PuntoVenta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   

    public String getNombrePunto() {
        return nombrePunto;
    }

    public void setNombrePunto(String nombrePunto) {
        this.nombrePunto = nombrePunto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public BigInteger getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setUsuarioCrea(BigInteger usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public Lugares getCiudadFk() {
        return ciudadFk;
    }

    public void setCiudadFk(Lugares ciudadFk) {
        this.ciudadFk = ciudadFk;
    }

    public Usuarios getJefeFk() {
        return jefeFk;
    }

    public void setJefeFk(Usuarios jefeFk) {
        this.jefeFk = jefeFk;
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
        if (!(object instanceof PuntoVenta)) {
            return false;
        }
        PuntoVenta other = (PuntoVenta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entidades.PuntoVenta[ id=" + id + " ]";
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    
}
