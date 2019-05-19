/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.dao;

import com.zato.app.entidades.Departamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Oscar
 */
@Repository
public class DepartamentoDaoImp implements IDepartamentoDao{
     @PersistenceContext
    private EntityManager em;
    @Override
    @SuppressWarnings("JPQLValidation")
    @Transactional(readOnly=true) //esto sirve para acceder en modo de solo lectura ya que estamos construyendo una consulta
    public List<Departamento> findAll(){
     return em.createQuery("from Departamento").getResultList();
    }

    @Override
    @Transactional
    public void save(Departamento departamento) {
        em.persist(departamento);
    }
    
}
