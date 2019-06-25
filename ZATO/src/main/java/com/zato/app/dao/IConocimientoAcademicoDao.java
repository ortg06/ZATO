package com.zato.app.dao;

import java.math.BigDecimal;
import java.util.List;

import com.zato.app.entidades.CatalogoGradoAcademico;
import com.zato.app.entidades.ConocimientoAcademicos;
import com.zato.app.entidades.Oferta;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


/**
 *
 * @author Dell
 */
public interface IConocimientoAcademicoDao extends CrudRepository<ConocimientoAcademicos, BigDecimal> {

  
    
}