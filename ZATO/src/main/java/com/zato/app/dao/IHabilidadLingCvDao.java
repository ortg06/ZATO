/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.dao;

import com.zato.app.entidades.Cv;
import com.zato.app.entidades.HabilidadLinguisticaCv;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository; 
import org.springframework.data.repository.query.Param;

public interface IHabilidadLingCvDao extends CrudRepository<HabilidadLinguisticaCv, BigDecimal>{
    @Query("select i from HabilidadLinguisticaCv i where i.cv=:cv")
    public List<HabilidadLinguisticaCv> findCvbyHabLingCv(@Param("cv") Cv cv);
    
}
