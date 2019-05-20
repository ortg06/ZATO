package com.zato.app.dao;

import com.zato.app.entidades.CatalogoCategoria;

import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
/**
 *
 * @author Alex
 */
public interface ICategoriaDao extends CrudRepository<CatalogoCategoria, BigDecimal>{
    
  


}
