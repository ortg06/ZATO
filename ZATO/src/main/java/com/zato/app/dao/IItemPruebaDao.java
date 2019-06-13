/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.dao;

import com.zato.app.entidades.ItemPrueba;
import com.zato.app.entidades.Prueba;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ecampos
 */
public interface IItemPruebaDao extends CrudRepository<ItemPrueba,BigDecimal> {
      
    @Query("select i from ItemPrueba i where i.prueba=:prueba")
    public List<ItemPrueba> findItemPruebabyPrueba(@Param("prueba") Prueba prueba );
}
