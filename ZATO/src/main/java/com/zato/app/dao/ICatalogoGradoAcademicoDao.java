/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.dao;

import java.math.BigDecimal;
import java.util.List;

import com.zato.app.entidades.CatalogoGradoAcademico;
import com.zato.app.entidades.Oferta;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


/**
 *
 * @author Dell
 */
public interface ICatalogoGradoAcademicoDao
extends CrudRepository<CatalogoGradoAcademico, BigDecimal> {

    @Query("select i from CatalogoGradoAcademico i where i.oferta=:oferta")
    public List<CatalogoGradoAcademico> findCatalagoGradoAcademicobyOferta(@Param("oferta") Oferta oferta);
    
}
