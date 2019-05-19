/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.dao;

import com.zato.app.entidades.Departamento;
import java.util.List;

/**
 *
 * @author Oscar
 */
public interface IDepartamentoDao {
   
    public List<Departamento> findAll();
    public void save(Departamento departamento);
    
}
