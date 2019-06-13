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
 * CatalogoTipoEmpresa generated by hbm2java
 */
@Entity
@Table(name="CATALOGO_TIPO_EMPRESA"
)
public class CatalogoTipoEmpresa  implements java.io.Serializable {


     private BigDecimal pkTipoEmpresa;
     private String nombreTipoEmpresa;
     private Set<Empresa> empresas = new HashSet<Empresa>(0);

    public CatalogoTipoEmpresa() {
    }

	
    public CatalogoTipoEmpresa(BigDecimal pkTipoEmpresa, String nombreTipoEmpresa) {
        this.pkTipoEmpresa = pkTipoEmpresa;
        this.nombreTipoEmpresa = nombreTipoEmpresa;
    }
    public CatalogoTipoEmpresa(BigDecimal pkTipoEmpresa, String nombreTipoEmpresa, Set<Empresa> empresas) {
       this.pkTipoEmpresa = pkTipoEmpresa;
       this.nombreTipoEmpresa = nombreTipoEmpresa;
       this.empresas = empresas;
    }
   
     @Id 

     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_INCREMENT")    
     @SequenceGenerator(sequenceName = "SEQUENCE_TIPOEMPRESA", allocationSize = 1, name = "SEQUENCE_INCREMENT")
    @Column(name="PK_TIPO_EMPRESA", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getPkTipoEmpresa() {
        return this.pkTipoEmpresa;
    }
    
    public void setPkTipoEmpresa(BigDecimal pkTipoEmpresa) {
        this.pkTipoEmpresa = pkTipoEmpresa;
    }

    
    @Column(name="NOMBRE_TIPO_EMPRESA", nullable=false, length=100)
    public String getNombreTipoEmpresa() {
        return this.nombreTipoEmpresa;
    }
    
    public void setNombreTipoEmpresa(String nombreTipoEmpresa) {
        this.nombreTipoEmpresa = nombreTipoEmpresa;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catalogoTipoEmpresa")
    public Set<Empresa> getEmpresas() {
        return this.empresas;
    }
    
    public void setEmpresas(Set<Empresa> empresas) {
        this.empresas = empresas;
    }




}


