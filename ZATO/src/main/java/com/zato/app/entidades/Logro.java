package com.zato.app.entidades;
// Generated 18/05/2019 06:12:05 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Logro generated by hbm2java
 */
@Entity
@Table(name="LOGRO"
)
public class Logro  implements java.io.Serializable {


     private BigDecimal pkLogro;
     private Cv cv;
     private String nombreLogro;
     private Date fechaLogro;
     private String descripcionLogro;

    public Logro() {
    }

    public Logro(BigDecimal pkLogro, Cv cv, String nombreLogro, Date fechaLogro, String descripcionLogro) {
       this.pkLogro = pkLogro;
       this.cv = cv;
       this.nombreLogro = nombreLogro;
       this.fechaLogro = fechaLogro;
       this.descripcionLogro = descripcionLogro;
    }
   
     @Id 

    
    @Column(name="PK_LOGRO", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getPkLogro() {
        return this.pkLogro;
    }
    
    public void setPkLogro(BigDecimal pkLogro) {
        this.pkLogro = pkLogro;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PK_CV", nullable=false)
    public Cv getCv() {
        return this.cv;
    }
    
    public void setCv(Cv cv) {
        this.cv = cv;
    }

    
    @Column(name="NOMBRE_LOGRO", nullable=false, length=250)
    public String getNombreLogro() {
        return this.nombreLogro;
    }
    
    public void setNombreLogro(String nombreLogro) {
        this.nombreLogro = nombreLogro;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_LOGRO", nullable=false, length=7)
    public Date getFechaLogro() {
        return this.fechaLogro;
    }
    
    public void setFechaLogro(Date fechaLogro) {
        this.fechaLogro = fechaLogro;
    }

    
    @Column(name="DESCRIPCION_LOGRO", nullable=false, length=450)
    public String getDescripcionLogro() {
        return this.descripcionLogro;
    }
    
    public void setDescripcionLogro(String descripcionLogro) {
        this.descripcionLogro = descripcionLogro;
    }




}


