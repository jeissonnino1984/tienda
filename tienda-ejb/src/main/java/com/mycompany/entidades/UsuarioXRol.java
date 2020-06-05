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
import javax.persistence.Query;
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
@Table(name = "USUARIO_X_ROL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioXRol.findAll", query = "SELECT u FROM UsuarioXRol u")
        
    , @NamedQuery(name = "UsuarioXRol.findById", query = "SELECT u FROM UsuarioXRol u WHERE u.id = :id")
    , @NamedQuery(name = "UsuarioXRol.listarClientes", query = "SELECT u FROM UsuarioXRol u WHERE u.rolPk = :rolId")
    , @NamedQuery(name = "UsuarioXRol.findByFechaCrea", query = "SELECT u FROM UsuarioXRol u WHERE u.fechaCrea = :fechaCrea")
    , @NamedQuery(name = "UsuarioXRol.findByUserCrea", query = "SELECT u FROM UsuarioXRol u WHERE u.userCrea = :userCrea")})
public class UsuarioXRol implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(generator = "SEC_USUARIO_X_ROL", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEC_USUARIO_X_ROL", sequenceName = "SEC_USUARIO_X_ROL", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCrea;
    @Column(name = "USER_CREA")
    private Integer userCrea;
    @JoinColumn(name = "ROL_PK", referencedColumnName = "ID")
    @ManyToOne
    private Rol rolPk;
    @JoinColumn(name = "USUARIO_FK", referencedColumnName = "ID")
    @ManyToOne
    private Usuarios usuarioFk;

    public UsuarioXRol() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserCrea() {
        return userCrea;
    }

    public void setUserCrea(Integer userCrea) {
        this.userCrea = userCrea;
    }

   

    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

   

    public Rol getRolPk() {
        return rolPk;
    }

    public void setRolPk(Rol rolPk) {
        this.rolPk = rolPk;
    }

    public Usuarios getUsuarioFk() {
        return usuarioFk;
    }

    public void setUsuarioFk(Usuarios usuarioFk) {
        this.usuarioFk = usuarioFk;
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
        if (!(object instanceof UsuarioXRol)) {
            return false;
        }
        UsuarioXRol other = (UsuarioXRol) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UsuarioXRol{" + "id=" + id + ", fechaCrea=" + fechaCrea + ", userCrea=" + userCrea + ", rolPk=" + rolPk + ", usuarioFk=" + usuarioFk + '}';
    }

    
    
     
    
}
