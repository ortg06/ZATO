/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.dao;

import com.zato.app.entidades.Pais;

import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;


/**
 *
 * @author Alex
 */
public interface IPaisDao extends CrudRepository<Pais, BigDecimal>{
    
  


}
