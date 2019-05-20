/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.Servicios;

import com.zato.app.dao.ICatalogoPonderacionDao;
import com.zato.app.dao.ICategoriaDao;
import com.zato.app.dao.IDepartamentoDao;
import com.zato.app.dao.IMunicipioDao;
import java.math.BigDecimal;
import java.util.List;

import com.zato.app.dao.IPaisDao;
import com.zato.app.entidades.CatalogoCategoria;
import com.zato.app.entidades.CatalogoPonderacion;
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
    @Autowired
    private ICatalogoPonderacionDao catalogoPonderacionDao;
    @Autowired
    private ICategoriaDao categoriaDao;
   

    //PAISES
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
    
    @Override
    @Transactional
    public Departamento findOneDepartamento(BigDecimal id){
        return departamentoDao.findOne(id);
    }
    
     @Override
    @Transactional
    public void deleteDepartamento(BigDecimal id){
        departamentoDao.delete(id);
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
    
    @Override
    @Transactional
    public Municipio findOneMunicipio(BigDecimal id){
        return municipioDao.findOne(id);
    }
    
     @Override
    @Transactional
    public void deleteMunicipio(BigDecimal id){
        municipioDao.delete(id);
    }
    
    
    //CATALOGO PONDERACION

    @Override
    @Transactional(readOnly = true)
    public List<CatalogoPonderacion>findAllPonderacion(){

        return (List<CatalogoPonderacion>) catalogoPonderacionDao.findAll();
    }

    @Override
    @Transactional
    public void save(CatalogoPonderacion catalogoPonderacion)
    {
        catalogoPonderacionDao.save(catalogoPonderacion);
    }

    @Override
    @Transactional
    public CatalogoPonderacion findOnePonderacion(BigDecimal id){
        return catalogoPonderacionDao.findOne(id);
    }

    @Override
    @Transactional
    public void deletePonderacion(BigDecimal id){
        catalogoPonderacionDao.delete(id);
    }



    //CATEGORIAS
    @Override
    @Transactional(readOnly = true)
    public List<CatalogoCategoria> findAllCategorias(){
        return (List<CatalogoCategoria>) categoriaDao.findAll();
    }

    @Override
    @Transactional
    public void save(CatalogoCategoria catalogoCategoria)
    {
       categoriaDao.save(catalogoCategoria);
    }

    @Override
    @Transactional
    public CatalogoCategoria findOneCategoria(BigDecimal id) {
        return categoriaDao.findOne(id);
    }

    @Override
    @Transactional
    public void deleteCategoria(BigDecimal id){
        categoriaDao.delete(id);
    }



    



    
}
