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
import com.zato.app.entidades.ItemPrueba;
import com.zato.app.entidades.Opciones;
import com.zato.app.entidades.RolSubmenu;
import com.zato.app.entidades.Perfil;
import com.zato.app.entidades.Prueba;
import com.zato.app.entidades.Cv;
import com.zato.app.entidades.ExperienciaLaboral;
import com.zato.app.entidades.Logro;
import com.zato.app.entidades.PruebaOferta;
import com.zato.app.entidades.CursoCapacitacion;
import com.zato.app.entidades.Escrito;
import com.zato.app.entidades.AptitudCv;
import com.zato.app.entidades.AptitudOferta;
import com.zato.app.entidades.Bitacora;
import com.zato.app.entidades.HabilidadesCv;
import com.zato.app.entidades.Evento;
import com.zato.app.entidades.FormacionAcademica;
import com.zato.app.entidades.LicenciaCandidato;
import com.zato.app.entidades.HabilidadLinguisticaCv;
import com.zato.app.entidades.Referencia;
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
    public List<Oferta>findOfertaByEmpresa(Empresa empresa);
    
    
    //PruebaOferta
    public List<PruebaOferta> findPruebaOfertabyOferta(Oferta oferta);
    public List<PruebaOferta> findAllPruebaOfertas();
    public void savePruebaOferta(PruebaOferta pruebaoferta);
    public PruebaOferta findOnePruebaOferta(BigDecimal id);
    public void deletePruebaOferta(BigDecimal id);
    
    //OBTENER PRUEBASOFERTA SEGUN OFERTA Y PRUEBA
    public List<PruebaOferta> findPruebaOfertabyPruebaOferta(Oferta oferta,Prueba prueba);
    
     //Prueba
    public List<Prueba> findAllPruebas();
    public void savePrueba(Prueba prueba);
    public Prueba findOnePrueba(BigDecimal id);
    public void deletePrueba(BigDecimal id);
    
    
     //Item Prueba
    public List<ItemPrueba> findAllItems();
    public void saveItem(ItemPrueba itemPrueba);
    public ItemPrueba findOneItem(BigDecimal id);
    public void deleteItem(BigDecimal id);
    public List<ItemPrueba> findItemPruebabyPrueba(Prueba prueba);
    
     //Opciones
    public List<Opciones> findAllOpciones();
    public void saveOpcion(Opciones opciones);
    public Opciones findOneOpcion(BigDecimal id);
    public void deleteOpcion(BigDecimal id);
    public List<Opciones> findOpcionesbyItemPrueba(ItemPrueba itemprueba);
    
    
     //CV
    public List<Cv> findAllCv();
    public void saveCv(Cv cv);
    public Cv findOneCv (BigDecimal id);
    public void deleteCv(BigDecimal id);
    public List<Cv> findCandidatobyCv(Candidato candidato);
    
     //EXPERICIA LABORAL
    public List<ExperienciaLaboral> findAllExp();
    public void saveExp(ExperienciaLaboral experiencia);
    public ExperienciaLaboral findOneExp (BigDecimal id);
    public void deleteExp(BigDecimal id);
    public List<ExperienciaLaboral> findCvbyExperiencia(Cv cv);
    
     //LOGRO
    public List<Logro> findAllLogro();
    public void saveLogro(Logro logro);
    public Logro findOneLogro (BigDecimal id);
    public void deleteLogro(BigDecimal id);
    public List<Logro> findCvbyLogro(Cv cv);
    
     //CURSO CAPACITACION
    public List<CursoCapacitacion> findAllCursoCap();
    public void saveCursoCap(CursoCapacitacion cursocapacitacion);
    public CursoCapacitacion findOneCursoCap (BigDecimal id);
    public void deleteCursoCap(BigDecimal id);
    public List<CursoCapacitacion> findCvbyCursoCap(Cv cv);

    
    //ESCRITO
    public List<Escrito> findAllEsc();
    public void saveEsc(Escrito escrito);
    public Escrito findOneEsc (BigDecimal id);
    public void deleteEsc(BigDecimal id);
    public List<Escrito> findCvbyEscrito(Cv cv);
    
    //APTITUDCV
    public List<AptitudCv> findAllAptCv();
    public void saveAptCv(AptitudCv aptitudcv);
    public AptitudCv findOneAptCv (BigDecimal id);
    public void deleteAptCv(BigDecimal id);
    public List<AptitudCv> findCvbyAptCv(Cv cv);
    
    //HABILIDADESCV
    public List<HabilidadesCv> findAllHabCv();
    public void saveHabCv(HabilidadesCv habilidadescv);
    public HabilidadesCv findOneHabCv (BigDecimal id);
    public void deleteHabCv(BigDecimal id);
    public List<HabilidadesCv> findCvbyHabCv(Cv cv);
    
    //EVENTO
    public List<Evento> findAllEvento();
    public void saveEvento(Evento evento);
    public Evento findOneEvento (BigDecimal id);
    public void deleteEvento(BigDecimal id);
    public List<Evento> findCvbyEvento(Cv cv);
    
    //FORMACION ACADEMICA
    public List<FormacionAcademica> findAllForAcad();
    public void saveForAcad(FormacionAcademica formacionacademica);
    public FormacionAcademica findOneForAcad (BigDecimal id);
    public void deleteForAcad(BigDecimal id);
    public List<FormacionAcademica> findCvbyForAcad(Cv cv);
    

    //BITACORA
    public List<Bitacora> findAllBitacora();
    public Bitacora findOneBitacora (BigDecimal id);

    //APTITUD OFERTA
    public List<AptitudOferta> findAllAptitudOfertas();
    public void saveAptitudOferta(AptitudOferta aptitudOferta);
    public AptitudOferta findOneAptitudOferta (BigDecimal id);
    public void deleteAptitudOferta (BigDecimal id);
    public List<AptitudOferta> findAptitudOfertabyOferta(Oferta oferta);
    
    //LICENCIA CANDIDATO
    public List<LicenciaCandidato> findAllLicCand();
    public void saveLicCand(LicenciaCandidato licenciacandidato);
    public LicenciaCandidato findOneLicCand (BigDecimal id);
    public void deleteLicCand(BigDecimal id);
    public List<LicenciaCandidato> findCvbyLicCand(Cv cv);
    
    //HABILIDAD LINGUISTICA CV
    public List<HabilidadLinguisticaCv> findAllHabLingCv();
    public void saveHabLingCv(HabilidadLinguisticaCv habilidadlinguisticacv);
    public HabilidadLinguisticaCv findOneHabLingCv (BigDecimal id);
    public void deleteHabLingCv(BigDecimal id);
    public List<HabilidadLinguisticaCv> findCvbyHabLingCv(Cv cv);
    
    //REFERENCIA
    public List<Referencia> findAllRef();
    public void saveRef(Referencia referencia);
    public Referencia findOneRef (BigDecimal id);
    public void deleteRef(BigDecimal id);
    public List<Referencia> findCvbyRef(Cv cv);
      
}
