package com.zato.app.dao;

import com.zato.app.entidades.Candidato;
import java.math.BigDecimal;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ICandidatoDao extends CrudRepository<Candidato, BigDecimal> {
    

    @Transactional
    @Procedure(procedureName = "actualizarperfilcandidato")
    void updatePerfilCandidato( @Param("idcandidato") BigDecimal a, @Param("idperfil")BigDecimal b);

 
}