package com.zato.app.entidades;
// Generated 24/06/2019 01:24:18 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Empresa generated by hbm2java
 */
@Entity
@Table(name="EMPRESA"
)
public class Empresa  implements java.io.Serializable {


     private BigDecimal pkEmpresa;
     private CatalogoSectorEmpresa catalogoSectorEmpresa;
     private CatalogoTipoEmpresa catalogoTipoEmpresa;
     private Municipio municipio;
     private String nomEmpresa;
     private long nitEmpresa;
     private String direccionEmpresa;
     private String razonSocial;
     private BigDecimal numeroTrabajadores;
     private String descripcionEmpresa;
     private String paginaWeb;
     private Blob logoEmpresa;
     private String nombreContactoEmpresa;
     private String cargoContacto;
     private BigDecimal telefonoContacto;
     private Set<Prueba> pruebas = new HashSet<Prueba>(0);
     private Set<Oferta> ofertas = new HashSet<Oferta>(0);
     private Set<Perfil> perfils = new HashSet<Perfil>(0);

    public Empresa() {
    }

	
    public Empresa(BigDecimal pkEmpresa, CatalogoSectorEmpresa catalogoSectorEmpresa, CatalogoTipoEmpresa catalogoTipoEmpresa, String nomEmpresa, long nitEmpresa, String direccionEmpresa, String razonSocial, String descripcionEmpresa, String nombreContactoEmpresa, BigDecimal telefonoContacto) {
        this.pkEmpresa = pkEmpresa;
        this.catalogoSectorEmpresa = catalogoSectorEmpresa;
        this.catalogoTipoEmpresa = catalogoTipoEmpresa;
        this.nomEmpresa = nomEmpresa;
        this.nitEmpresa = nitEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.razonSocial = razonSocial;
        this.descripcionEmpresa = descripcionEmpresa;
        this.nombreContactoEmpresa = nombreContactoEmpresa;
        this.telefonoContacto = telefonoContacto;
    }
    public Empresa(BigDecimal pkEmpresa, CatalogoSectorEmpresa catalogoSectorEmpresa, CatalogoTipoEmpresa catalogoTipoEmpresa, Municipio municipio, String nomEmpresa, long nitEmpresa, String direccionEmpresa, String razonSocial, BigDecimal numeroTrabajadores, String descripcionEmpresa, String paginaWeb, Blob logoEmpresa, String nombreContactoEmpresa, String cargoContacto, BigDecimal telefonoContacto, Set<Prueba> pruebas, Set<Oferta> ofertas, Set<Perfil> perfils) {
       this.pkEmpresa = pkEmpresa;
       this.catalogoSectorEmpresa = catalogoSectorEmpresa;
       this.catalogoTipoEmpresa = catalogoTipoEmpresa;
       this.municipio = municipio;
       this.nomEmpresa = nomEmpresa;
       this.nitEmpresa = nitEmpresa;
       this.direccionEmpresa = direccionEmpresa;
       this.razonSocial = razonSocial;
       this.numeroTrabajadores = numeroTrabajadores;
       this.descripcionEmpresa = descripcionEmpresa;
       this.paginaWeb = paginaWeb;
       this.logoEmpresa = logoEmpresa;
       this.nombreContactoEmpresa = nombreContactoEmpresa;
       this.cargoContacto = cargoContacto;
       this.telefonoContacto = telefonoContacto;
       this.pruebas = pruebas;
       this.ofertas = ofertas;
       this.perfils = perfils;
    }
   
