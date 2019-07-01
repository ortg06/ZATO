/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import java.math.BigDecimal;
import java.util.Map;

import com.zato.app.Servicios.IService;
import com.zato.app.dao.IOfertaDao;
import com.zato.app.dao.IPruebaDao;
import com.zato.app.entidades.Empresa;
import com.zato.app.entidades.ItemPrueba;
import com.zato.app.entidades.Oferta;
import com.zato.app.entidades.Opciones;
import com.zato.app.entidades.Postulacion;
import com.zato.app.entidades.Prueba;
import com.zato.app.entidades.PruebaOferta;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author ecampos
 */
@Controller
@RequestMapping("/prueba")
@SessionAttributes("prueba")
public class PruebaController {

    BigDecimal num = null;
    BigDecimal update = null;
    @Autowired
    private IService IService;
    @Autowired
    IPruebaDao repo;
     @Autowired
    IOfertaDao repo2;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Pruebas");
        model.addAttribute("pruebas", IService.findAllPruebas());

        return "prueba/listar";
    }

    //se listan las pruebas por oferta
    @GetMapping("/listar/{id}")
    public String listar(@PathVariable(value = "id") BigDecimal id, Model model) {
        Oferta oferta = IService.findOneOferta(id);
        List<PruebaOferta> lista = IService.findPruebaOfertabyOferta(oferta);
        model.addAttribute("titulo", "Tus Pruebas para tu aplicacion:");
        model.addAttribute("pruebas", IService.findAllPruebas());
        model.addAttribute("oferta", oferta);
        model.addAttribute("pos", lista);

        return "prueba/examenes";
    }
    
     @GetMapping("/listarO/{id}")
    public String listarO(@PathVariable(value = "id") BigDecimal id, Model model) {
        Oferta oferta = IService.findOneOferta(id);
        List<PruebaOferta> lista = IService.findPruebaOfertabyOferta(oferta);
        model.addAttribute("titulo", "Agregar Prueba para la oferta"+ oferta.getCatalogoPuesto().getNombreCatalogoPuesto());
        model.addAttribute("pruebas", IService.findAllPruebas());
        model.addAttribute("oferta", oferta);
        model.addAttribute("pos", lista);

        return "prueba/listar";
    }

    //LISTADO DE PRUEBAS POR EMPRESA
    @GetMapping("/listarE/{id}")
    public String listarE(@PathVariable(value = "id") BigDecimal id, Model model) {
        Empresa empresa = IService.findOneEmpresa(id);
        List<Prueba> lista = IService.findPruebabyEmpresa(empresa);
        model.addAttribute("titulo", "Pruebas para la Empresa: ");
        model.addAttribute("pruebas", IService.findAllPruebas());
        model.addAttribute("empresa", empresa);
        model.addAttribute("pos", lista);
        return "redirect:/empresa/ver/" + empresa.getPkEmpresa();
    }

    //metodo asignar prueba por oferta 
    @RequestMapping(value = "/nuevo/{pkOferta}", method = RequestMethod.GET)
    public String crear(@PathVariable(value = "pkOferta") BigDecimal pkOferta,
            Map<String, Object> model,
            RedirectAttributes flash) {
        Oferta oferta = IService.findOneOferta(pkOferta);
        num = pkOferta;
        Prueba prueba = new Prueba();
        model.put("prueba", prueba);
        model.put("titulo", "Datos de la prueba");

        model.put("tipos", IService.findAlltipoprueba());
        return "prueba/form";
    }

    //Metodo para crear prueba por empresa
    @RequestMapping(value = "/nuevoE/{pkEmpresa}", method = RequestMethod.GET)
    public String crearE(@PathVariable(value = "pkEmpresa") BigDecimal pkEmpresa,
            Map<String, Object> model,
            RedirectAttributes flash) {
        Empresa empresa = IService.findOneEmpresa(pkEmpresa);
        num = pkEmpresa;
        Prueba prueba = new Prueba();
        model.put("prueba", prueba);
        model.put("titulo", "Datos de la prueba");

        model.put("tipos", IService.findAlltipoprueba());
        return "prueba/formE";
    }

    @RequestMapping(value = "/editar/{id}")
    public String editar(@PathVariable(value = "id") BigDecimal id, Map<String, Object> model) {
        Prueba prueba = null;

        //se compara si el ID es mayor que cero
        if (id.compareTo(BigDecimal.ZERO) > 0) {
            prueba = IService.findOnePrueba(id);

        } else {
            return "redirect:/prueba/listar";
        }

        model.put("titulo", "Editar Prueba");
        model.put("prueba", prueba);
        model.put("tipos", IService.findAlltipoprueba());
        model.put("p", prueba.getCatalogoTipoPrueba().getPkCatTipoPrueba());

        //DEBERA CAMBIARSE A EL FORM DE EMPRESA YA QUE SOLO DESDE AHI PODRA EDITARSE
        return "prueba/form";
    }

    /*
    //METODO ASIGNAR PK OFERTA PK PRUEBA EN PRUEBA_OFERTA
    @RequestMapping(value = "/asignar", method = RequestMethod.POST)
     public String asignarP(Prueba prueba, @RequestParam(name = "oferta", required = false) BigDecimal oferta, SessionStatus status) {
               
            //Procedimiento: insertarpruebaoferta
            //parametros: (pk prueba,pk oferta)
            repo.insertPruebaOferta(prueba.getPkPrueba(), num);
       
        return "redirect:/prueba/listar/" + num;
    }
     */
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(Prueba prueba, @RequestParam(name = "oferta", required = false) BigDecimal oferta, SessionStatus status) {

        IService.savePrueba(prueba);
        status.setComplete();
        List<PruebaOferta> lista = IService.findPruebaOfertabyPruebaOferta(IService.findOneOferta(num), prueba);
        if (lista.isEmpty()) {

            //Procedimiento: insertarpruebaoferta
            //parametros: (pk prueba,pk oferta)
            repo.insertPruebaOferta(prueba.getPkPrueba(), num);
        }

        return "redirect:/prueba/listar/" + num;
    }

    @RequestMapping(value = "/formE", method = RequestMethod.POST)
    public String guardarE(Prueba prueba, SessionStatus status) {

        Empresa empresa = IService.findOneEmpresa(num);
        prueba.setEmpresa(empresa);
        IService.savePrueba(prueba);
        status.setComplete();

        return "redirect:/prueba/listarE/" + num;
    }

    //METODO ASIGNAR PK OFERTA PK PRUEBA EN PRUEBA_OFERTA
    @RequestMapping(value = "/asignar", method = RequestMethod.POST)
    public String asignar(Prueba prueba, @RequestParam(name = "oferta", required = false) BigDecimal oferta, SessionStatus status) {

        //Procedimiento: insertarpruebaoferta
        //parametros: (pk prueba,pk oferta)
        repo.insertPruebaOferta(prueba.getPkPrueba(), num);

        return "redirect:/prueba/listar/" + num;
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") BigDecimal id) {
        //se compara si el ID es mayor que cero
        if (id.compareTo(BigDecimal.ZERO) > 0) {
            IService.deletePrueba(id);
        }
        return "redirect:/prueba/listarE/" + num;
    }

    //Metodos para items
    @GetMapping("/items/{id}")
    public String items(@PathVariable(value = "id") Prueba id, Model model) {
        Prueba prueba = null;
        model.addAttribute("titulo", "Listado de preguntas");
        model.addAttribute("prueba", id);
        model.addAttribute("items", IService.findItemPruebabyPrueba(id));

        return "prueba/items";
    }

