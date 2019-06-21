/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.dao;

import com.zato.app.entidades.Cv;
import com.zato.app.entidades.FormacionAcademica;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository; 
import org.springframework.data.repository.query.Param;


public interface IFormacionAcademicaDao extends CrudRepository<FormacionAcademica, BigDecimal>{
    @Query("select i from FormacionAcademica i where i.cv=:cv")
    public List<FormacionAcademica> findCvbyForAcad(@Param("cv") Cv cv);
    
}