     @Id 

     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_INCREMENT")    	
     @SequenceGenerator(sequenceName = "SEQUENCE_EMPRESA", allocationSize = 1, name = "SEQUENCE_INCREMENT")
    @Column(name="PK_EMPRESA", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getPkEmpresa() {
        return this.pkEmpresa;
    }
    
    public void setPkEmpresa(BigDecimal pkEmpresa) {
        this.pkEmpresa = pkEmpresa;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PK_SECTOR", nullable=false)
    public CatalogoSectorEmpresa getCatalogoSectorEmpresa() {
        return this.catalogoSectorEmpresa;
    }
    
    public void setCatalogoSectorEmpresa(CatalogoSectorEmpresa catalogoSectorEmpresa) {
        this.catalogoSectorEmpresa = catalogoSectorEmpresa;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PK_TIPO_EMPRESA", nullable=false)
    public CatalogoTipoEmpresa getCatalogoTipoEmpresa() {
        return this.catalogoTipoEmpresa;
    }
    
    public void setCatalogoTipoEmpresa(CatalogoTipoEmpresa catalogoTipoEmpresa) {
        this.catalogoTipoEmpresa = catalogoTipoEmpresa;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PK_MUNICIPIO")
    public Municipio getMunicipio() {
        return this.municipio;
    }
    
    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    
    @Column(name="NOM_EMPRESA", nullable=false, length=100)
    public String getNomEmpresa() {
        return this.nomEmpresa;
    }
    
    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    
    @Column(name="NIT_EMPRESA", nullable=false, precision=14, scale=0)
    public long getNitEmpresa() {
        return this.nitEmpresa;
    }
    
    public void setNitEmpresa(long nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }

    
    @Column(name="DIRECCION_EMPRESA", nullable=false, length=250)
    public String getDireccionEmpresa() {
        return this.direccionEmpresa;
    }
    
    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    
    @Column(name="RAZON_SOCIAL", nullable=false, length=250)
    public String getRazonSocial() {
        return this.razonSocial;
    }
    
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    
    @Column(name="NUMERO_TRABAJADORES", precision=22, scale=0)
    public BigDecimal getNumeroTrabajadores() {
        return this.numeroTrabajadores;
    }
    
    public void setNumeroTrabajadores(BigDecimal numeroTrabajadores) {
        this.numeroTrabajadores = numeroTrabajadores;
    }

    
    @Column(name="DESCRIPCION_EMPRESA", nullable=false, length=250)
    public String getDescripcionEmpresa() {
        return this.descripcionEmpresa;
    }
    
    public void setDescripcionEmpresa(String descripcionEmpresa) {
        this.descripcionEmpresa = descripcionEmpresa;
    }

    
    @Column(name="PAGINA_WEB", length=100)
    public String getPaginaWeb() {
        return this.paginaWeb;
    }
    
    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    
    @Column(name="LOGO_EMPRESA")
    public Blob getLogoEmpresa() {
        return this.logoEmpresa;
    }
    
    public void setLogoEmpresa(Blob logoEmpresa) {
        this.logoEmpresa = logoEmpresa;
    }

    
    @Column(name="NOMBRE_CONTACTO_EMPRESA", nullable=false, length=100)
    public String getNombreContactoEmpresa() {
        return this.nombreContactoEmpresa;
    }
    
    public void setNombreContactoEmpresa(String nombreContactoEmpresa) {
        this.nombreContactoEmpresa = nombreContactoEmpresa;
    }

    
    @Column(name="CARGO_CONTACTO", length=100)
    public String getCargoContacto() {
        return this.cargoContacto;
    }
    
    public void setCargoContacto(String cargoContacto) {
        this.cargoContacto = cargoContacto;
    }

    
    @Column(name="TELEFONO_CONTACTO", nullable=false, precision=25, scale=0)
    public BigDecimal getTelefonoContacto() {
        return this.telefonoContacto;
    }
    
    public void setTelefonoContacto(BigDecimal telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="empresa")
    public Set<Prueba> getPruebas() {
        return this.pruebas;
    }
    
    public void setPruebas(Set<Prueba> pruebas) {
        this.pruebas = pruebas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="empresa")
    public Set<Oferta> getOfertas() {
        return this.ofertas;
    }
    
    public void setOfertas(Set<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="empresa")
    public Set<Perfil> getPerfils() {
        return this.perfils;
    }
    
    public void setPerfils(Set<Perfil> perfils) {
        this.perfils = perfils;
    }




}


