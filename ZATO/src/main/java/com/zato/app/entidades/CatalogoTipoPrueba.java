package com.zato.app.entidades;
// Generated 12/06/2019 08:39:08 PM by Hibernate Tools 4.3.1


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
 * CatalogoTipoPrueba generated by hbm2java
 */
@Entity
@Table(name="CATALOGO_TIPO_PRUEBA"
)
public class CatalogoTipoPrueba  implements java.io.Serializable {


     private static final long serialVersionUID = 1L;
    private BigDecimal pkCatTipoPrueba;
     private String nombreTipoPrueba;
     private Set<Prueba> pruebas = new HashSet<Prueba>(0);

    public CatalogoTipoPrueba() {
    }

	
    public CatalogoTipoPrueba(BigDecimal pkCatTipoPrueba, String nombreTipoPrueba) {
        this.pkCatTipoPrueba = pkCatTipoPrueba;
        this.nombreTipoPrueba = nombreTipoPrueba;
    }
    public CatalogoTipoPrueba(BigDecimal pkCatTipoPrueba, String nombreTipoPrueba, Set<Prueba> pruebas) {
       this.pkCatTipoPrueba = pkCatTipoPrueba;
       this.nombreTipoPrueba = nombreTipoPrueba;
       this.pruebas = pruebas;
    }
   
     @Id 

     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_INCREMENT")    
     @SequenceGenerator(sequenceName = "SEQUENCE_TIPOPRUEBA", allocationSize = 1, name = "SEQUENCE_INCREMENT")
    @Column(name="PK_CAT_TIPO_PRUEBA", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getPkCatTipoPrueba() {
        return this.pkCatTipoPrueba;
    }
    
    public void setPkCatTipoPrueba(BigDecimal pkCatTipoPrueba) {
        this.pkCatTipoPrueba = pkCatTipoPrueba;
    }

    
    @Column(name="NOMBRE_TIPO_PRUEBA", nullable=false, length=100)
    public String getNombreTipoPrueba() {
        return this.nombreTipoPrueba;
    }
    
    public void setNombreTipoPrueba(String nombreTipoPrueba) {
        this.nombreTipoPrueba = nombreTipoPrueba;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catalogoTipoPrueba")
    public Set<Prueba> getPruebas() {
        return this.pruebas;
    }
    
    public void setPruebas(Set<Prueba> pruebas) {
        this.pruebas = pruebas;
    }




}


