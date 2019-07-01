/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Empresa;
import com.zato.app.entidades.PruebaOferta;
import com.zato.app.entidades.RolSubmenu;
import java.math.BigDecimal;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author ecampos
 */
@Controller
@RequestMapping("/pruebaoferta")
@SessionAttributes("pruebaoferta")
public class PruebaOfertaController {
    
    BigDecimal num=null;
     @Autowired
    private IService IService;
   
    
     @GetMapping("/listar")
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Listado Pruebas por oferta");
        model.addAttribute("pruebaoferta",IService.findAllPruebaOfertas());
       
        return "prueba/pruebaxoferta";
    }
    
    @RequestMapping(value="/form/{id}",method=RequestMethod.GET)
    public String crear(@PathVariable(value = "id") BigDecimal pkEmpresa, Map<String,Object> model)
    {
        Empresa empresa=IService.findOneEmpresa(pkEmpresa);
        num=pkEmpresa;
        PruebaOferta pruebaoferta = new PruebaOferta();
        model.put("pruebaoferta", pruebaoferta);
        model.put("titulo", "Asignación de pruebas");
        model.put("ofertas",IService.findOfertaByEmpresa(empresa));
        model.put("pruebas", IService.findPruebabyEmpresa(empresa));
        return "prueba/formPO";
    }
    
    @RequestMapping(value="/form",method=RequestMethod.POST)
    public String guardar(PruebaOferta pruebaoferta, SessionStatus status)
    {
        IService.savePruebaOferta(pruebaoferta);
        status.setComplete();
        return "redirect:/empresa/ver/"+num;
    }
    
    
}
