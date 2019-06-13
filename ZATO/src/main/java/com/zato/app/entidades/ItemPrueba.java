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
 * ItemPrueba generated by hbm2java
 */
@Entity
@Table(name="ITEM_PRUEBA"
)
public class ItemPrueba  implements java.io.Serializable {


     private static final long serialVersionUID = 1L;
    private BigDecimal pkItem;
     private Prueba prueba;
     private String pregunta;
     private Set<Opciones> opcioneses = new HashSet<Opciones>(0);

    public ItemPrueba() {
    }

	
    public ItemPrueba(BigDecimal pkItem, Prueba prueba, String pregunta) {
        this.pkItem = pkItem;
        this.prueba = prueba;
        this.pregunta = pregunta;
    }
    public ItemPrueba(BigDecimal pkItem, Prueba prueba, String pregunta, Set<Opciones> opcioneses) {
       this.pkItem = pkItem;
       this.prueba = prueba;
       this.pregunta = pregunta;
       this.opcioneses = opcioneses;
    }
   
     @Id 

     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_INCREMENT")    
     @SequenceGenerator(sequenceName = "SEQUENCE_ITEMPRUEBA", allocationSize = 1, name = "SEQUENCE_INCREMENT")
    @Column(name="PK_ITEM", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getPkItem() {
        return this.pkItem;
    }
    
    public void setPkItem(BigDecimal pkItem) {
        this.pkItem = pkItem;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PK_PRUEBA", nullable=false)
    public Prueba getPrueba() {
        return this.prueba;
    }
    
    public void setPrueba(Prueba prueba) {
        this.prueba = prueba;
    }

    
    @Column(name="PREGUNTA", nullable=false, length=450)
    public String getPregunta() {
        return this.pregunta;
    }
    
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="itemPrueba")
    public Set<Opciones> getOpcioneses() {
        return this.opcioneses;
    }
    
    public void setOpcioneses(Set<Opciones> opcioneses) {
        this.opcioneses = opcioneses;
    }




}


