/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.Servicios;

import com.zato.app.dao.IDepartamentoDao;
import com.zato.app.dao.IMunicipioDao;
import java.math.BigDecimal;
import java.util.List;

import com.zato.app.dao.IPaisDao;
import com.zato.app.entidades.Departamento;
import com.zato.app.entidades.Municipio;
import com.zato.app.entidades.Pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alex
 */
@Service
public class ServiceImpl implements IService {

    @Autowired
    private IPaisDao paisDao;
    @Autowired
    private IDepartamentoDao departamentoDao;
    @Autowired
    private IMunicipioDao municipioDao;
   

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
    
    
    //Departamentos
    @Override
    @Transactional(readOnly=true)
    public List<Departamento> findAlldep() {
        return (List<Departamento>) departamentoDao.findAll();
    }

    @Override
    @Transactional
    public void saveDepto(Departamento departamento) {
      departamentoDao.save(departamento);
    }
    
    
    //Municipios
    
    @Override
    @Transactional(readOnly=true)
    public List<Municipio> findAllmun() {
       return (List<Municipio>) municipioDao.findAll();
    }

    @Override
    @Transactional
    public void saveMun(Municipio municipio) {
        municipioDao.save(municipio);
    }
    
    
    
}
