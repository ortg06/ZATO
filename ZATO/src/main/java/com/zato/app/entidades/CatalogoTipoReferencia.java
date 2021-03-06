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
 * CatalogoTipoReferencia generated by hbm2java
 */
@Entity
@Table(name="CATALOGO_TIPO_REFERENCIA"
)
public class CatalogoTipoReferencia  implements java.io.Serializable {


     private BigDecimal pkTipoReferencia;
     private String tipoReferencia;
     private Set<Referencia> referencias = new HashSet<Referencia>(0);

    public CatalogoTipoReferencia() {
    }

	
    public CatalogoTipoReferencia(BigDecimal pkTipoReferencia, String tipoReferencia) {
        this.pkTipoReferencia = pkTipoReferencia;
        this.tipoReferencia = tipoReferencia;
    }
    public CatalogoTipoReferencia(BigDecimal pkTipoReferencia, String tipoReferencia, Set<Referencia> referencias) {
       this.pkTipoReferencia = pkTipoReferencia;
       this.tipoReferencia = tipoReferencia;
       this.referencias = referencias;
    }
   
     @Id 
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_INCREMENT")    	
     @SequenceGenerator(sequenceName = "SEQUENCE_TIPOREFERENCIA", allocationSize = 1, name = "SEQUENCE_INCREMENT")
    
    @Column(name="PK_TIPO_REFERENCIA", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getPkTipoReferencia() {
        return this.pkTipoReferencia;
    }
    
    public void setPkTipoReferencia(BigDecimal pkTipoReferencia) {
        this.pkTipoReferencia = pkTipoReferencia;
    }

    
    @Column(name="TIPO_REFERENCIA", nullable=false, length=100)
    public String getTipoReferencia() {
        return this.tipoReferencia;
    }
    
    public void setTipoReferencia(String tipoReferencia) {
        this.tipoReferencia = tipoReferencia;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catalogoTipoReferencia")
    public Set<Referencia> getReferencias() {
        return this.referencias;
    }
    
    public void setReferencias(Set<Referencia> referencias) {
        this.referencias = referencias;
    }




}


