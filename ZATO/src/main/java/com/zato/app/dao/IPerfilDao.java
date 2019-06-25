/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.dao;

import com.zato.app.entidades.Perfil;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface IPerfilDao extends CrudRepository<Perfil, BigDecimal> {
    
     @Query("select p from Perfil p where p.usuario=:user and p.contrasena=:pass")
    public Perfil findPerfilUserPass(@Param("user") String user,@Param("pass") String pass );
}
