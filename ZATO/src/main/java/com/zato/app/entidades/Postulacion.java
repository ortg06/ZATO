package com.zato.app.entidades;
// Generated 18/05/2019 06:12:05 PM by Hibernate Tools 4.3.1


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
 * Postulacion generated by hbm2java
 */
@Entity
@Table(name="POSTULACION"
)
public class Postulacion  implements java.io.Serializable {


     private BigDecimal pkPostulacion;
     private Cv cv;
     private Oferta oferta;
     private byte porcentajeAcoplamiento;

    public Postulacion() {
    }

    public Postulacion(BigDecimal pkPostulacion, Cv cv, Oferta oferta, byte porcentajeAcoplamiento) {
       this.pkPostulacion = pkPostulacion;
       this.cv = cv;
       this.oferta = oferta;
       this.porcentajeAcoplamiento = porcentajeAcoplamiento;
    }
   
     @Id 

     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_INCREMENT")    
     @SequenceGenerator(sequenceName = "SEQUENCE_POSTULACION", allocationSize = 1, name = "SEQUENCE_INCREMENT")    
    @Column(name="PK_POSTULACION", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getPkPostulacion() {
        return this.pkPostulacion;
    }
    
    public void setPkPostulacion(BigDecimal pkPostulacion) {
        this.pkPostulacion = pkPostulacion;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PK_CV", nullable=false)
    public Cv getCv() {
        return this.cv;
    }
    
    public void setCv(Cv cv) {
        this.cv = cv;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PK_OFERTA", nullable=false)
    public Oferta getOferta() {
        return this.oferta;
    }
    
    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    
    @Column(name="PORCENTAJE_ACOPLAMIENTO", nullable=false, precision=2, scale=0)
    public byte getPorcentajeAcoplamiento() {
        return this.porcentajeAcoplamiento;
    }
    
    public void setPorcentajeAcoplamiento(byte porcentajeAcoplamiento) {
        this.porcentajeAcoplamiento = porcentajeAcoplamiento;
    }




}


