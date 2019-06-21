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
import com.zato.app.dao.IOfertaDao;
import com.zato.app.dao.IPaisDao;
import com.zato.app.dao.IRolDao;
import com.zato.app.dao.ISubmenuDao;
import com.zato.app.dao.ICatalogoIdiomaDao;
import com.zato.app.dao.IEmpresaDao;
import com.zato.app.dao.IPuestosDao;
import com.zato.app.dao.ICatalogoHabilidadDao;
import com.zato.app.dao.ICatalogoTipoReferenciaDao;
import com.zato.app.dao.IItemPruebaDao;
import com.zato.app.dao.IOpcionesDao;
import com.zato.app.dao.IRolSubmenuDao;
import com.zato.app.dao.IPerfilDao;
import com.zato.app.dao.IPruebaDao;
import com.zato.app.dao.ICvDao;
import com.zato.app.dao.ILogroDao;
import com.zato.app.dao.ICursoCapacitacionDao;
import com.zato.app.dao.IEscritoDao;
import com.zato.app.dao.IAptitudCvDao;
import com.zato.app.dao.IHabilidadesCvDao;
import com.zato.app.dao.IEventoDao;
import com.zato.app.dao.IFormacionAcademicaDao;

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
import com.zato.app.entidades.Oferta;
import com.zato.app.entidades.Pais;
import com.zato.app.entidades.Rol;
import com.zato.app.entidades.Menu;
import com.zato.app.entidades.Submenu;
import com.zato.app.entidades.CatalogoIdioma;
import com.zato.app.entidades.Empresa;
import com.zato.app.entidades.CatalogoPuesto;
import com.zato.app.entidades.CatalogoHabilidad;
import com.zato.app.entidades.CatalogoTipoReferencia;
import com.zato.app.entidades.ItemPrueba;
import com.zato.app.entidades.Opciones;
import com.zato.app.entidades.RolSubmenu;
import com.zato.app.entidades.Perfil;
import com.zato.app.entidades.Prueba;
import com.zato.app.entidades.Cv;
import com.zato.app.entidades.ExperienciaLaboral;
import com.zato.app.entidades.Logro;
import com.zato.app.entidades.CursoCapacitacion;
import com.zato.app.entidades.Escrito;
import com.zato.app.entidades.AptitudCv;
import com.zato.app.entidades.HabilidadesCv;
import com.zato.app.entidades.Evento;
import com.zato.app.entidades.FormacionAcademica;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zato.app.dao.IExperienciaLaboralDao;
import com.zato.app.dao.IPruebaOfertaDao;
import com.zato.app.entidades.PruebaOferta;

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
    @Autowired
    private IOfertaDao OfertaDao;
    
    @Autowired
    private IPruebaDao pruebaDao;
    @Autowired
    private IItemPruebaDao itemDao;
    @Autowired
    private IOpcionesDao opcionesDao;
    @Autowired
    private ICvDao cvDao;
    @Autowired
    private IExperienciaLaboralDao experienciaDao;
    @Autowired
    private IPruebaOfertaDao pruebaofertaDao;
    @Autowired
    private ILogroDao logroDao;
    @Autowired
    private ICursoCapacitacionDao cursoCapDao;
    @Autowired
    private IEscritoDao escritoDao;
    @Autowired
    private IAptitudCvDao aptitudCvDao;
    @Autowired
    private IHabilidadesCvDao habilidadesCvDao;
    @Autowired
    private IEventoDao eventoDao;
    @Autowired
    private IFormacionAcademicaDao formacionDao;
    
    
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

    //OFERTA

    @Override
    @Transactional(readOnly=true)
    public List<Oferta>findAllOfertas(){
        return(List<Oferta>) OfertaDao.findAll();
    }

    @Override
    @Transactional
    public void saveOferta(Oferta oferta){
        OfertaDao.save(oferta);
    }

    @Override
    @Transactional
    public Oferta findOneOferta(BigDecimal id){
        return OfertaDao.findOne(id);
    }

    public void deleteOferta(BigDecimal id){
        OfertaDao.delete(id);
    }
    
    
     //Prueba

    @Override
    @Transactional(readOnly=true)
    public List<Prueba>findAllPruebas(){
        return(List<Prueba>) pruebaDao.findAll();
    }

    @Override
    @Transactional
    public void savePrueba(Prueba prueba){
        pruebaDao.save(prueba);
    }

    @Override
    @Transactional
    public Prueba findOnePrueba(BigDecimal id){
        return pruebaDao.findOne(id);
    }

      @Override
    @Transactional
    public void deletePrueba(BigDecimal id){
        pruebaDao.delete(id);
    }
    
   
    //Item Prueba

    @Override
    @Transactional(readOnly=true)
    public List<ItemPrueba>findAllItems(){
        return(List<ItemPrueba>) itemDao.findAll();
    }

    @Override
    @Transactional
    public void saveItem(ItemPrueba itemPrueba){
        itemDao.save(itemPrueba);
    }

    @Override
    @Transactional
    public ItemPrueba findOneItem(BigDecimal id){
        return itemDao.findOne(id);
    }

      @Override
    @Transactional
    public void deleteItem(BigDecimal id){
        itemDao.delete(id);
    }

    @Override
    @Transactional(readOnly=true)
    public List<ItemPrueba>findItemPruebabyPrueba(Prueba prueba){
        return(List<ItemPrueba>) itemDao.findItemPruebabyPrueba(prueba);
    }

    
    //Opciones

    @Override
    @Transactional(readOnly=true)
    public List<Opciones>findAllOpciones(){
        return(List<Opciones>) opcionesDao.findAll();
    }

    @Override
    @Transactional
    public void saveOpcion(Opciones opciones){
        opcionesDao.save(opciones);
    }

    @Override
    @Transactional
    public Opciones findOneOpcion(BigDecimal id){
        return opcionesDao.findOne(id);
    }

      @Override
    @Transactional
    public void deleteOpcion(BigDecimal id){
        opcionesDao.delete(id);
    }
    
     @Override
    @Transactional(readOnly=true)
    public List<Opciones> findOpcionesbyItemPrueba(ItemPrueba itemprueba){
        return(List<Opciones>) opcionesDao.findOpcionesbyItemPrueba(itemprueba);
    }
    
    
    //CV

    @Override
    @Transactional(readOnly=true)
    public List<Cv>findAllCv(){
        return(List<Cv>) cvDao.findAll();
    }

    @Override
    @Transactional
    public void saveCv(Cv cv){
        cvDao.save(cv);
    }

    @Override
    @Transactional
    public Cv findOneCv(BigDecimal id){
        return cvDao.findOne(id);
    }

      @Override
    @Transactional
    public void deleteCv(BigDecimal id){
        cvDao.delete(id);
    }
    
     @Override
    @Transactional(readOnly=true)
    public List<Cv>findCandidatobyCv(Candidato candidato){
        return(List<Cv>) cvDao.findCandidatobyCv(candidato);
    }
    
    //EXPERIENCIA LABORAL
    @Override
    @Transactional(readOnly=true)
    public List<ExperienciaLaboral>findAllExp(){
        return(List<ExperienciaLaboral>) experienciaDao.findAll();
    }

    @Override
    @Transactional
    public void saveExp(ExperienciaLaboral experiencialaboral){
        experienciaDao.save(experiencialaboral);
    }

    @Override
    @Transactional
    public ExperienciaLaboral findOneExp(BigDecimal id){
        return experienciaDao.findOne(id);
    }

      @Override
    @Transactional
    public void deleteExp(BigDecimal id){
        experienciaDao.delete(id);
    }
    
      @Override
    @Transactional(readOnly=true)
    public List<ExperienciaLaboral>findCvbyExperiencia(Cv cv){
        return(List<ExperienciaLaboral>) experienciaDao.findCvbyExperiencia(cv);
    }
    

    
    //Prueba Oferta
    @Override
     @Transactional(readOnly=true)
    public List<PruebaOferta> findPruebaOfertabyOferta(Oferta oferta) {
       return(List<PruebaOferta>) pruebaofertaDao.findPruebaOfertabyOferta(oferta);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<PruebaOferta>findAllPruebaOfertas(){
        return(List<PruebaOferta>) pruebaofertaDao.findAll();
    }

    @Override
    @Transactional
    public void savePruebaOferta(PruebaOferta pruebaoferta){
        pruebaofertaDao.save(pruebaoferta);
    }

    @Override
    @Transactional
    public PruebaOferta findOnePruebaOferta(BigDecimal id){
        return pruebaofertaDao.findOne(id);
    }

      @Override
    @Transactional
    public void deletePruebaOferta(BigDecimal id){
        pruebaofertaDao.delete(id);
    }

    @Override
    public List<PruebaOferta> findPruebaOfertabyPruebaOferta(Oferta oferta, Prueba prueba) {
         return(List<PruebaOferta>) pruebaofertaDao.findPruebaOfertabyPruebaOferta(oferta, prueba);
    }
    
    
    //LOGRO
    @Override
    @Transactional(readOnly=true)
    public List<Logro>findAllLogro(){
        return(List<Logro>) logroDao.findAll();
    }

    @Override
    @Transactional
    public void saveLogro(Logro logro){
        logroDao.save(logro);
    }

    @Override
    @Transactional
    public Logro findOneLogro(BigDecimal id){
        return logroDao.findOne(id);
    }

      @Override
    @Transactional
    public void deleteLogro(BigDecimal id){
        logroDao.delete(id);
    }
    
      @Override
    @Transactional(readOnly=true)
    public List<Logro>findCvbyLogro(Cv cv){
        return(List<Logro>) logroDao.findCvbyLogro(cv);
    }
    
    
    // CURSO CAPACITACION
    @Override
    @Transactional(readOnly=true)
    public List<CursoCapacitacion>findAllCursoCap(){
        return(List<CursoCapacitacion>) cursoCapDao.findAll();
    }

    @Override
    @Transactional
    public void saveCursoCap(CursoCapacitacion cursocapacitacion){
        cursoCapDao.save(cursocapacitacion);
    }

    @Override
    @Transactional
    public CursoCapacitacion findOneCursoCap(BigDecimal id){
        return cursoCapDao.findOne(id);
    }

      @Override
    @Transactional
    public void deleteCursoCap(BigDecimal id){
        cursoCapDao.delete(id);
    }
    
      @Override
    @Transactional(readOnly=true)
    public List<CursoCapacitacion>findCvbyCursoCap(Cv cv){
        return(List<CursoCapacitacion>) cursoCapDao.findCvbyCursoCap(cv);
    }
    
    
    // ESCRITO
    @Override
    @Transactional(readOnly=true)
    public List<Escrito>findAllEsc(){
        return(List<Escrito>) escritoDao.findAll();
    }

    @Override
    @Transactional
    public void saveEsc(Escrito escrito){
        escritoDao.save(escrito);
    }

    @Override
    @Transactional
    public Escrito findOneEsc(BigDecimal id){
        return escritoDao.findOne(id);
    }

      @Override
    @Transactional
    public void deleteEsc(BigDecimal id){
        escritoDao.delete(id);
    }
    
      @Override
    @Transactional(readOnly=true)
    public List<Escrito>findCvbyEscrito(Cv cv){
        return(List<Escrito>) escritoDao.findCvbyEscrito(cv);
    }

    @Override
    public List<Oferta> findOfertaByEmpresa(Empresa empresa) {
        return (List<Oferta>)  OfertaDao.findOfertaByEmpresa(empresa);
    }
    
    // APTITUD CV
    @Override
    @Transactional(readOnly=true)
    public List<AptitudCv>findAllAptCv(){
        return(List<AptitudCv>) aptitudCvDao.findAll();
    }

    @Override
    @Transactional
    public void saveAptCv(AptitudCv aptitudcv){
        aptitudCvDao.save(aptitudcv);
    }

    @Override
    @Transactional
    public AptitudCv findOneAptCv(BigDecimal id){
        return aptitudCvDao.findOne(id);
    }

      @Override
    @Transactional
    public void deleteAptCv(BigDecimal id){
        aptitudCvDao.delete(id);
    }
    
      @Override
    @Transactional(readOnly=true)
    public List<AptitudCv>findCvbyAptCv(Cv cv){
        return(List<AptitudCv>) aptitudCvDao.findCvbyAptCv(cv);
    }
    
     // HABILIDADES CV
    @Override
    @Transactional(readOnly=true)
    public List<HabilidadesCv>findAllHabCv(){
        return(List<HabilidadesCv>) habilidadesCvDao.findAll();
    }

    @Override
    @Transactional
    public void saveHabCv(HabilidadesCv habilidadescv){
        habilidadesCvDao.save(habilidadescv);
    }

    @Override
    @Transactional
    public HabilidadesCv findOneHabCv(BigDecimal id){
        return habilidadesCvDao.findOne(id);
    }

      @Override
    @Transactional
    public void deleteHabCv(BigDecimal id){
        habilidadesCvDao.delete(id);
    }
    
      @Override
    @Transactional(readOnly=true)
    public List<HabilidadesCv>findCvbyHabCv(Cv cv){
        return(List<HabilidadesCv>) habilidadesCvDao.findCvbyHabCv(cv);
    }
    
     // EVENTO
    @Override
    @Transactional(readOnly=true)
    public List<Evento>findAllEvento(){
        return(List<Evento>) eventoDao.findAll();
    }

    @Override
    @Transactional
    public void saveEvento(Evento evento){
        eventoDao.save(evento);
    }

    @Override
    @Transactional
    public Evento findOneEvento(BigDecimal id){
        return eventoDao.findOne(id);
    }

      @Override
    @Transactional
    public void deleteEvento(BigDecimal id){
        eventoDao.delete(id);
    }
    
      @Override
    @Transactional(readOnly=true)
    public List<Evento>findCvbyEvento(Cv cv){
        return(List<Evento>) eventoDao.findCvbyEvento(cv);
    }
    
        // FORMACION ACADEMICA
    @Override
    @Transactional(readOnly=true)
    public List<FormacionAcademica>findAllForAcad(){
        return(List<FormacionAcademica>) formacionDao.findAll();
    }

    @Override
    @Transactional
    public void saveForAcad(FormacionAcademica formacionacademica){
        formacionDao.save(formacionacademica);
    }

    @Override
    @Transactional
    public FormacionAcademica findOneForAcad(BigDecimal id){
        return formacionDao.findOne(id);
    }

      @Override
    @Transactional
    public void deleteForAcad(BigDecimal id){
        formacionDao.delete(id);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<FormacionAcademica>findCvbyForAcad(Cv cv){
        return(List<FormacionAcademica>) formacionDao.findCvbyForAcad(cv);
    }
    
}
