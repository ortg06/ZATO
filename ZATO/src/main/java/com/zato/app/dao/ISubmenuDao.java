/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.dao;

import com.zato.app.entidades.Submenu;
import java.math.BigDecimal;
import org.springframework.data.repository.CrudRepository;

public interface ISubmenuDao extends CrudRepository<Submenu, BigDecimal>{
    
}
