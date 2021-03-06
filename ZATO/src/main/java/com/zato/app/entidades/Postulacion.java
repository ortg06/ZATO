package com.zato.app.entidades;
// Generated 24/06/2019 01:24:18 PM by Hibernate Tools 4.3.1


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
     private Double porcentajeAcoplamiento;
     private Date fechaPostulacion;
     private String estado;
     private Set<Resultado> resultados = new HashSet<Resultado>(0);

    public Postulacion() {
    }

	
    public Postulacion(BigDecimal pkPostulacion, Cv cv, Oferta oferta, Date fechaPostulacion, String estado) {
        this.pkPostulacion = pkPostulacion;
        this.cv = cv;
        this.oferta = oferta;
        this.fechaPostulacion = fechaPostulacion;
        this.estado = estado;
    }
    public Postulacion(BigDecimal pkPostulacion, Cv cv, Oferta oferta, Double porcentajeAcoplamiento, Date fechaPostulacion, String estado, Set<Resultado> resultados) {
       this.pkPostulacion = pkPostulacion;
       this.cv = cv;
       this.oferta = oferta;
       this.porcentajeAcoplamiento = porcentajeAcoplamiento;
       this.fechaPostulacion = fechaPostulacion;
       this.estado = estado;
       this.resultados = resultados;
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

    
    @Column(name="PORCENTAJE_ACOPLAMIENTO", precision=2, scale=0)
    public Double getPorcentajeAcoplamiento() {
        return this.porcentajeAcoplamiento;
    }
    
    public void setPorcentajeAcoplamiento(Double porcentajeAcoplamiento) {
        this.porcentajeAcoplamiento = porcentajeAcoplamiento;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_POSTULACION", nullable=false, length=7)
    public Date getFechaPostulacion() {
        return this.fechaPostulacion;
    }
    
    public void setFechaPostulacion(Date fechaPostulacion) {
        this.fechaPostulacion = fechaPostulacion;
    }

    
    @Column(name="ESTADO", nullable=false, length=50)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="postulacion")
    public Set<Resultado> getResultados() {
        return this.resultados;
    }
    
    public void setResultados(Set<Resultado> resultados) {
        this.resultados = resultados;
    }




}


