/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.dao;

import com.zato.app.entidades.Empresa;
import com.zato.app.entidades.Oferta;
import com.zato.app.entidades.Prueba;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ecampos
 */
public interface IPruebaDao extends CrudRepository<Prueba,BigDecimal>{
     @Procedure(procedureName = "insertarpruebaoferta")
    void insertPruebaOferta( @Param("idprueba") BigDecimal a, @Param("idoferta")BigDecimal b);

    @Query("select i from Prueba i where i.empresa=:empresa")
    public List<Prueba> findPruebaByEmpresa(@Param("empresa") Empresa empresa);
}
