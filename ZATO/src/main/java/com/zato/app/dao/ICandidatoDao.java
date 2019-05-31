package com.zato.app.dao;

import com.zato.app.entidades.Candidato;
import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

public interface ICandidatoDao extends CrudRepository<Candidato, BigDecimal> {
    
}