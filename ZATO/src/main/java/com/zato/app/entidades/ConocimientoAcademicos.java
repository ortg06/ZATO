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
 * ConocimientoAcademicos generated by hbm2java
 */
@Entity
@Table(name="CONOCIMIENTO_ACADEMICOS"
)
public class ConocimientoAcademicos  implements java.io.Serializable {


     private BigDecimal pkConocimientoAcademico;
     private CatalogoGradoAcademico catalogoGradoAcademico;
     private Oferta oferta;

    public ConocimientoAcademicos() {
    }

    public ConocimientoAcademicos(BigDecimal pkConocimientoAcademico, CatalogoGradoAcademico catalogoGradoAcademico, Oferta oferta) {
       this.pkConocimientoAcademico = pkConocimientoAcademico;
       this.catalogoGradoAcademico = catalogoGradoAcademico;
       this.oferta = oferta;
    }
   
     @Id 

     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_INCREMENT")    
     @SequenceGenerator(sequenceName = "SEQUENCE_CANDIDATO", allocationSize = 1, name = "SEQUENCE_INCREMENT")    
    @Column(name="PK_CONOCIMIENTO_ACADEMICO", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getPkConocimientoAcademico() {
        return this.pkConocimientoAcademico;
    }
    
    public void setPkConocimientoAcademico(BigDecimal pkConocimientoAcademico) {
        this.pkConocimientoAcademico = pkConocimientoAcademico;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PK_GRADO_ACADEMICO", nullable=false)
    public CatalogoGradoAcademico getCatalogoGradoAcademico() {
        return this.catalogoGradoAcademico;
    }
    
    public void setCatalogoGradoAcademico(CatalogoGradoAcademico catalogoGradoAcademico) {
        this.catalogoGradoAcademico = catalogoGradoAcademico;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PK_OFERTA", nullable=false)
    public Oferta getOferta() {
        return this.oferta;
    }
    
    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }




}


