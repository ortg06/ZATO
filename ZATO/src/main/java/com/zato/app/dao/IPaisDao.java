/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.dao;

import com.zato.app.entidades.Pais;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface IPaisDao {
    
    public List<Pais> findAll();
    public void save(Pais pais);
    
}
