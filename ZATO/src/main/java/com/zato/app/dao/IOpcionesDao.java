/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.dao;

import com.zato.app.entidades.ItemPrueba;
import com.zato.app.entidades.Opciones;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ecampos
 */
public interface IOpcionesDao extends CrudRepository<Opciones, BigDecimal> {

    @Query("select i from Opciones i where i.itemPrueba=:itemPrueba")
    public List<Opciones> findOpcionesbyItemPrueba(@Param("itemPrueba") ItemPrueba itemprueba);
}
