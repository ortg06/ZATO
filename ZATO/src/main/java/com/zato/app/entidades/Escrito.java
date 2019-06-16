package com.zato.app.entidades;
// Generated 12/06/2019 08:39:08 PM by Hibernate Tools 4.3.1


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

/**
 * Escrito generated by hbm2java
 */
@Entity
@Table(name="ESCRITO"
)
public class Escrito  implements java.io.Serializable {


     private static final long serialVersionUID = 1L;
    private BigDecimal pkEscrito;
     private CatalogoEscrito catalogoEscrito;
     private Cv cv;
     private Date fechaPublicacion;
     private String lugarPublicacion;
     private String nombreEditor;
     private String nombreEscrito;

    public Escrito() {
    }

    public Escrito(BigDecimal pkEscrito, CatalogoEscrito catalogoEscrito, Cv cv, Date fechaPublicacion, String lugarPublicacion, String nombreEditor, String nombreEscrito) {
       this.pkEscrito = pkEscrito;
       this.catalogoEscrito = catalogoEscrito;
       this.cv = cv;
       this.fechaPublicacion = fechaPublicacion;
       this.lugarPublicacion = lugarPublicacion;
       this.nombreEditor = nombreEditor;
       this.nombreEscrito = nombreEscrito;
    }
   
     @Id 

     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_INCREMENT20")    
     @SequenceGenerator(sequenceName = "SEQUENCE_ESCRITO", allocationSize = 1, name = "SEQUENCE_INCREMENT20")
    @Column(name="PK_ESCRITO", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getPkEscrito() {
        return this.pkEscrito;
    }
    
    public void setPkEscrito(BigDecimal pkEscrito) {
        this.pkEscrito = pkEscrito;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PK_CATALOGO_ESCRITO", nullable=false)
    public CatalogoEscrito getCatalogoEscrito() {
        return this.catalogoEscrito;
    }
    
    public void setCatalogoEscrito(CatalogoEscrito catalogoEscrito) {
        this.catalogoEscrito = catalogoEscrito;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PK_CV", nullable=false)
    public Cv getCv() {
        return this.cv;
    }
    
    public void setCv(Cv cv) {
        this.cv = cv;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_PUBLICACION", nullable=false, length=7)
    public Date getFechaPublicacion() {
        return this.fechaPublicacion;
    }
    
    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    
    @Column(name="LUGAR_PUBLICACION", nullable=false, length=150)
    public String getLugarPublicacion() {
        return this.lugarPublicacion;
    }
    
    public void setLugarPublicacion(String lugarPublicacion) {
        this.lugarPublicacion = lugarPublicacion;
    }

    
    @Column(name="NOMBRE_EDITOR", nullable=false, length=100)
    public String getNombreEditor() {
        return this.nombreEditor;
    }
    
    public void setNombreEditor(String nombreEditor) {
        this.nombreEditor = nombreEditor;
    }

    
    @Column(name="NOMBRE_ESCRITO", nullable=false, length=150)
    public String getNombreEscrito() {
        return this.nombreEscrito;
    }
    
    public void setNombreEscrito(String nombreEscrito) {
        this.nombreEscrito = nombreEscrito;
    }




}


