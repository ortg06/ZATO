package com.zato.app.entidades;
// Generated 12/06/2019 08:39:08 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Oferta generated by hbm2java
 */
@Entity
@Table(name="OFERTA"
)
public class Oferta  implements java.io.Serializable {


     private static final long serialVersionUID = 1L;
    private BigDecimal pkOferta;
     private CatalogoPuesto catalogoPuesto;
     private Empresa empresa;
     private Municipio municipio;
     private String descripcionOferta;
     private Double salarioMinOferta;
     private Double salarioMaxOferta;
     private Date fechaInicioOferta;
     private Date fechaFinOferta;
     private String estado;
     private Set<AptitudOferta> aptitudOfertas = new HashSet<AptitudOferta>(0);
     private Set<HabilidadOferta> habilidadOfertas = new HashSet<HabilidadOferta>(0);
     private Set<ConocimientoAcademicos> conocimientoAcademicoses = new HashSet<ConocimientoAcademicos>(0);
     private Set<HabilidadLinguisicaOferta> habilidadLinguisicaOfertas = new HashSet<HabilidadLinguisicaOferta>(0);
     private Set<LicenciaOferta> licenciaOfertas = new HashSet<LicenciaOferta>(0);
     private Set<Postulacion> postulacions = new HashSet<Postulacion>(0);
     private Set<PruebaOferta> pruebaOfertas = new HashSet<PruebaOferta>(0);

    public Oferta() {
    }

	
    public Oferta(BigDecimal pkOferta, CatalogoPuesto catalogoPuesto, Empresa empresa, String descripcionOferta, Date fechaInicioOferta, Date fechaFinOferta, String estado) {
        this.pkOferta = pkOferta;
        this.catalogoPuesto = catalogoPuesto;
        this.empresa = empresa;
        this.descripcionOferta = descripcionOferta;
        this.fechaInicioOferta = fechaInicioOferta;
        this.fechaFinOferta = fechaFinOferta;
        this.estado = estado;
    }
    public Oferta(BigDecimal pkOferta, CatalogoPuesto catalogoPuesto, Empresa empresa, Municipio municipio, String descripcionOferta, Double salarioMinOferta, Double salarioMaxOferta, Date fechaInicioOferta, Date fechaFinOferta, String estado, Set<AptitudOferta> aptitudOfertas, Set<HabilidadOferta> habilidadOfertas, Set<ConocimientoAcademicos> conocimientoAcademicoses, Set<HabilidadLinguisicaOferta> habilidadLinguisicaOfertas, Set<LicenciaOferta> licenciaOfertas, Set<Postulacion> postulacions, Set<PruebaOferta> pruebaOfertas) {
       this.pkOferta = pkOferta;
       this.catalogoPuesto = catalogoPuesto;
       this.empresa = empresa;
       this.municipio = municipio;
       this.descripcionOferta = descripcionOferta;
       this.salarioMinOferta = salarioMinOferta;
       this.salarioMaxOferta = salarioMaxOferta;
       this.fechaInicioOferta = fechaInicioOferta;
       this.fechaFinOferta = fechaFinOferta;
       this.estado = estado;
       this.aptitudOfertas = aptitudOfertas;
       this.habilidadOfertas = habilidadOfertas;
       this.conocimientoAcademicoses = conocimientoAcademicoses;
       this.habilidadLinguisicaOfertas = habilidadLinguisicaOfertas;
       this.licenciaOfertas = licenciaOfertas;
       this.postulacions = postulacions;
       this.pruebaOfertas = pruebaOfertas;
    }
   
