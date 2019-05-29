/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.dao;

import com.zato.app.entidades.CatalogoPuesto;
import java.math.BigDecimal;
import org.springframework.data.repository.CrudRepository;


public interface IPuestosDao extends CrudRepository<CatalogoPuesto, BigDecimal> {
    
}
