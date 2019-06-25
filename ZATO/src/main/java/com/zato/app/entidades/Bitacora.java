/*	
 * To change this license header, choose License Headers in Project Properties.	
 * To change this template file, choose Tools | Templates	
 * and open the template in the editor.	
 */	
package com.zato.app.entidades;	

 import java.math.BigDecimal;	
import javax.persistence.Entity;	
import javax.persistence.Id;	
import javax.persistence.Table;	
import java.util.Date;	
import javax.persistence.Column;	
import javax.persistence.GeneratedValue;	
import javax.persistence.GenerationType;	
import javax.persistence.SequenceGenerator;	
import javax.persistence.Temporal;	
import javax.persistence.TemporalType;	
import org.springframework.format.annotation.DateTimeFormat;	
/**	
 *	
 * @author Dell	
 */	

 @Entity	
@Table(name="BITACORA"	
)	
public class Bitacora implements java.io.Serializable {	
    private static final long serialVersionUID = 1L;	
    private BigDecimal pkBitacora;	
    private String usuario;	
    private Date fechaModificacion;	
    private String tabla;	
    private String operacion;	
    private String valorAnterior;	
    private String valorNuevo;	
    private BigDecimal pkAlterado;	

     public Bitacora(){	

     }	

     public Bitacora(BigDecimal pkBitacora, String usuario, Date fechaModificacion, String tabla, String operacion, String valorAnterior, String valorNuevo, BigDecimal pkAlterado) {	
        this.pkBitacora = pkBitacora;	
        this.usuario = usuario;	
        this.fechaModificacion = fechaModificacion;	
        this.tabla = tabla;	
        this.operacion = operacion;	
        this.valorAnterior = valorAnterior;	
        this.valorNuevo = valorNuevo;	
        this.pkAlterado = pkAlterado;	
    }	


     @Id	
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_INCREMENT")    	
    @SequenceGenerator(sequenceName = "SEQUENCE_BITACORA", allocationSize = 1, name = "SEQUENCE_INCREMENT")	
    @Column(name="PK_BITACORA", unique=true, nullable=false, precision=22, scale=0)	
    public BigDecimal getPkBitacora() {	
        return pkBitacora;	
    }	

     public void setPkBitacora(BigDecimal pkBitacora) {	
        this.pkBitacora = pkBitacora;	
    }	
   @Column(name="USUARIO", nullable=false, length=50)	
    public String getUsuario() {	
        return usuario;	
    }	

     public void setUsuario(String usuario) {	
        this.usuario = usuario;	
    }	

     @Temporal(TemporalType.DATE)	
    @DateTimeFormat(pattern = "yyyy-MM-dd")	
    @Column(name="FECHA_MODIFICACION", nullable=false, length=7)	
    public Date getFechaModificacion() {	
        return fechaModificacion;	
    }	

     public void setFechaModificacion(Date fechaModificacion) {	
        this.fechaModificacion = fechaModificacion;	
    }	
   @Column(name="TABLA", nullable=false, length=50)	
    public String getTabla() {	
        return tabla;	
    }	

     public void setTabla(String tabla) {	
        this.tabla = tabla;	
    }	
   @Column(name="OPERACION", nullable=false, length=50)	
    public String getOperacion() {	
        return operacion;	
    }	

     public void setOperacion(String operacion) {	
        this.operacion = operacion;	
    }	
   @Column(name="VALOR_ANTERIOR", nullable=true, length=50)	
    public String getValorAnterior() {	
        return valorAnterior;	
    }	

     public void setValorAnterior(String valorAnterior) {	
        this.valorAnterior = valorAnterior;	
    }	
   @Column(name="VALOR_NUEVO", nullable=true, length=50)	
    public String getValorNuevo() {	
        return valorNuevo;	
    }	

     public void setValorNuevo(String valorNuevo) {	
        this.valorNuevo = valorNuevo;	
    }	
   @Column(name="PK_ALTERADO", nullable=false)	
    public BigDecimal getPkAlterado() {	
        return pkAlterado;	
    }	

     public void setPkAlterado(BigDecimal pkAlterado) {	
        this.pkAlterado = pkAlterado;	
    }	



 } 