package com.zato.app.controllers;

import java.math.BigDecimal;
import java.util.Map;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Oferta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/oferta")
@SessionAttributes("oferta")
public class OfertaController{
    


    @Autowired
    private IService ofertaService;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("titulo", "Ofertas de Empleo");
        model.addAttribute("ofertas", ofertaService.findAllOfertas());
        return "Oferta/listar";
    }

    @RequestMapping(value = "/form/{id}", method = RequestMethod.GET)
    public String crear(@PathVariable(value = "id") BigDecimal id, Map<String,Object> model){
        Oferta oferta = new Oferta();
        model.put("oferta", oferta);
        model.put("titulo", "Nueva Oferta");
        model.put("empresa",ofertaService.findOneEmpresa(id));
        return "Oferta/form";
    }

    @RequestMapping(value = "/editar/{id}")
    public String editar(@PathVariable(value = "id") BigDecimal id, Map<String, Object> model){

        Oferta oferta = null;

        if(id.compareTo(BigDecimal.ZERO)>0){
            oferta = ofertaService.findOneOferta(id);
        }else{
            return "redirect:/oferta/listar";
        }

        model.put("oferta", oferta);
        model.put("titulo", "Editar Oferta");
        return "Oferta/form";
    }


    @RequestMapping(value = "/form",method = RequestMethod.POST)
    public String guardar (Oferta oferta, SessionStatus status){

        ofertaService.saveOferta(oferta);
        status.setComplete();
        return "redirect:/Oferta/listar";
    }


    @RequestMapping(value = "/eliminar/{id}")
    public String eliminar (@PathVariable(value = "id") BigDecimal id)
    {
        if (id.compareTo(BigDecimal.ZERO)>0) {
            ofertaService.deleteOferta(id);
        } 

        return "redirect:/Oferta/listar";
    }





}