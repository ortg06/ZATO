/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.Servicios;

import com.zato.app.dao.ICatalogoCategoriaHabilidadDao;
import com.zato.app.dao.ICatalogoLicencia;
import com.zato.app.dao.ICatalogoPonderacionDao;
import com.zato.app.dao.ICatalogoSectorEmpresa;
import com.zato.app.dao.ICatalogoTipoPruebaDao;
import com.zato.app.dao.ICategoriaDao;
import com.zato.app.dao.IDepartamentoDao;
import com.zato.app.dao.IMunicipioDao;
import java.math.BigDecimal;
import java.util.List;

import com.zato.app.dao.IPaisDao;
import com.zato.app.entidades.CatalogoCategoria;
import com.zato.app.entidades.CatalogoCategoriaHabilidad;
import com.zato.app.entidades.CatalogoLicencia;
import com.zato.app.entidades.CatalogoPonderacion;
import com.zato.app.entidades.CatalogoSectorEmpresa;
import com.zato.app.entidades.CatalogoTipoPrueba;
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
    @Autowired
    private ICatalogoTipoPruebaDao catalogoTipoPruebaDao;
    @Autowired
<<<<<<< HEAD
    private ICatalogoSectorEmpresa catalogoSectorEmpresaDao;
   
=======
    private ICatalogoCategoriaHabilidadDao catalogoHabilidadDao;
    @Autowired
    private ICatalogoLicencia catalogoLicenciaDao;
>>>>>>> 8c6e132760a198224988aa4e78b20a6da43925a6

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
    public void saveCategoria(CatalogoCategoria catalogoCategoria)
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


//Catalogo de Tipo de Prueba 
    @Override
    @Transactional(readOnly=true)
    public List<CatalogoTipoPrueba> findAlltipoprueba() {
        return (List<CatalogoTipoPrueba>) catalogoTipoPruebaDao.findAll();
    }

    @Override
    @Transactional
    public void savetipoprueba(CatalogoTipoPrueba tipoprueba) {
      catalogoTipoPruebaDao.save(tipoprueba);
    }
    
    @Override
    @Transactional
    public CatalogoTipoPrueba findOnetprueba(BigDecimal id){
        return catalogoTipoPruebaDao.findOne(id);
    }
    
     @Override
    @Transactional
    public void deletetipoprueba(BigDecimal id){
        catalogoTipoPruebaDao.delete(id);
    }
 
<<<<<<< HEAD

//Catalogo Sector Empresa
@Override
@Transactional
public List<CatalogoSectorEmpresa> findAllSectores(){
    return (List<CatalogoSectorEmpresa>) catalogoSectorEmpresaDao.findAll();
}

@Override
@Transactional
public void saveSector(CatalogoSectorEmpresa catalogoSectorEmpresa){
    catalogoSectorEmpresaDao.save(catalogoSectorEmpresa);
}


@Override
@Transactional
public CatalogoSectorEmpresa findOneSector(BigDecimal id){
    return catalogoSectorEmpresaDao.findOne(id);
}

@Override
@Transactional
public void deleteSector(BigDecimal id){
    catalogoSectorEmpresaDao.delete(id);
}

=======
    
   //Catalogo Categoria Habilidad
    
    @Override
    @Transactional(readOnly=true)
    public List<CatalogoCategoriaHabilidad> findAllcategoriaHabilidad() {
        return (List<CatalogoCategoriaHabilidad>) catalogoHabilidadDao.findAll();
    }

    @Override
    @Transactional
    public void savecategoriaHabilidad(CatalogoCategoriaHabilidad catalogoHabilidad) {
      catalogoHabilidadDao.save(catalogoHabilidad);
    }
    
    @Override
    @Transactional
    public CatalogoCategoriaHabilidad findOnecategoriaHabilidad(BigDecimal id){
        return catalogoHabilidadDao.findOne(id);
    }
    
     @Override
    @Transactional
    public void deletecategoriaHabilidad(BigDecimal id){
        catalogoHabilidadDao.delete(id);
    } 
    
    
     //Catalogo Licencia
    
    @Override
    @Transactional(readOnly=true)
    public List<CatalogoLicencia> findAllcatalogoLicencia() {
        return (List<CatalogoLicencia>) catalogoLicenciaDao.findAll();
    }

    @Override
    @Transactional
    public void savecatalogoLicencia(CatalogoLicencia catalogoLicencia) {
      catalogoLicenciaDao.save(catalogoLicencia);
    }
    
    @Override
    @Transactional
    public CatalogoLicencia findOnecatalogoLicencia(BigDecimal id){
        return catalogoLicenciaDao.findOne(id);
    }
    
     @Override
    @Transactional
    public void deletecatalogoLicencia(BigDecimal id){
        catalogoLicenciaDao.delete(id);
    } 
    
    
    
>>>>>>> 8c6e132760a198224988aa4e78b20a6da43925a6
}
