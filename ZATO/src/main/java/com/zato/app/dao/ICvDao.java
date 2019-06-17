/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.dao;

import com.zato.app.entidades.Candidato;
import com.zato.app.entidades.Cv;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ICvDao extends CrudRepository<Cv, BigDecimal>{
    @Query("select i from Cv i where i.candidato=:candidato")
    public List<Cv> findCandidatobyCv(@Param("candidato") Candidato candidato);
}
