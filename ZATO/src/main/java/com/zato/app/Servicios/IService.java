/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.Servicios;

import com.zato.app.entidades.Candidato;
import com.zato.app.entidades.CatalogoAptitud;
import com.zato.app.entidades.CatalogoCategoria;
import com.zato.app.entidades.CatalogoCategoriaHabilidad;
import com.zato.app.entidades.CatalogoEscrito;
import com.zato.app.entidades.CatalogoGenero;
import com.zato.app.entidades.CatalogoGradoAcademico;
import com.zato.app.entidades.CatalogoLicencia;
import com.zato.app.entidades.CatalogoPonderacion;
import com.zato.app.entidades.CatalogoSectorEmpresa;
import com.zato.app.entidades.CatalogoTipoEmpresa;
import com.zato.app.entidades.CatalogoTipoPrueba;
import com.zato.app.entidades.Departamento;
import com.zato.app.entidades.Menu;
import com.zato.app.entidades.Municipio;
import com.zato.app.entidades.Oferta;

import java.math.BigDecimal;
import java.util.List;

import com.zato.app.entidades.Pais;
import com.zato.app.entidades.Rol;
import com.zato.app.entidades.Submenu;
import com.zato.app.entidades.CatalogoIdioma;
import com.zato.app.entidades.Empresa;
import com.zato.app.entidades.CatalogoPuesto;
import com.zato.app.entidades.CatalogoHabilidad;
import com.zato.app.entidades.CatalogoTipoReferencia;
import com.zato.app.entidades.RolSubmenu;
import com.zato.app.entidades.Perfil;

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
    //Catalogo Categoria Habilidad
    
    public List<CatalogoCategoriaHabilidad> findAllcategoriaHabilidad();
    public void savecategoriaHabilidad(CatalogoCategoriaHabilidad categoriaHabilidad);
    public CatalogoCategoriaHabilidad findOnecategoriaHabilidad(BigDecimal id);
    public void deletecategoriaHabilidad(BigDecimal id);
    
    
     //Catalogo Licencia
    
    public List<CatalogoLicencia> findAllcatalogoLicencia();
    public void savecatalogoLicencia(CatalogoLicencia catalogoLicencia);
    public CatalogoLicencia findOnecatalogoLicencia(BigDecimal id);
    public void deletecatalogoLicencia(BigDecimal id);


    //Catalogo Tipo Empresa

    public List<CatalogoTipoEmpresa> findAllTipoEmpresas();
    public void saveTipoEmpresa(CatalogoTipoEmpresa catalogoTipoEmpresa);
    public CatalogoTipoEmpresa findOneTipoEmpresa(BigDecimal id);
    public void deleteTipoEmpresa(BigDecimal id);
    
    
     //Catalogo Genero
    
    public List<CatalogoGenero> findAllcatalogoGenero();
    public void savecatalogoGenero(CatalogoGenero catalogoGenero);
    public CatalogoGenero findOnecatalogoGenero(BigDecimal id);
    public void deletecatalogoGenero(BigDecimal id);
    
    // ROL
    public List<Rol> findAllRol();
    public void saveRol(Rol rol);
    public Rol findOneRol (BigDecimal id);
    public void deleteRol(BigDecimal id);
    
    //Menu
    public List<Menu> findAllMenu();
    public void saveMenu(Menu menu);
    public Menu findOneMenu (BigDecimal id);
    public void deleteMenu(BigDecimal id);
    
     //Submenu
    public List<Submenu> findAllSubmenu();
    public void saveSubmenu(Submenu Submenu);
    public Submenu findOneSubmenu (BigDecimal id);
    public void deleteSubmenu(BigDecimal id);
    
     //Catalogo Idioma
    public List<CatalogoIdioma> findAllCatIdioma();
    public void saveCatIdioma(CatalogoIdioma catalogoidioma);
    public CatalogoIdioma findOneCatIdioma (BigDecimal id);
    public void deleteCatIdioma(BigDecimal id);
    
    
    //Registro de Empresa
    public List<Empresa> findAllempresa();
    public void saveEmpresa(Empresa empresa);
    public Empresa findOneEmpresa (BigDecimal id);
    public void deleteEmpresa(BigDecimal id);
    
    //Catalogo Puesto
    public List<CatalogoPuesto> findAllCatPuesto();
    public void saveCatPuesto(CatalogoPuesto catalogopuesto);
    public CatalogoPuesto findOneCatPuesto (BigDecimal id);
    public void deleteCatPuesto(BigDecimal id);
    
    //Catalogo Habilidad
    public List<CatalogoHabilidad> findAllCatHabilidad();
    public void saveCatHabilidad(CatalogoHabilidad catalogohabilidad);
    public CatalogoHabilidad findOneCatHabilidad (BigDecimal id);
    public void deleteCatHabilidad(BigDecimal id);
    
    //ROL SUBMENU
    public List<RolSubmenu> findAllRolS();
    public void saveRolS(RolSubmenu rolsubmenu);
    public RolSubmenu findOneRolS (BigDecimal id);
    public void deleteRolS(BigDecimal id);

    //Candidato
    public List<Candidato> findAllCandidato();
    public void saveCandidato(Candidato candidato);
    public Candidato findCandidato(BigDecimal id);
    public void deleteCandidato(BigDecimal id);
    
     //Catalogo aptitud
    public List<CatalogoAptitud> findAllCatalogoAptitud();
    public void saveCatalogoAptitud(CatalogoAptitud catalogoAptitud);
    public CatalogoAptitud findOneCatalogoAptitud (BigDecimal id);
    public void deleteCatalogoAptitud(BigDecimal id);
    
     //Catalogo grado academico
    public List<CatalogoGradoAcademico> findAllCatalogoGradoAcademico();
    public void saveCatalogoGradoAcademico(CatalogoGradoAcademico catalogoGradoAcademico);
    public CatalogoGradoAcademico findOneCatalogoGradoAcademico (BigDecimal id);
    public void deleteCatalogoGradoAcademico(BigDecimal id);
    
     //Catalogo escrito
    public List<CatalogoEscrito> findAllCatalogoEscrito();
    public void saveCatalogoEscrito(CatalogoEscrito catalogoEscrito);
    public CatalogoEscrito findOneCatalogoEscrito (BigDecimal id);
    public void deleteCatalogoEscrito(BigDecimal id);
    
     //Catalogo tipo de referencioa
    public List<CatalogoTipoReferencia> findAllCatalogoTipoReferencia();
    public void saveCatalogoTipoReferencia(CatalogoTipoReferencia catalogoTipoRefencia);
    public CatalogoTipoReferencia findOneCatalogoTipoReferencia (BigDecimal id);
    public void deleteCatalogoTipoReferencia(BigDecimal id);
    
      //PERFIL
    public List<Perfil> findAllPerfil();
    public void savePerfil(Perfil perfil);
    public Perfil findOnePerfil (BigDecimal id);
    public void deletePerfil(BigDecimal id);

    //OFERTA
    public List<Oferta> findAllOfertas();
    public void saveOferta(Oferta oferta);
    public Oferta findOneOferta(BigDecimal id);
    public void deleteOferta(BigDecimal id);
    
}
