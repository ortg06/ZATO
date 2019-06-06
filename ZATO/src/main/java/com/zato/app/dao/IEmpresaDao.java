/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.dao;

import com.zato.app.entidades.Empresa;
import java.math.BigDecimal;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ecampos
 */
public interface IEmpresaDao extends CrudRepository<Empresa,BigDecimal>{
     @Transactional
    @Procedure(procedureName = "actualizarperfilempresa")
    void updatePerfilEmpresa( @Param("idempresa") BigDecimal a, @Param("idperfil")BigDecimal b);
    
}
