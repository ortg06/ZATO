package com.zato.app.dao;

import java.math.BigDecimal;
import java.util.List;

import com.zato.app.entidades.Empresa;
import com.zato.app.entidades.Oferta;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
public interface IOfertaDao extends CrudRepository<Oferta,BigDecimal>{

    @Query("select i from Oferta i where i.empresa=:empresa")
    public List<Oferta> findOfertaByEmpresa(@Param("empresa") Empresa empresa);
}