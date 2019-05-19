/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.Servicios;

import java.math.BigDecimal;
import java.util.List;

import com.zato.app.entidades.Pais;

/**
 *
 * @author Alex
 */
public interface IPaisService {
    
    public List<Pais> findAll();
    public void save(Pais pais);
    public Pais findOne (BigDecimal id);
    public void delete(BigDecimal id);
    
}
