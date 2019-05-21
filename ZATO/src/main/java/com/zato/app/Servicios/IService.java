/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.Servicios;

import com.zato.app.entidades.CatalogoCategoria;
import com.zato.app.entidades.CatalogoPonderacion;
import com.zato.app.entidades.CatalogoSectorEmpresa;
import com.zato.app.entidades.CatalogoTipoPrueba;
import com.zato.app.entidades.Departamento;
import com.zato.app.entidades.Municipio;
import java.math.BigDecimal;
import java.util.List;

import com.zato.app.entidades.Pais;

/**
 *
 * @author Alex
 */
public interface IService {
    
    //Pais
    public List<Pais> findAll();
    public void save(Pais pais);
    public Pais findOne (BigDecimal id);
    public void delete(BigDecimal id);
    
    //Departamento
    public List<Departamento> findAlldep();
    public void saveDepto(Departamento departamento);
    public Departamento findOneDepartamento(BigDecimal id);
    public void deleteDepartamento(BigDecimal id);
    
    //Municipio
    
    public List<Municipio> findAllmun();
    public void saveMun(Municipio municipio);
    public Municipio findOneMunicipio(BigDecimal id);
    public void deleteMunicipio(BigDecimal id);
    
    //Catalogo Ponderacion

    public List<CatalogoPonderacion> findAllPonderacion();
    public void save(CatalogoPonderacion catalogoPonderacion);
    public CatalogoPonderacion findOnePonderacion(BigDecimal id);
    public void deletePonderacion(BigDecimal id);
 
    //Catalogo Categoria

    public List<CatalogoCategoria>findAllCategorias();
    public void saveCategoria(CatalogoCategoria catalogoCategoria);
    public CatalogoCategoria findOneCategoria(BigDecimal id);
    public void deleteCategoria(BigDecimal id);
    
    //Catalogo Tipo de Prueba
    
    public List<CatalogoTipoPrueba> findAlltipoprueba();
    public void savetipoprueba(CatalogoTipoPrueba tipoprueba);
    public CatalogoTipoPrueba findOnetprueba(BigDecimal id);
    public void deletetipoprueba(BigDecimal id);


    //Catalogo Sector Empresa
    
    public List<CatalogoSectorEmpresa> findAllSectores();
    public void saveSector(CatalogoSectorEmpresa catalogoSectorEmpresa);
    public CatalogoSectorEmpresa findOneSector(BigDecimal id);
    public void deleteSector(BigDecimal id);
}
