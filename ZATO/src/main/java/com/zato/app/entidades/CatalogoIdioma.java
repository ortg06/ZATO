package com.zato.app.entidades;
// Generated 18/05/2019 06:12:05 PM by Hibernate Tools 4.3.1


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
 * CatalogoIdioma generated by hbm2java
 */
@Entity
@Table(name="CATALOGO_IDIOMA"
)
public class CatalogoIdioma  implements java.io.Serializable {


     private BigDecimal pkIdioma;
     private String nombreIdioma;
     private Set<HabilidadLinguisicaOferta> habilidadLinguisicaOfertas = new HashSet<HabilidadLinguisicaOferta>(0);
     private Set<HabilidadLinguisticaCv> habilidadLinguisticaCvs = new HashSet<HabilidadLinguisticaCv>(0);

    public CatalogoIdioma() {
    }

	
    public CatalogoIdioma(BigDecimal pkIdioma, String nombreIdioma) {
        this.pkIdioma = pkIdioma;
        this.nombreIdioma = nombreIdioma;
    }
    public CatalogoIdioma(BigDecimal pkIdioma, String nombreIdioma, Set<HabilidadLinguisicaOferta> habilidadLinguisicaOfertas, Set<HabilidadLinguisticaCv> habilidadLinguisticaCvs) {
       this.pkIdioma = pkIdioma;
       this.nombreIdioma = nombreIdioma;
       this.habilidadLinguisicaOfertas = habilidadLinguisicaOfertas;
       this.habilidadLinguisticaCvs = habilidadLinguisticaCvs;
    }
   
     @Id 

     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIB_CATIDIOMA")    
     @SequenceGenerator(sequenceName = "SEQUENCE_CATALOGOIDIOMA", allocationSize = 1, name = "TIB_CATIDIOMA")  
    @Column(name="PK_IDIOMA", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getPkIdioma() {
        return this.pkIdioma;
    }
    
    public void setPkIdioma(BigDecimal pkIdioma) {
        this.pkIdioma = pkIdioma;
    }

    
    @Column(name="NOMBRE_IDIOMA", nullable=false, length=25)
    public String getNombreIdioma() {
        return this.nombreIdioma;
    }
    
    public void setNombreIdioma(String nombreIdioma) {
        this.nombreIdioma = nombreIdioma;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catalogoIdioma")
    public Set<HabilidadLinguisicaOferta> getHabilidadLinguisicaOfertas() {
        return this.habilidadLinguisicaOfertas;
    }
    
    public void setHabilidadLinguisicaOfertas(Set<HabilidadLinguisicaOferta> habilidadLinguisicaOfertas) {
        this.habilidadLinguisicaOfertas = habilidadLinguisicaOfertas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catalogoIdioma")
    public Set<HabilidadLinguisticaCv> getHabilidadLinguisticaCvs() {
        return this.habilidadLinguisticaCvs;
    }
    
    public void setHabilidadLinguisticaCvs(Set<HabilidadLinguisticaCv> habilidadLinguisticaCvs) {
        this.habilidadLinguisticaCvs = habilidadLinguisticaCvs;
    }




}


