/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.dao;




import com.zato.app.entidades.Oferta;
import com.zato.app.entidades.Prueba;
import com.zato.app.entidades.PruebaOferta;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Oscar
 */
public interface IPruebaOfertaDao extends CrudRepository<PruebaOferta,BigDecimal>{
    
    //Query para consultar las pruebas de cada oferta en la tabla PruebaOferta
    @Query("select i from PruebaOferta i where i.oferta=:oferta")
    public List<PruebaOferta> findPruebaOfertabyOferta(@Param("oferta") Oferta oferta );
    
     @Query("select i from PruebaOferta i where i.oferta=:oferta and i.prueba=:prueba")
     public List<PruebaOferta> findPruebaOfertabyPruebaOferta(@Param("oferta") Oferta oferta,@Param("prueba") Prueba prueba );
}
