/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.dao;

import com.zato.app.entidades.Departamento;
import com.zato.app.entidades.Municipio;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Oscar
 */
public interface IDepartamentoDao extends CrudRepository<Departamento, BigDecimal>{
    
    List<Municipio> findByDepartamentoPK(BigDecimal id);
}
