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
 * CatalogoLicencia generated by hbm2java
 */
@Entity
@Table(name="CATALOGO_LICENCIA"
    ,schema="SBTEL"
)
public class CatalogoLicencia  implements java.io.Serializable {


     private BigDecimal pkCatalogoLicencia;
     private String nombreTipoLicencia;
     private Set<LicenciaOferta> licenciaOfertas = new HashSet<LicenciaOferta>(0);
     private Set<LicenciaCandidato> licenciaCandidatos = new HashSet<LicenciaCandidato>(0);

    public CatalogoLicencia() {
    }

	
    public CatalogoLicencia(BigDecimal pkCatalogoLicencia, String nombreTipoLicencia) {
        this.pkCatalogoLicencia = pkCatalogoLicencia;
        this.nombreTipoLicencia = nombreTipoLicencia;
    }
    public CatalogoLicencia(BigDecimal pkCatalogoLicencia, String nombreTipoLicencia, Set<LicenciaOferta> licenciaOfertas, Set<LicenciaCandidato> licenciaCandidatos) {
       this.pkCatalogoLicencia = pkCatalogoLicencia;
       this.nombreTipoLicencia = nombreTipoLicencia;
       this.licenciaOfertas = licenciaOfertas;
       this.licenciaCandidatos = licenciaCandidatos;
    }
   
     @Id 

    
    @Column(name="PK_CATALOGO_LICENCIA", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getPkCatalogoLicencia() {
        return this.pkCatalogoLicencia;
    }
    
    public void setPkCatalogoLicencia(BigDecimal pkCatalogoLicencia) {
        this.pkCatalogoLicencia = pkCatalogoLicencia;
    }

    
    @Column(name="NOMBRE_TIPO_LICENCIA", nullable=false, length=50)
    public String getNombreTipoLicencia() {
        return this.nombreTipoLicencia;
    }
    
    public void setNombreTipoLicencia(String nombreTipoLicencia) {
        this.nombreTipoLicencia = nombreTipoLicencia;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catalogoLicencia")
    public Set<LicenciaOferta> getLicenciaOfertas() {
        return this.licenciaOfertas;
    }
    
    public void setLicenciaOfertas(Set<LicenciaOferta> licenciaOfertas) {
        this.licenciaOfertas = licenciaOfertas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catalogoLicencia")
    public Set<LicenciaCandidato> getLicenciaCandidatos() {
        return this.licenciaCandidatos;
    }
    
    public void setLicenciaCandidatos(Set<LicenciaCandidato> licenciaCandidatos) {
        this.licenciaCandidatos = licenciaCandidatos;
    }




}


