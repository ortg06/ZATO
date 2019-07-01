/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.dao;

import com.zato.app.entidades.Rol;
import com.zato.app.entidades.RolSubmenu;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IRolSubmenuDao extends CrudRepository<RolSubmenu, BigDecimal> {
    
     @Query("select i from RolSubmenu i where i.rol=:rol")
    public List<RolSubmenu> findRolSubmenubyRol(@Param("rol") Rol rol );
}
