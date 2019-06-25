package com.zato.app.entidades;
// Generated 24/06/2019 01:24:18 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * CatalogoAptitud generated by hbm2java
 */
@Entity
@Table(name="CATALOGO_APTITUD"
)
public class CatalogoAptitud  implements java.io.Serializable {


     private BigDecimal pkCatalogoAptitud;
     private String nombreAptitud;
     private Set<AptitudCv> aptitudCvs = new HashSet<AptitudCv>(0);
     private Set<AptitudOferta> aptitudOfertas = new HashSet<AptitudOferta>(0);

    public CatalogoAptitud() {
    }

	
    public CatalogoAptitud(BigDecimal pkCatalogoAptitud, String nombreAptitud) {
        this.pkCatalogoAptitud = pkCatalogoAptitud;
        this.nombreAptitud = nombreAptitud;
    }
    public CatalogoAptitud(BigDecimal pkCatalogoAptitud, String nombreAptitud, Set<AptitudCv> aptitudCvs, Set<AptitudOferta> aptitudOfertas) {
       this.pkCatalogoAptitud = pkCatalogoAptitud;
       this.nombreAptitud = nombreAptitud;
       this.aptitudCvs = aptitudCvs;
       this.aptitudOfertas = aptitudOfertas;
    }
   
     @Id 

     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_INCREMENT")    	
     @SequenceGenerator(sequenceName = "SEQUENCE_CATALOGOAPTITUD", allocationSize = 1, name = "SEQUENCE_INCREMENT")
    @Column(name="PK_CATALOGO_APTITUD", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getPkCatalogoAptitud() {
        return this.pkCatalogoAptitud;
    }
    
    public void setPkCatalogoAptitud(BigDecimal pkCatalogoAptitud) {
        this.pkCatalogoAptitud = pkCatalogoAptitud;
    }

    
    @Column(name="NOMBRE_APTITUD", nullable=false, length=50)
    public String getNombreAptitud() {
        return this.nombreAptitud;
    }
    
    public void setNombreAptitud(String nombreAptitud) {
        this.nombreAptitud = nombreAptitud;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catalogoAptitud")
    public Set<AptitudCv> getAptitudCvs() {
        return this.aptitudCvs;
    }
    
    public void setAptitudCvs(Set<AptitudCv> aptitudCvs) {
        this.aptitudCvs = aptitudCvs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catalogoAptitud")
    public Set<AptitudOferta> getAptitudOfertas() {
        return this.aptitudOfertas;
    }
    
    public void setAptitudOfertas(Set<AptitudOferta> aptitudOfertas) {
        this.aptitudOfertas = aptitudOfertas;
    }




}


