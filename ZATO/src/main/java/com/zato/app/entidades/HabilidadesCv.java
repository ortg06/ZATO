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
 * HabilidadesCv generated by hbm2java
 */
@Entity
@Table(name="HABILIDADES_CV"
)
public class HabilidadesCv  implements java.io.Serializable {


     private BigDecimal pkHabilidadesCv;
     private CatalogoHabilidad catalogoHabilidad;
     private Cv cv;

    public HabilidadesCv() {
    }

    public HabilidadesCv(BigDecimal pkHabilidadesCv, CatalogoHabilidad catalogoHabilidad, Cv cv) {
       this.pkHabilidadesCv = pkHabilidadesCv;
       this.catalogoHabilidad = catalogoHabilidad;
       this.cv = cv;
    }
   
     @Id 

     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_INCREMENT")    
     @SequenceGenerator(sequenceName = "SEQUENCE_CANDIDATO", allocationSize = 1, name = "SEQUENCE_INCREMENT")    
    @Column(name="PK_HABILIDADES_CV", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getPkHabilidadesCv() {
        return this.pkHabilidadesCv;
    }
    
    public void setPkHabilidadesCv(BigDecimal pkHabilidadesCv) {
        this.pkHabilidadesCv = pkHabilidadesCv;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PK_HABILIDAD", nullable=false)
    public CatalogoHabilidad getCatalogoHabilidad() {
        return this.catalogoHabilidad;
    }
    
    public void setCatalogoHabilidad(CatalogoHabilidad catalogoHabilidad) {
        this.catalogoHabilidad = catalogoHabilidad;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PK_CV", nullable=false)
    public Cv getCv() {
        return this.cv;
    }
    
    public void setCv(Cv cv) {
        this.cv = cv;
    }




}


