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
 * Departamento generated by hbm2java
 */
@Entity
@Table(name="DEPARTAMENTO"
)
public class Departamento  implements java.io.Serializable {


     private BigDecimal pkDepartamento;
     private Pais pais;
     private String nombreDepartamento;
     private Set<Municipio> municipios = new HashSet<Municipio>(0);

    public Departamento() {
    }

	
    public Departamento(BigDecimal pkDepartamento, String nombreDepartamento) {
        this.pkDepartamento = pkDepartamento;
        this.nombreDepartamento = nombreDepartamento;
    }
    public Departamento(BigDecimal pkDepartamento, Pais pais, String nombreDepartamento, Set<Municipio> municipios) {
       this.pkDepartamento = pkDepartamento;
       this.pais = pais;
       this.nombreDepartamento = nombreDepartamento;
       this.municipios = municipios;
    }
   
     @Id 

     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_INCREMENT")    
     @SequenceGenerator(sequenceName = "SEQUENCE_DEPARTAMENTO", allocationSize = 1, name = "SEQUENCE_INCREMENT") 
    @Column(name="PK_DEPARTAMENTO", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getPkDepartamento() {
        return this.pkDepartamento;
    }
    
    public void setPkDepartamento(BigDecimal pkDepartamento) {
        this.pkDepartamento = pkDepartamento;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PK_PAIS")
    public Pais getPais() {
        return this.pais;
    }
    
    public void setPais(Pais pais) {
        this.pais = pais;
    }

    
    @Column(name="NOMBRE_DEPARTAMENTO", nullable=false, length=50)
    public String getNombreDepartamento() {
        return this.nombreDepartamento;
    }
    
    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="departamento")
    public Set<Municipio> getMunicipios() {
        return this.municipios;
    }
    
    public void setMunicipios(Set<Municipio> municipios) {
        this.municipios = municipios;
    }




}


