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

/**
 * Evento generated by hbm2java
 */
@Entity
@Table(name="EVENTO"
)
public class Evento  implements java.io.Serializable {


     private BigDecimal pkEvento;
     private Cv cv;
     private Pais pais;
     private String nombreEvento;
     private String descripcionEvento;
     private String lugarEvento;
     private String anfitrionEvento;
     private Date fechaEvento;

    public Evento() {
    }

    public Evento(BigDecimal pkEvento, Cv cv, Pais pais, String nombreEvento, String descripcionEvento, String lugarEvento, String anfitrionEvento, Date fechaEvento) {
       this.pkEvento = pkEvento;
       this.cv = cv;
       this.pais = pais;
       this.nombreEvento = nombreEvento;
       this.descripcionEvento = descripcionEvento;
       this.lugarEvento = lugarEvento;
       this.anfitrionEvento = anfitrionEvento;
       this.fechaEvento = fechaEvento;
    }
   
     @Id 

     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_INCREMENT")    	
     @SequenceGenerator(sequenceName = "SEQUENCE_EVENTO", allocationSize = 1, name = "SEQUENCE_INCREMENT")
    @Column(name="PK_EVENTO", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getPkEvento() {
        return this.pkEvento;
    }
    
    public void setPkEvento(BigDecimal pkEvento) {
        this.pkEvento = pkEvento;
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
    @JoinColumn(name="PK_PAIS", nullable=false)
    public Pais getPais() {
        return this.pais;
    }
    
    public void setPais(Pais pais) {
        this.pais = pais;
    }

    
    @Column(name="NOMBRE_EVENTO", nullable=false, length=250)
    public String getNombreEvento() {
        return this.nombreEvento;
    }
    
    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    
    @Column(name="DESCRIPCION_EVENTO", nullable=false, length=450)
    public String getDescripcionEvento() {
        return this.descripcionEvento;
    }
    
    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }

    
    @Column(name="LUGAR_EVENTO", nullable=false, length=150)
    public String getLugarEvento() {
        return this.lugarEvento;
    }
    
    public void setLugarEvento(String lugarEvento) {
        this.lugarEvento = lugarEvento;
    }

    
    @Column(name="ANFITRION_EVENTO", nullable=false, length=100)
    public String getAnfitrionEvento() {
        return this.anfitrionEvento;
    }
    
    public void setAnfitrionEvento(String anfitrionEvento) {
        this.anfitrionEvento = anfitrionEvento;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_EVENTO", nullable=false, length=7)
    public Date getFechaEvento() {
        return this.fechaEvento;
    }
    
    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }




}


