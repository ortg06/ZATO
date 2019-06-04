/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.Servicios;

import java.math.BigDecimal;
import java.util.List;

import com.zato.app.dao.ICandidatoDao;
import com.zato.app.dao.ICatalogoAptitudDao;
import com.zato.app.dao.ICatalogoCategoriaHabilidadDao;
import com.zato.app.dao.ICatalogoEscritoDao;
import com.zato.app.dao.ICatalogoGenero;
import com.zato.app.dao.ICatalogoGradoAcademicoDao;
import com.zato.app.dao.ICatalogoLicencia;
import com.zato.app.dao.ICatalogoPonderacionDao;
import com.zato.app.dao.ICatalogoSectorEmpresa;
import com.zato.app.dao.ICatalogoTipoEmpresaDao;
import com.zato.app.dao.ICatalogoTipoPruebaDao;
import com.zato.app.dao.ICategoriaDao;
import com.zato.app.dao.IDepartamentoDao;
import com.zato.app.dao.IMenuDao;
import com.zato.app.dao.IMunicipioDao;
import com.zato.app.dao.IPaisDao;
import com.zato.app.dao.IRolDao;
import com.zato.app.dao.ISubmenuDao;
import com.zato.app.dao.ICatalogoIdiomaDao;
import com.zato.app.dao.IEmpresaDao;
import com.zato.app.dao.IPuestosDao;
import com.zato.app.dao.ICatalogoHabilidadDao;
import com.zato.app.dao.ICatalogoTipoReferenciaDao;
import com.zato.app.dao.IRolSubmenuDao;
import com.zato.app.dao.IPerfilDao;

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
import com.zato.app.entidades.Municipio;
import com.zato.app.entidades.Pais;
import com.zato.app.entidades.Rol;
import com.zato.app.entidades.Menu;
import com.zato.app.entidades.Submenu;
import com.zato.app.entidades.CatalogoIdioma;
import com.zato.app.entidades.Empresa;
import com.zato.app.entidades.CatalogoPuesto;
import com.zato.app.entidades.CatalogoHabilidad;
import com.zato.app.entidades.CatalogoTipoReferencia;
import com.zato.app.entidades.RolSubmenu;
import com.zato.app.entidades.Perfil;

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
    private ICatalogoSectorEmpresa catalogoSectorEmpresaDao;
    @Autowired
    private ICatalogoCategoriaHabilidadDao catalogoHabilidadDao;
    @Autowired
    private ICatalogoLicencia catalogoLicenciaDao;
    @Autowired
    private ICatalogoTipoEmpresaDao catalogoTipoEmpresaDao;
    @Autowired
    private ICatalogoGenero catalogoGeneroDao;
    @Autowired
    private IRolDao rolDao;
    @Autowired
    private IMenuDao menuDao;
    @Autowired
    private ISubmenuDao submenuDao;
    @Autowired
    private ICatalogoIdiomaDao catIdiomaDao;
    @Autowired
    private IEmpresaDao empresaDao;
    @Autowired

    private IPuestosDao catPuestosDao;
    @Autowired
    private ICatalogoHabilidadDao catHabilidadDao;
    @Autowired
    private IRolSubmenuDao RolSubmenuDao;
    @Autowired
    private ICandidatoDao candidatoDao;
    @Autowired
    private ICatalogoAptitudDao catalogoAptitudDao;
    @Autowired
    private ICatalogoGradoAcademicoDao catalogoGradoAcademicoDao;
    @Autowired
    private ICatalogoEscritoDao catalogoEscritoDao;
    @Autowired
    private ICatalogoTipoReferenciaDao catalogoTipoReferenciaDao;
    @Autowired
    private IPerfilDao PerfilDao; 

    // PAISES
    @Override
    @Transactional(readOnly = true) // esto sirve para acceder en modo de solo lectura ya que estamos construyendo
                                    // una consulta
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

    // Departamentos
    @Override
    @Transactional(readOnly = true)
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
    public Departamento findOneDepartamento(BigDecimal id) {
        return departamentoDao.findOne(id);
    }

    @Override
    @Transactional
    public void deleteDepartamento(BigDecimal id) {
        departamentoDao.delete(id);
    }

    // Municipios

    @Override
    @Transactional(readOnly = true)
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
    public Municipio findOneMunicipio(BigDecimal id) {
        return municipioDao.findOne(id);
    }

    @Override
    @Transactional
    public void deleteMunicipio(BigDecimal id) {
        municipioDao.delete(id);
    }

    // CATALOGO PONDERACION

    @Override
    @Transactional(readOnly = true)
    public List<CatalogoPonderacion> findAllPonderacion() {

        return (List<CatalogoPonderacion>) catalogoPonderacionDao.findAll();
    }

    @Override
    @Transactional
    public void save(CatalogoPonderacion catalogoPonderacion) {
        catalogoPonderacionDao.save(catalogoPonderacion);
    }

    @Override
    @Transactional
    public CatalogoPonderacion findOnePonderacion(BigDecimal id) {
        return catalogoPonderacionDao.findOne(id);
    }

    @Override
    @Transactional
    public void deletePonderacion(BigDecimal id) {
        catalogoPonderacionDao.delete(id);
    }

    // CATEGORIAS
    @Override
    @Transactional(readOnly = true)
    public List<CatalogoCategoria> findAllCategorias() {
        return (List<CatalogoCategoria>) categoriaDao.findAll();
    }

    @Override
    @Transactional
    public void saveCategoria(CatalogoCategoria catalogoCategoria) {
        categoriaDao.save(catalogoCategoria);
    }

    @Override
    @Transactional
    public CatalogoCategoria findOneCategoria(BigDecimal id) {
        return categoriaDao.findOne(id);
    }

    @Override
    @Transactional
    public void deleteCategoria(BigDecimal id) {
        categoriaDao.delete(id);
    }

    // Catalogo de Tipo de Prueba
    @Override
    @Transactional(readOnly = true)
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
    public CatalogoTipoPrueba findOnetprueba(BigDecimal id) {
        return catalogoTipoPruebaDao.findOne(id);
    }

    @Override
    @Transactional
    public void deletetipoprueba(BigDecimal id) {
        catalogoTipoPruebaDao.delete(id);
    }

    // Catalogo Sector Empresa
    @Override
    @Transactional
    public List<CatalogoSectorEmpresa> findAllSectores() {
        return (List<CatalogoSectorEmpresa>) catalogoSectorEmpresaDao.findAll();
    }

    @Override
    @Transactional
    public void saveSector(CatalogoSectorEmpresa catalogoSectorEmpresa) {
        catalogoSectorEmpresaDao.save(catalogoSectorEmpresa);
    }

    @Override
    @Transactional
    public CatalogoSectorEmpresa findOneSector(BigDecimal id) {
        return catalogoSectorEmpresaDao.findOne(id);
    }

    @Override
    @Transactional
    public void deleteSector(BigDecimal id) {
        catalogoSectorEmpresaDao.delete(id);
    }

    // Catalogo Categoria Habilidad

    @Override
    @Transactional(readOnly = true)
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
    public CatalogoCategoriaHabilidad findOnecategoriaHabilidad(BigDecimal id) {
        return catalogoHabilidadDao.findOne(id);
    }

    @Override
    @Transactional
    public void deletecategoriaHabilidad(BigDecimal id) {
        catalogoHabilidadDao.delete(id);
    }

    // Catalogo Licencia

    @Override
    @Transactional(readOnly = true)
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
    public CatalogoLicencia findOnecatalogoLicencia(BigDecimal id) {
        return catalogoLicenciaDao.findOne(id);
    }

    @Override
    @Transactional
    public void deletecatalogoLicencia(BigDecimal id) {
        catalogoLicenciaDao.delete(id);
    }

    // Catalogo Genero

    @Override
    @Transactional(readOnly = true)
    public List<CatalogoGenero> findAllcatalogoGenero() {
        return (List<CatalogoGenero>) catalogoGeneroDao.findAll();
    }

    @Override
    @Transactional
    public void savecatalogoGenero(CatalogoGenero catalogoGenero) {
        catalogoGeneroDao.save(catalogoGenero);
    }

    @Override
    @Transactional
    public CatalogoGenero findOnecatalogoGenero(BigDecimal id) {
        return catalogoGeneroDao.findOne(id);
    }

    @Override
    @Transactional
    public void deletecatalogoGenero(BigDecimal id) {
        catalogoGeneroDao.delete(id);
    }

    // ROL
    @Override
    @Transactional(readOnly = true)
    public List<Rol> findAllRol() {
        return (List<Rol>) rolDao.findAll();

    }

    @Override
    @Transactional
    public void saveRol(Rol rol) {
        rolDao.save(rol);
    }

    @Override
    @Transactional
    public Rol findOneRol(BigDecimal id) {
        return rolDao.findOne(id);
    }

    @Override
    @Transactional
    public void deleteRol(BigDecimal id) {
        rolDao.delete(id);
    }

    // Menu
    @Override
    @Transactional(readOnly = true)
    public List<Menu> findAllMenu() {
        return (List<Menu>) menuDao.findAll();

    }

    @Override
    @Transactional
    public void saveMenu(Menu menu) {
        menuDao.save(menu);
    }

    @Override
    @Transactional
    public Menu findOneMenu(BigDecimal id) {
        return menuDao.findOne(id);
    }

    @Override
    @Transactional
    public void deleteMenu(BigDecimal id) {
        menuDao.delete(id);
    }

    // Submenu
    @Override
    @Transactional(readOnly = true)
    public List<Submenu> findAllSubmenu() {
        return (List<Submenu>) submenuDao.findAll();

    }

    @Override
    @Transactional
    public void saveSubmenu(Submenu submenu) {
        submenuDao.save(submenu);
    }

    @Override
    @Transactional
    public Submenu findOneSubmenu(BigDecimal id) {
        return submenuDao.findOne(id);
    }

    @Override
    @Transactional
    public void deleteSubmenu(BigDecimal id) {
        submenuDao.delete(id);
    }

    // Catalogo Idioma
    @Override
    @Transactional(readOnly = true)
    public List<CatalogoIdioma> findAllCatIdioma() {
        return (List<CatalogoIdioma>) catIdiomaDao.findAll();

    }

    @Override
    @Transactional
    public void saveCatIdioma(CatalogoIdioma catalogoidioma) {
        catIdiomaDao.save(catalogoidioma);
    }

    @Override
    @Transactional
    public CatalogoIdioma findOneCatIdioma(BigDecimal id) {
        return catIdiomaDao.findOne(id);
    }

    @Override
    @Transactional
    public void deleteCatIdioma(BigDecimal id) {
        catIdiomaDao.delete(id);
    }

    // Catalogo Puestos
    @Override
    @Transactional(readOnly = true)
    public List<CatalogoPuesto> findAllCatPuesto() {
        return (List<CatalogoPuesto>) catPuestosDao.findAll();

    }

    @Override
    public void saveCatPuesto(CatalogoPuesto catalogopuesto) {
        catPuestosDao.save(catalogopuesto);
    }

    @Override
    @Transactional
    public CatalogoPuesto findOneCatPuesto(BigDecimal id) {
        return catPuestosDao.findOne(id);
    }

    @Override
    @Transactional
    public void deleteCatPuesto(BigDecimal id) {
        catPuestosDao.delete(id);
    }

    // Catalogo Tipo Empresa

    @Override
    @Transactional(readOnly = true)
    public List<CatalogoTipoEmpresa> findAllTipoEmpresas() {
        return (List<CatalogoTipoEmpresa>) catalogoTipoEmpresaDao.findAll();

    }

    public void saveTipoEmpresa(CatalogoTipoEmpresa catalogoTipoEmpresa) {
        catalogoTipoEmpresaDao.save(catalogoTipoEmpresa);
    }

    @Override
    @Transactional
    public CatalogoTipoEmpresa findOneTipoEmpresa(BigDecimal id) {
        return catalogoTipoEmpresaDao.findOne(id);

    }

    public void deleteTipoEmpresa(BigDecimal id) {
        catalogoTipoEmpresaDao.delete(id);
    }

    // EMPRESA
    @Override
    public List<Empresa> findAllempresa() {
        return (List<Empresa>) empresaDao.findAll();
    }

    @Override
    public void saveEmpresa(Empresa empresa) {
        empresaDao.save(empresa);
    }

    @Override
    public Empresa findOneEmpresa(BigDecimal id) {
        return empresaDao.findOne(id);
    }

    @Override
    public void deleteEmpresa(BigDecimal id) {
        empresaDao.delete(id);

    }

    // Catalogo Habilidad
    @Override
    @Transactional(readOnly = true)
    public List<CatalogoHabilidad> findAllCatHabilidad() {
        return (List<CatalogoHabilidad>) catHabilidadDao.findAll();

    }

    @Override
    @Transactional
    public void saveCatHabilidad(CatalogoHabilidad catalogohabilidad) {
        catHabilidadDao.save(catalogohabilidad);
    }

    @Override
    @Transactional
    public CatalogoHabilidad findOneCatHabilidad(BigDecimal id) {
        return catHabilidadDao.findOne(id);
    }

    @Override
    @Transactional
    public void deleteCatHabilidad(BigDecimal id) {
        catHabilidadDao.delete(id);
    }

    // ROL SUBMENU
    @Override
    @Transactional(readOnly = true)
    public List<RolSubmenu> findAllRolS() {
        return (List<RolSubmenu>) RolSubmenuDao.findAll();

    }

    @Override
    @Transactional
    public void saveRolS(RolSubmenu rolsubmenu) {
        RolSubmenuDao.save(rolsubmenu);
    }

    @Override
    @Transactional
    public RolSubmenu findOneRolS(BigDecimal id) {
        return RolSubmenuDao.findOne(id);
    }

    @Override
    @Transactional
    public void deleteRolS(BigDecimal id) {
        RolSubmenuDao.delete(id);
    }


    //CANDIDATO
    @Override
    @Transactional(readOnly = true)
    public List<Candidato> findAllCandidato() {
        return (List<Candidato>) candidatoDao.findAll();
    }

    @Override
    public void saveCandidato(Candidato candidato) {
        candidatoDao.save(candidato);
    }

    @Override
    public Candidato findCandidato(BigDecimal id) {
        return candidatoDao.findOne(id);
    }

    @Override
    public void deleteCandidato(BigDecimal id) {
        candidatoDao.delete(id);
    }
    
    //Catalogo Aptitudes
     @Override
    @Transactional(readOnly=true)
    public List<CatalogoAptitud> findAllCatalogoAptitud() {
      return (List<CatalogoAptitud>) catalogoAptitudDao.findAll();
    }

    @Override
    @Transactional
    public void saveCatalogoAptitud(CatalogoAptitud catalogoAptitud) {
      catalogoAptitudDao.save(catalogoAptitud);
    }
   
    @Override
    @Transactional
    public CatalogoAptitud findOneCatalogoAptitud(BigDecimal id){
        return catalogoAptitudDao.findOne(id);
    }
    
     @Override
    @Transactional
    public void deleteCatalogoAptitud(BigDecimal id){
        catalogoAptitudDao.delete(id);
    }
    
    //Catalogo grado academico
     @Override
    @Transactional(readOnly=true)
    public List<CatalogoGradoAcademico> findAllCatalogoGradoAcademico() {
      return (List<CatalogoGradoAcademico>) catalogoGradoAcademicoDao.findAll();
    }

    @Override
    @Transactional
    public void saveCatalogoGradoAcademico(CatalogoGradoAcademico catalogoGradoAcademico) {
       catalogoGradoAcademicoDao.save(catalogoGradoAcademico);
    }
   
    @Override
    @Transactional
    public CatalogoGradoAcademico findOneCatalogoGradoAcademico(BigDecimal id){
        return catalogoGradoAcademicoDao.findOne(id);
    }
    
     @Override
    @Transactional
    public void deleteCatalogoGradoAcademico(BigDecimal id){
        catalogoGradoAcademicoDao.delete(id);
    }
    
    //Catalogo Escrito
     @Override
    @Transactional(readOnly=true)
    public List<CatalogoEscrito> findAllCatalogoEscrito() {
      return (List<CatalogoEscrito>) catalogoEscritoDao.findAll();
    }

    @Override
    @Transactional
    public void saveCatalogoEscrito(CatalogoEscrito catalogoEscrito) {
      catalogoEscritoDao.save(catalogoEscrito);
    }
   
    @Override
    @Transactional
    public CatalogoEscrito findOneCatalogoEscrito(BigDecimal id){
        return catalogoEscritoDao.findOne(id);
    }
    
     @Override
    @Transactional
    public void deleteCatalogoEscrito(BigDecimal id){
        catalogoEscritoDao.delete(id);
    }
    
    //Catalogo Tipo Referencia
     @Override
    @Transactional(readOnly=true)
    public List<CatalogoTipoReferencia> findAllCatalogoTipoReferencia() {
      return (List<CatalogoTipoReferencia>) catalogoTipoReferenciaDao.findAll();
    }

    @Override
    @Transactional
    public void saveCatalogoTipoReferencia(CatalogoTipoReferencia catalogoTipoReferencia) {
      catalogoTipoReferenciaDao.save(catalogoTipoReferencia);
    }
   
    @Override
    @Transactional
    public CatalogoTipoReferencia findOneCatalogoTipoReferencia(BigDecimal id){
        return catalogoTipoReferenciaDao.findOne(id);
    }
    
     @Override
    @Transactional
    public void deleteCatalogoTipoReferencia(BigDecimal id){
        catalogoTipoReferenciaDao.delete(id);
    }
    
    //PERFIL
    @Override
    @Transactional(readOnly=true)
    public List<Perfil> findAllPerfil() {
      return (List<Perfil>) PerfilDao.findAll();
      
    }

    @Override
    @Transactional
    public void savePerfil(Perfil perfil) {
      PerfilDao.save(perfil);
    }
    
    @Override 
    @Transactional
    public Perfil findOnePerfil(BigDecimal id){
        return PerfilDao.findOne(id);
    }
    
    @Override
    @Transactional
    public void deletePerfil(BigDecimal id){
        PerfilDao.delete(id);
    }
    

}
