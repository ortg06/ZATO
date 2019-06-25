package com.zato.app.entidades;
// Generated 24/06/2019 01:24:18 PM by Hibernate Tools 4.3.1


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
 * LicenciaOferta generated by hbm2java
 */
@Entity
@Table(name="LICENCIA_OFERTA"
)
public class LicenciaOferta  implements java.io.Serializable {


     private BigDecimal pkLicenciaOferta;
     private CatalogoLicencia catalogoLicencia;
     private Oferta oferta;

    public LicenciaOferta() {
    }

    public LicenciaOferta(BigDecimal pkLicenciaOferta, CatalogoLicencia catalogoLicencia, Oferta oferta) {
       this.pkLicenciaOferta = pkLicenciaOferta;
       this.catalogoLicencia = catalogoLicencia;
       this.oferta = oferta;
    }
   
     @Id 
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_INCREMENT")    	
     @SequenceGenerator(sequenceName = "SEQUENCE_LICENCIACANDIDATO", allocationSize = 1, name = "SEQUENCE_INCREMENT") 
    
    @Column(name="PK_LICENCIA_OFERTA", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getPkLicenciaOferta() {
        return this.pkLicenciaOferta;
    }
    
    public void setPkLicenciaOferta(BigDecimal pkLicenciaOferta) {
        this.pkLicenciaOferta = pkLicenciaOferta;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PK_CATALOGO_LICENCIA", nullable=false)
    public CatalogoLicencia getCatalogoLicencia() {
        return this.catalogoLicencia;
    }
    
    public void setCatalogoLicencia(CatalogoLicencia catalogoLicencia) {
        this.catalogoLicencia = catalogoLicencia;
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


