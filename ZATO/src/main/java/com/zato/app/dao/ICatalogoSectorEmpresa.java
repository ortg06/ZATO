
package com.zato.app.dao;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;


import com.zato.app.entidades.CatalogoSectorEmpresa;

/**
 *
 * @author Alex
 */

 public interface ICatalogoSectorEmpresa extends CrudRepository<CatalogoSectorEmpresa, BigDecimal>
 {

 }