//OBTENER LAS preguntas de una prueba.
    @RequestMapping(value = "candidato/{pkPrueba}", method = RequestMethod.GET)
    public String crearE(@PathVariable(value = "pkPrueba") BigDecimal pkPrueba,
            Map<String, Object> model) {

        Prueba prueba = IService.findOnePrueba(pkPrueba);//Obtengo la oferta
        // Postulacion postulacion=IService.findOnePostulacion(Pkpostulacion));//obtengo el candidato
        List<ItemPrueba> lista = IService.findItemPruebabyPrueba(prueba);
        model.put("opciones", IService.findAllOpciones());
        model.put("items", lista);
        model.put("titulo", prueba.getNombrePrueba());//envio una varible con el titulo 

        //odel.addAttribute("postulacion", postulacion);
        return "prueba/examen";
    }
    /*
    @RequestMapping(value = "/examen", method = RequestMethod.POST)
    public String guardarI(Prueba prueba, @RequestParam(name = "oferta", required = false) BigDecimal oferta, SessionStatus status) {

        IService.savePrueba(prueba);
        status.setComplete();
        List<PruebaOferta> lista = IService.findPruebaOfertabyPruebaOferta(IService.findOneOferta(num), prueba);
        if (lista.isEmpty()) {

            //Procedimiento: insertarpruebaoferta
            //parametros: (pk prueba,pk oferta)
            repo.insertPruebaOferta(prueba.getPkPrueba(), num);
        }

        return "redirect:/prueba/listar/" + num;
    }*/


 
    
    //METODO PARA ASIGANAR A RESULTADO LA PK_POSTULACION Y PK_PRUEBAOFERTA es metodo para asignar prueba a un candidato
  
    @RequestMapping(value = "asignar/{pkPostulacion}")
    public String enviar( @PathVariable(value="pkPostulacion")BigDecimal pkPostulacion){
        
        Postulacion postulacion =IService.findOnePostulacion(pkPostulacion);//Obtengo la postulacion con el pkPostulacion
        Oferta oferta=IService.findOneOferta(postulacion.getOferta().getPkOferta());//Obtengo la oferta relacionada con PkPostulacion
              
        List<PruebaOferta> lista = IService.findPruebaOfertabyOferta(oferta);
        
        for(int i=0;i<lista.size();i=i+1){
        repo2.insertResultado(postulacion.getPkPostulacion(),lista.get(i).getPkPruebaOferta());
        }
        
       return "redirect:/empresa/ver/" + oferta.getEmpresa().getPkEmpresa();
    }
     
 /*
   //Metodo para asignar pruebas a un candidato
    @GetMapping(value="asignar/{pkOferta}/{pkPostulacion}")
    public String enviar(@PathVariable(value="pkOferta") BigDecimal pkOferta, @PathVariable(value="pkPostulacion")BigDecimal pkPostulacion,
            Model model){
         
        Postulacion postulacion =IService.findOnePostulacion(pkPostulacion);
        Oferta oferta=IService.findOneOferta(pkOferta);//Obtengo la oferta
        List<PruebaOferta> lista = IService.findPruebaOfertabyOferta(oferta);
        
        
        
        return "url";
    }
     */
 /* 
    @RequestMapping(value="/items/nuevo/{id}",method=RequestMethod.GET)
    
    public String crear(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        ItemPrueba item = new ItemPrueba();
        Prueba prueba=null;
        num=id;
       
        model.put("prueba", IService.findOnePrueba(id));
        model.put("item", item);
        model.put("titulo", "Nueva pregunta");
       
        return "prueba/formI";
    }
    
    @RequestMapping(value="/items/formItems",method=RequestMethod.POST)
    public String guardar(ItemPrueba itemprueba, SessionStatus status)
    {
        Prueba p=IService.findOnePrueba(num);
        IService.saveItem(itemprueba);
        itemprueba.setPrueba(p);
        status.setComplete();
        return "redirect:/prueba/listar";
    }
     */
}
