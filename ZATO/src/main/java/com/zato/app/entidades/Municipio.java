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
 * Municipio generated by hbm2java
 */
@Entity
@Table(name="MUNICIPIO"
)
public class Municipio  implements java.io.Serializable {


     private static final long serialVersionUID = 1L;
    private BigDecimal pkMunicipio;
     private Departamento departamento;
     private String nombreMunicipio;
     private Set<Candidato> candidatos = new HashSet<Candidato>(0);
     private Set<Empresa> empresas = new HashSet<Empresa>(0);
     private Set<Oferta> ofertas = new HashSet<Oferta>(0);

    public Municipio() {
    }

	
    public Municipio(BigDecimal pkMunicipio, String nombreMunicipio) {
        this.pkMunicipio = pkMunicipio;
        this.nombreMunicipio = nombreMunicipio;
    }
    public Municipio(BigDecimal pkMunicipio, Departamento departamento, String nombreMunicipio, Set<Candidato> candidatos, Set<Empresa> empresas, Set<Oferta> ofertas) {
       this.pkMunicipio = pkMunicipio;
       this.departamento = departamento;
       this.nombreMunicipio = nombreMunicipio;
       this.candidatos = candidatos;
       this.empresas = empresas;
       this.ofertas = ofertas;
    }
   
     @Id 

     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_INCREMENT")    
     @SequenceGenerator(sequenceName = "SEQUENCE_MUNICIPIO", allocationSize = 1, name = "SEQUENCE_INCREMENT")
    @Column(name="PK_MUNICIPIO", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getPkMunicipio() {
        return this.pkMunicipio;
    }
    
    public void setPkMunicipio(BigDecimal pkMunicipio) {
        this.pkMunicipio = pkMunicipio;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PK_DEPARTAMENTO")
    public Departamento getDepartamento() {
        return this.departamento;
    }
    
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    
    @Column(name="NOMBRE_MUNICIPIO", nullable=false, length=50)
    public String getNombreMunicipio() {
        return this.nombreMunicipio;
    }
    
    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="municipio")
    public Set<Candidato> getCandidatos() {
        return this.candidatos;
    }
    
    public void setCandidatos(Set<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="municipio")
    public Set<Empresa> getEmpresas() {
        return this.empresas;
    }
    
    public void setEmpresas(Set<Empresa> empresas) {
        this.empresas = empresas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="municipio")
    public Set<Oferta> getOfertas() {
        return this.ofertas;
    }
    
    public void setOfertas(Set<Oferta> ofertas) {
        this.ofertas = ofertas;
    }




}


