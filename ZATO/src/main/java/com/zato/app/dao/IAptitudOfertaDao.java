package com.zato.app.dao;

import java.math.BigDecimal;
import java.util.List;

import com.zato.app.entidades.AptitudOferta;
import com.zato.app.entidades.Oferta;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IAptitudOfertaDao extends CrudRepository<AptitudOferta, BigDecimal>{
    @Query("select i from AptitudOferta i where i.oferta=:oferta")
    public List<AptitudOferta> findAptitudOfetabyOferta(@Param("oferta") Oferta oferta);
}