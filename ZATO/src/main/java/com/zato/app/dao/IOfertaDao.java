package com.zato.app.dao;
import java.math.BigDecimal;

import com.zato.app.entidades.Oferta;

import org.springframework.data.repository.CrudRepository;
public interface IOfertaDao extends CrudRepository<Oferta,BigDecimal>{

    
}