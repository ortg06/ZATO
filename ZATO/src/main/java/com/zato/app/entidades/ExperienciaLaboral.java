package com.zato.app.entidades;
// Generated 24/06/2019 01:24:18 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * ExperienciaLaboral generated by hbm2java
 */
@Entity
@Table(name="EXPERIENCIA_LABORAL"
)
public class ExperienciaLaboral  implements java.io.Serializable {


     private BigDecimal pkExperienciaLaboral;
     private CatalogoSectorEmpresa catalogoSectorEmpresa;
     private Cv cv;
     private String nombreExpEmpresa;
     private String cargo;
     private Date periodoInicio;
     private Date periodoFin;
     private String descripcionFunciones;
     private String nombreContactoExp;
     private Long telefonoContactoExp;
     private String correoContactoExp;

    public ExperienciaLaboral() {
    }

	
    public ExperienciaLaboral(BigDecimal pkExperienciaLaboral, CatalogoSectorEmpresa catalogoSectorEmpresa, Cv cv, String nombreExpEmpresa, String cargo, Date periodoInicio, String descripcionFunciones) {
        this.pkExperienciaLaboral = pkExperienciaLaboral;
        this.catalogoSectorEmpresa = catalogoSectorEmpresa;
        this.cv = cv;
        this.nombreExpEmpresa = nombreExpEmpresa;
        this.cargo = cargo;
        this.periodoInicio = periodoInicio;
        this.descripcionFunciones = descripcionFunciones;
    }
    public ExperienciaLaboral(BigDecimal pkExperienciaLaboral, CatalogoSectorEmpresa catalogoSectorEmpresa, Cv cv, String nombreExpEmpresa, String cargo, Date periodoInicio, Date periodoFin, String descripcionFunciones, String nombreContactoExp, Long telefonoContactoExp, String correoContactoExp) {
       this.pkExperienciaLaboral = pkExperienciaLaboral;
       this.catalogoSectorEmpresa = catalogoSectorEmpresa;
       this.cv = cv;
       this.nombreExpEmpresa = nombreExpEmpresa;
       this.cargo = cargo;
       this.periodoInicio = periodoInicio;
       this.periodoFin = periodoFin;
       this.descripcionFunciones = descripcionFunciones;
       this.nombreContactoExp = nombreContactoExp;
       this.telefonoContactoExp = telefonoContactoExp;
       this.correoContactoExp = correoContactoExp;
    }
   
     @Id 

     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_INCREMENT")    	
     @SequenceGenerator(sequenceName = "SEQUENCE_EXPERIENCIALABORAL", allocationSize = 1, name = "SEQUENCE_INCREMENT") 
    @Column(name="PK_EXPERIENCIA_LABORAL", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getPkExperienciaLaboral() {
        return this.pkExperienciaLaboral;
    }
    
    public void setPkExperienciaLaboral(BigDecimal pkExperienciaLaboral) {
        this.pkExperienciaLaboral = pkExperienciaLaboral;
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
    @JoinColumn(name="PK_CV", nullable=false)
    public Cv getCv() {
        return this.cv;
    }
    
    public void setCv(Cv cv) {
        this.cv = cv;
    }

    
    @Column(name="NOMBRE_EXP_EMPRESA", nullable=false, length=150)
    public String getNombreExpEmpresa() {
        return this.nombreExpEmpresa;
    }
    
    public void setNombreExpEmpresa(String nombreExpEmpresa) {
        this.nombreExpEmpresa = nombreExpEmpresa;
    }

    
    @Column(name="CARGO", nullable=false, length=100)
    public String getCargo() {
        return this.cargo;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="PERIODO_INICIO", nullable=false, length=7)
    public Date getPeriodoInicio() {
        return this.periodoInicio;
    }
    
    public void setPeriodoInicio(Date periodoInicio) {
        this.periodoInicio = periodoInicio;
    }

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="PERIODO_FIN", length=7)
    public Date getPeriodoFin() {
        return this.periodoFin;
    }
    
    public void setPeriodoFin(Date periodoFin) {
        this.periodoFin = periodoFin;
    }

    
    @Column(name="DESCRIPCION_FUNCIONES", nullable=false, length=1000)
    public String getDescripcionFunciones() {
        return this.descripcionFunciones;
    }
    
    public void setDescripcionFunciones(String descripcionFunciones) {
        this.descripcionFunciones = descripcionFunciones;
    }

    
    @Column(name="NOMBRE_CONTACTO_EXP", length=100)
    public String getNombreContactoExp() {
        return this.nombreContactoExp;
    }
    
    public void setNombreContactoExp(String nombreContactoExp) {
        this.nombreContactoExp = nombreContactoExp;
    }

    
    @Column(name="TELEFONO_CONTACTO_EXP", precision=14, scale=0)
    public Long getTelefonoContactoExp() {
        return this.telefonoContactoExp;
    }
    
    public void setTelefonoContactoExp(Long telefonoContactoExp) {
        this.telefonoContactoExp = telefonoContactoExp;
    }

    
    @Column(name="CORREO_CONTACTO_EXP", length=100)
    public String getCorreoContactoExp() {
        return this.correoContactoExp;
    }
    
    public void setCorreoContactoExp(String correoContactoExp) {
        this.correoContactoExp = correoContactoExp;
    }




}


