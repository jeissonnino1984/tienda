/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "PARAMETRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametro.findAll", query = "SELECT p FROM Parametro p")
    , @NamedQuery(name = "Parametro.findById", query = "SELECT p FROM Parametro p WHERE p.id = :id")
    , @NamedQuery(name = "Parametro.findByNombre", query = "SELECT p FROM Parametro p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Parametro.findByGrupo", query = "SELECT p FROM Parametro p WHERE p.grupo = :grupo")
    , @NamedQuery(name = "Parametro.findByValor", query = "SELECT p FROM Parametro p WHERE p.valor = :valor")
    , @NamedQuery(name = "Parametro.findByDescripcion", query = "SELECT p FROM Parametro p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Parametro.findByValorMaximo", query = "SELECT p FROM Parametro p WHERE p.valorMaximo = :valorMaximo")
    , @NamedQuery(name = "Parametro.findBySigla", query = "SELECT p FROM Parametro p WHERE p.sigla = :sigla")
    , @NamedQuery(name = "Parametro.findByUsuarioCrea", query = "SELECT p FROM Parametro p WHERE p.usuarioCrea = :usuarioCrea")
    , @NamedQuery(name = "Parametro.findByFechaCrea", query = "SELECT p FROM Parametro p WHERE p.fechaCrea = :fechaCrea")
    , @NamedQuery(name = "Parametro.findByUsuarioModifica", query = "SELECT p FROM Parametro p WHERE p.usuarioModifica = :usuarioModifica")
    , @NamedQuery(name = "Parametro.findByFechaModifica", query = "SELECT p FROM Parametro p WHERE p.fechaModifica = :fechaModifica")})
public class Parametro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 100)
    @Column(name = "GRUPO")
    private String grupo;
    @Size(max = 1000)
    @Column(name = "VALOR")
    private String valor;
    @Size(max = 500)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 100)
    @Column(name = "VALOR_MAXIMO")
    private String valorMaximo;
    @Size(max = 10)
    @Column(name = "SIGLA")
    private String sigla;
    @Size(max = 100)
    @Column(name = "USUARIO_CREA")
    private String usuarioCrea;
    @Column(name = "FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCrea;
    @Size(max = 100)
    @Column(name = "USUARIO_MODIFICA")
    private String usuarioModifica;
    @Column(name = "FECHA_MODIFICA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModifica;

    public Parametro() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(String valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setUsuarioCrea(String usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public String getUsuarioModifica() {
        return usuarioModifica;
    }

    public void setUsuarioModifica(String usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
    }

    public Date getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(Date fechaModifica) {
        this.fechaModifica = fechaModifica;
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
        if (!(object instanceof Parametro)) {
            return false;
        }
        Parametro other = (Parametro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entidades.Parametro[ id=" + id + " ]";
    }
    
}
