/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.dao;

import com.zato.app.entidades.Municipio;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface IMunicipioDao {
    
    public List<Municipio> findAll();
    public void save(Municipio municipio);
    
}