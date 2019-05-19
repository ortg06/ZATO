
package com.zato.app.dao;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;

import com.zato.app.entidades.CatalogoPonderacion;

/**
 *
 * @author Alex
 */

 public interface ICatalogoPonderacionDao extends CrudRepository<CatalogoPonderacion, BigDecimal>
 {

 }