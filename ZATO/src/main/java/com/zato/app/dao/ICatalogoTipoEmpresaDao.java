
package com.zato.app.dao;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;


import com.zato.app.entidades.CatalogoTipoEmpresa;

/**
 *
 * @author Alex
 */

 public interface ICatalogoTipoEmpresaDao extends CrudRepository<CatalogoTipoEmpresa, BigDecimal>
 {

 }