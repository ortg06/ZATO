package com.zato.app.entidades;
// Generated 12/05/2019 05:37:08 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CatalogoPonderacion generated by hbm2java
 */
@Entity
@Table(name="CATALOGO_PONDERACION"
    ,schema="SBTEL"
)
public class CatalogoPonderacion  implements java.io.Serializable {


     private BigDecimal pkCatalogoPonderacion;
     private String etiquetaPonderacion;
     private String descripcionEtiqueta;
     private Set<HabilidadLinguisicaOferta> habilidadLinguisicaOfertas = new HashSet<HabilidadLinguisicaOferta>(0);
     private Set<HabilidadLinguisticaCv> habilidadLinguisticaCvs = new HashSet<HabilidadLinguisticaCv>(0);

    public CatalogoPonderacion() {
    }

	
    public CatalogoPonderacion(BigDecimal pkCatalogoPonderacion, String etiquetaPonderacion, String descripcionEtiqueta) {
        this.pkCatalogoPonderacion = pkCatalogoPonderacion;
        this.etiquetaPonderacion = etiquetaPonderacion;
        this.descripcionEtiqueta = descripcionEtiqueta;
    }
    public CatalogoPonderacion(BigDecimal pkCatalogoPonderacion, String etiquetaPonderacion, String descripcionEtiqueta, Set<HabilidadLinguisicaOferta> habilidadLinguisicaOfertas, Set<HabilidadLinguisticaCv> habilidadLinguisticaCvs) {
       this.pkCatalogoPonderacion = pkCatalogoPonderacion;
       this.etiquetaPonderacion = etiquetaPonderacion;
       this.descripcionEtiqueta = descripcionEtiqueta;
       this.habilidadLinguisicaOfertas = habilidadLinguisicaOfertas;
       this.habilidadLinguisticaCvs = habilidadLinguisticaCvs;
    }
   
     @Id 

    
    @Column(name="PK_CATALOGO_PONDERACION", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getPkCatalogoPonderacion() {
        return this.pkCatalogoPonderacion;
    }
    
    public void setPkCatalogoPonderacion(BigDecimal pkCatalogoPonderacion) {
        this.pkCatalogoPonderacion = pkCatalogoPonderacion;
    }

    
    @Column(name="ETIQUETA_PONDERACION", nullable=false, length=25)
    public String getEtiquetaPonderacion() {
        return this.etiquetaPonderacion;
    }
    
    public void setEtiquetaPonderacion(String etiquetaPonderacion) {
        this.etiquetaPonderacion = etiquetaPonderacion;
    }

    
    @Column(name="DESCRIPCION_ETIQUETA", nullable=false, length=100)
    public String getDescripcionEtiqueta() {
        return this.descripcionEtiqueta;
    }
    
    public void setDescripcionEtiqueta(String descripcionEtiqueta) {
        this.descripcionEtiqueta = descripcionEtiqueta;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catalogoPonderacion")
    public Set<HabilidadLinguisicaOferta> getHabilidadLinguisicaOfertas() {
        return this.habilidadLinguisicaOfertas;
    }
    
    public void setHabilidadLinguisicaOfertas(Set<HabilidadLinguisicaOferta> habilidadLinguisicaOfertas) {
        this.habilidadLinguisicaOfertas = habilidadLinguisicaOfertas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catalogoPonderacion")
    public Set<HabilidadLinguisticaCv> getHabilidadLinguisticaCvs() {
        return this.habilidadLinguisticaCvs;
    }
    
    public void setHabilidadLinguisticaCvs(Set<HabilidadLinguisticaCv> habilidadLinguisticaCvs) {
        this.habilidadLinguisticaCvs = habilidadLinguisticaCvs;
    }




}


