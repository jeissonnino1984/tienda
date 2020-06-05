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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "USUARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findById", query = "SELECT u FROM Usuarios u WHERE u.id = :id")
    , @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuarios.findByApellidos", query = "SELECT u FROM Usuarios u WHERE u.apellidos = :apellidos")
    , @NamedQuery(name = "Usuarios.findByTelefono", query = "SELECT u FROM Usuarios u WHERE u.telefono = :telefono")
    , @NamedQuery(name = "Usuarios.findByGenero", query = "SELECT u FROM Usuarios u WHERE u.genero = :genero")
    , @NamedQuery(name = "Usuarios.findByDireccion", query = "SELECT u FROM Usuarios u WHERE u.direccion = :direccion")
    , @NamedQuery(name = "Usuarios.findByCorreo", query = "SELECT u FROM Usuarios u WHERE u.correo = :correo")
    , @NamedQuery(name = "Usuarios.findByClave", query = "SELECT u FROM Usuarios u WHERE u.clave = :clave")
    , @NamedQuery(name = "Usuarios.findByJefePuntoVenta", query = "SELECT u FROM Usuarios u WHERE u.jefePuntoVenta = :jefePuntoVenta")})
public class Usuarios implements Serializable {

    

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
     @GeneratedValue(generator = "SEC_USUARIOS", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEC_USUARIOS", sequenceName = "SEC_USUARIOS", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 100)
    @Column(name = "USUARIO")
    private String usuario;
    @Size(max = 100)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Size(max = 20)
    @Column(name = "GENERO")
    private String genero;
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 100)
    @Column(name = "CORREO")
    private String correo;
    @Size(max = 1000)
    @Column(name = "CLAVE")
    private String clave;
    @JoinColumn(name = "CIUDAD_RESID_FK", referencedColumnName = "CODIGO")
    @ManyToOne
    private Lugares ciudadResidFk;
    @JoinColumn(name = "PUNTO_TRABJANDO_FK", referencedColumnName = "ID")
    @ManyToOne
    private PuntoVenta puntoTrabjandoFk;
    @OneToMany(mappedBy = "jefeFk")
    private List<PuntoVenta> puntoVentaList;
    @Column(name = "TELEFONO")
    private Integer telefono;
    @Column(name = "JEFE_PUNTO_VENTA")
    private Integer jefePuntoVenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendedorId")
    private List<Factura> facturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteId")
    private List<Factura> facturaList1;

    public Usuarios() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

  
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

   

    public Lugares getCiudadResidFk() {
        return ciudadResidFk;
    }

    public void setCiudadResidFk(Lugares ciudadResidFk) {
        this.ciudadResidFk = ciudadResidFk;
    }

    public PuntoVenta getPuntoTrabjandoFk() {
        return puntoTrabjandoFk;
    }

    public void setPuntoTrabjandoFk(PuntoVenta puntoTrabjandoFk) {
        this.puntoTrabjandoFk = puntoTrabjandoFk;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entidades.Usuarios[ id=" + id + " ]".concat(this.apellidos);
    }

   

    public Integer getJefePuntoVenta() {
        return jefePuntoVenta;
    }

    public void setJefePuntoVenta(Integer jefePuntoVenta) {
        this.jefePuntoVenta = jefePuntoVenta;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @XmlTransient
    public List<Factura> getFacturaList1() {
        return facturaList1;
    }

    public void setFacturaList1(List<Factura> facturaList1) {
        this.facturaList1 = facturaList1;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
    
    
    
}
