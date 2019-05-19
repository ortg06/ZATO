/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.dao;

import com.zato.app.entidades.Pais;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.type.TrueFalseType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alex
 */
@Repository
public class PaisDaoImpl implements IPaisDao{

    @PersistenceContext
    private EntityManager em;
    @Override
    @SuppressWarnings("JPQLValidation")
    @Transactional(readOnly=true) //esto sirve para acceder en modo de solo lectura ya que estamos construyendo una consulta
    public List<Pais> findAll() {
     return em.createQuery("from Pais").getResultList();
    }

    @Override
    @Transactional
    public void save(Pais pais) {
        //AQUI SE COMPARA SI EL ID VIENE VACIO O SI NO SE REALIZA LAS COMPARACIONES CON ID TIPO BIGDECIMAL
        if(pais.getPkPais() != null && (pais.getPkPais().compareTo(BigDecimal.ZERO))>0)
        {
            em.merge(pais);
        }
        else
        {
            em.persist(pais);
        }
    }
    

    @Override
    @Transactional(readOnly = true)
    public Pais findOne(BigDecimal id) {
        return em.find(Pais.class, id);
    }

    @Override
    @Transactional
    public void delete(BigDecimal id) {
        Pais pais = findOne(id);
        em.remove(pais);

    }
    
}
