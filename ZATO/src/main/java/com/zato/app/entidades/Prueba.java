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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Prueba generated by hbm2java
 */
@Entity
@Table(name="PRUEBA"
)
public class Prueba  implements java.io.Serializable {


     private static final long serialVersionUID = 1L;
    private BigDecimal pkPrueba;
     private CatalogoTipoPrueba catalogoTipoPrueba;
     private String nombrePrueba;
     private Set<Resultado> resultados = new HashSet<Resultado>(0);
     private Set<PruebaOferta> pruebaOfertas = new HashSet<PruebaOferta>(0);
     private Set<ItemPrueba> itemPruebas = new HashSet<ItemPrueba>(0);

    public Prueba() {
    }

	
    public Prueba(BigDecimal pkPrueba, CatalogoTipoPrueba catalogoTipoPrueba, String nombrePrueba) {
        this.pkPrueba = pkPrueba;
        this.catalogoTipoPrueba = catalogoTipoPrueba;
        this.nombrePrueba = nombrePrueba;
    }
    public Prueba(BigDecimal pkPrueba, CatalogoTipoPrueba catalogoTipoPrueba, String nombrePrueba, Set<Resultado> resultados, Set<PruebaOferta> pruebaOfertas, Set<ItemPrueba> itemPruebas) {
       this.pkPrueba = pkPrueba;
       this.catalogoTipoPrueba = catalogoTipoPrueba;
       this.nombrePrueba = nombrePrueba;
       this.resultados = resultados;
       this.pruebaOfertas = pruebaOfertas;
       this.itemPruebas = itemPruebas;
    }
   
     @Id 

     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_INCREMENT38")    
     @SequenceGenerator(sequenceName = "SEQUENCE_PRUEBA", allocationSize = 1, name = "SEQUENCE_INCREMENT38") 
    @Column(name="PK_PRUEBA", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getPkPrueba() {
        return this.pkPrueba;
    }
    
    public void setPkPrueba(BigDecimal pkPrueba) {
        this.pkPrueba = pkPrueba;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PK_CAT_TIPO_PRUEBA", nullable=false)
    public CatalogoTipoPrueba getCatalogoTipoPrueba() {
        return this.catalogoTipoPrueba;
    }
    
    public void setCatalogoTipoPrueba(CatalogoTipoPrueba catalogoTipoPrueba) {
        this.catalogoTipoPrueba = catalogoTipoPrueba;
    }

    
    @Column(name="NOMBRE_PRUEBA", nullable=false, length=100)
    public String getNombrePrueba() {
        return this.nombrePrueba;
    }
    
    public void setNombrePrueba(String nombrePrueba) {
        this.nombrePrueba = nombrePrueba;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="prueba")
    public Set<Resultado> getResultados() {
        return this.resultados;
    }
    
    public void setResultados(Set<Resultado> resultados) {
        this.resultados = resultados;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="prueba")
    public Set<PruebaOferta> getPruebaOfertas() {
        return this.pruebaOfertas;
    }
    
    public void setPruebaOfertas(Set<PruebaOferta> pruebaOfertas) {
        this.pruebaOfertas = pruebaOfertas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="prueba")
    public Set<ItemPrueba> getItemPruebas() {
        return this.itemPruebas;
    }
    
    public void setItemPruebas(Set<ItemPrueba> itemPruebas) {
        this.itemPruebas = itemPruebas;
    }




}


