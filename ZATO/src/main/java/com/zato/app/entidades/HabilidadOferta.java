package com.zato.app.entidades;
// Generated 18/05/2019 06:12:05 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * HabilidadOferta generated by hbm2java
 */
@Entity
@Table(name="HABILIDAD_OFERTA"
)
public class HabilidadOferta  implements java.io.Serializable {


     private BigDecimal pkHabilidadOferta;
     private CatalogoHabilidad catalogoHabilidad;
     private Oferta oferta;

    public HabilidadOferta() {
    }

    public HabilidadOferta(BigDecimal pkHabilidadOferta, CatalogoHabilidad catalogoHabilidad, Oferta oferta) {
       this.pkHabilidadOferta = pkHabilidadOferta;
       this.catalogoHabilidad = catalogoHabilidad;
       this.oferta = oferta;
    }
   
     @Id 

    
    @Column(name="PK_HABILIDAD_OFERTA", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getPkHabilidadOferta() {
        return this.pkHabilidadOferta;
    }
    
    public void setPkHabilidadOferta(BigDecimal pkHabilidadOferta) {
        this.pkHabilidadOferta = pkHabilidadOferta;
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
    @JoinColumn(name="PK_OFERTA", nullable=false)
    public Oferta getOferta() {
        return this.oferta;
    }
    
    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }




}


