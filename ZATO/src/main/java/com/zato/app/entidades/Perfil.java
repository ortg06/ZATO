package com.zato.app.entidades;
// Generated 12/06/2019 08:39:08 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Perfil generated by hbm2java
 */
@Entity
@Table(name="PERFIL"
)
public class Perfil  implements java.io.Serializable {


     private static final long serialVersionUID = 1L;
    private BigDecimal pkUsuario;
     private Candidato candidato;
     private Empresa empresa;
     private Rol rol;
     private String usuario;
     private String contrasena;
     private String correoElectronico;
     private BigDecimal tipoPerfil;
     private String estado;

    public Perfil() {
    }

	
    public Perfil(BigDecimal pkUsuario, Rol rol, String usuario, String contrasena, String correoElectronico, BigDecimal tipoPerfil, String estado) {
        this.pkUsuario = pkUsuario;
        this.rol = rol;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.correoElectronico = correoElectronico;
        this.tipoPerfil = tipoPerfil;
        this.estado = estado;
    }
    public Perfil(BigDecimal pkUsuario, Candidato candidato, Empresa empresa, Rol rol, String usuario, String contrasena, String correoElectronico, BigDecimal tipoPerfil, String estado) {
       this.pkUsuario = pkUsuario;
       this.candidato = candidato;
       this.empresa = empresa;
       this.rol = rol;
       this.usuario = usuario;
       this.contrasena = contrasena;
       this.correoElectronico = correoElectronico;
       this.tipoPerfil = tipoPerfil;
       this.estado = estado;
    }
   
     @Id 

     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_INCREMENT36")
     @SequenceGenerator(sequenceName = "SEQUENCE_PERFIL", allocationSize = 1, name = "SEQUENCE_INCREMENT36")
    @Column(name="PK_USUARIO", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getPkUsuario() {
        return this.pkUsuario;
    }
    
    public void setPkUsuario(BigDecimal pkUsuario) {
        this.pkUsuario = pkUsuario;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PK_CANDIDATO")
    public Candidato getCandidato() {
        return this.candidato;
    }
    
    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PK_EMPRESA")
    public Empresa getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PK_ROL", nullable=false)
    public Rol getRol() {
        return this.rol;
    }
    
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    
    @Column(name="USUARIO", nullable=false, length=50)
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    @Column(name="CONTRASENA", nullable=false, length=50)
    public String getContrasena() {
        return this.contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    
    @Column(name="CORREO_ELECTRONICO", nullable=false, length=100)
    public String getCorreoElectronico() {
        return this.correoElectronico;
    }
    
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    
    @Column(name="TIPO_PERFIL", nullable=false, precision=22, scale=0)
    public BigDecimal getTipoPerfil() {
        return this.tipoPerfil;
    }
    
    public void setTipoPerfil(BigDecimal tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    
    @Column(name="ESTADO", nullable=false, length=50)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }




}


