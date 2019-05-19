/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.Servicios;

import java.math.BigDecimal;
import java.util.List;

import com.zato.app.dao.IPaisDao;
import com.zato.app.entidades.Pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alex
 */
@Service
public class PaisServiceImpl implements IPaisService {

    @Autowired
    private IPaisDao paisDao;

    @Override
    @Transactional(readOnly=true) //esto sirve para acceder en modo de solo lectura ya que estamos construyendo una consulta
    public List<Pais> findAll() {
        return (List<Pais>) paisDao.findAll();
    }

    @Override
    @Transactional
    public void save(Pais pais) {
        paisDao.save(pais);
    }

    @Override
    @Transactional(readOnly = true)
    public Pais findOne(BigDecimal id) {
        return paisDao.findOne(id);
    }

    @Override
    @Transactional
    public void delete(BigDecimal id) {
        paisDao.delete(id);
    }
    
}