     @Id 

     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_INCREMENT")    
     @SequenceGenerator(sequenceName = "SEQUENCE_OFERTA", allocationSize = 1, name = "SEQUENCE_INCREMENT")
    @Column(name="PK_OFERTA", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getPkOferta() {
        return this.pkOferta;
    }
    
    public void setPkOferta(BigDecimal pkOferta) {
        this.pkOferta = pkOferta;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PK_CATALOGO_PUESTO", nullable=false)
    public CatalogoPuesto getCatalogoPuesto() {
        return this.catalogoPuesto;
    }
    
    public void setCatalogoPuesto(CatalogoPuesto catalogoPuesto) {
        this.catalogoPuesto = catalogoPuesto;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PK_EMPRESA", nullable=false)
    public Empresa getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PK_MUNICIPIO")
    public Municipio getMunicipio() {
        return this.municipio;
    }
    
    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    
    @Column(name="DESCRIPCION_OFERTA", nullable=false, length=250)
    public String getDescripcionOferta() {
        return this.descripcionOferta;
    }
    
    public void setDescripcionOferta(String descripcionOferta) {
        this.descripcionOferta = descripcionOferta;
    }

    
    @Column(name="SALARIO_MIN_OFERTA", precision=6, scale=0)
    public Double getSalarioMinOferta() {
        return this.salarioMinOferta;
    }
    
    public void setSalarioMinOferta(Double salarioMinOferta) {
        this.salarioMinOferta = salarioMinOferta;
    }

    
    @Column(name="SALARIO_MAX_OFERTA", precision=6, scale=0)
    public Double getSalarioMaxOferta() {
        return this.salarioMaxOferta;
    }
    
    public void setSalarioMaxOferta(Double salarioMaxOferta) {
        this.salarioMaxOferta = salarioMaxOferta;
    }

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="FECHA_INICIO_OFERTA", nullable=false, length=7)
    public Date getFechaInicioOferta() {
        return this.fechaInicioOferta;
    }
    
    public void setFechaInicioOferta(Date fechaInicioOferta) {
        this.fechaInicioOferta = fechaInicioOferta;
    }

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="FECHA_FIN_OFERTA", nullable=false, length=7)
    public Date getFechaFinOferta() {
        return this.fechaFinOferta;
    }
    
    public void setFechaFinOferta(Date fechaFinOferta) {
        this.fechaFinOferta = fechaFinOferta;
    }

    
    @Column(name="ESTADO", nullable=false, length=50)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oferta")
    public Set<AptitudOferta> getAptitudOfertas() {
        return this.aptitudOfertas;
    }
    
    public void setAptitudOfertas(Set<AptitudOferta> aptitudOfertas) {
        this.aptitudOfertas = aptitudOfertas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oferta")
    public Set<HabilidadOferta> getHabilidadOfertas() {
        return this.habilidadOfertas;
    }
    
    public void setHabilidadOfertas(Set<HabilidadOferta> habilidadOfertas) {
        this.habilidadOfertas = habilidadOfertas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oferta")
    public Set<ConocimientoAcademicos> getConocimientoAcademicoses() {
        return this.conocimientoAcademicoses;
    }
    
    public void setConocimientoAcademicoses(Set<ConocimientoAcademicos> conocimientoAcademicoses) {
        this.conocimientoAcademicoses = conocimientoAcademicoses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oferta")
    public Set<HabilidadLinguisicaOferta> getHabilidadLinguisicaOfertas() {
        return this.habilidadLinguisicaOfertas;
    }
    
    public void setHabilidadLinguisicaOfertas(Set<HabilidadLinguisicaOferta> habilidadLinguisicaOfertas) {
        this.habilidadLinguisicaOfertas = habilidadLinguisicaOfertas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oferta")
    public Set<LicenciaOferta> getLicenciaOfertas() {
        return this.licenciaOfertas;
    }
    
    public void setLicenciaOfertas(Set<LicenciaOferta> licenciaOfertas) {
        this.licenciaOfertas = licenciaOfertas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oferta")
    public Set<Postulacion> getPostulacions() {
        return this.postulacions;
    }
    
    public void setPostulacions(Set<Postulacion> postulacions) {
        this.postulacions = postulacions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oferta")
    public Set<PruebaOferta> getPruebaOfertas() {
        return this.pruebaOfertas;
    }
    
    public void setPruebaOfertas(Set<PruebaOferta> pruebaOfertas) {
        this.pruebaOfertas = pruebaOfertas;
    }




}


