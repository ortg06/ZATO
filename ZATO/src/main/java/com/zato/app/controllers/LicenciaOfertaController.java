/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Cv;
import com.zato.app.entidades.LicenciaOferta;
import com.zato.app.entidades.Oferta;

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


@Controller
@SessionAttributes("LicenciaCandidato")
public class LicenciaOfertaController {
    
      @Autowired
    private IService licenciaOfertaService;
  
    @Autowired
    private IService catalogoLicenciaService; 
    
    BigDecimal numof=null;
    
    LicenciaOferta licenciaOferta = new LicenciaOferta();
    Oferta oferta = new Oferta();
    
    
  
  
     @RequestMapping(value="LicenciaOferta/formlc/{id}",method=RequestMethod.GET)
    public String crear( @PathVariable(value = "id") BigDecimal id,Map<String,Object> model)
    {
        numof=id;
        model.put("licenciaOferta", licenciaOferta);
        model.put("titulo", "Licencia de Conducir");
        model.put("catLicencia",catalogoLicenciaService.findAllcatalogoLicencia());
        
        return "LicenciaOferta/formlc";
    }
    
     
    
     @RequestMapping(value="LicenciaOferta/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            licenciaOferta = licenciaOfertaService.findOneLicOferta(id);
          
        } else {
            return "redirect:/Cv/verCv";
        }
        model.put("licenciaOferta", licenciaOferta);
        model.put("titulo", "Actualizar Licencia de Conducir");
        return "LicenciaOferta/formlc";
    } 
    
    @RequestMapping(value="LicenciaOferta/formlc",method=RequestMethod.POST)
    public String guardar(LicenciaOferta licenciaOferta, SessionStatus status)
    {
        oferta=licenciaOfertaService.findOneOferta(numof);
        licenciaOferta.setOferta(oferta);//id cv
        
        licenciaOfertaService.saveLicOferta(licenciaOferta);
        status.setComplete();
        
        
        return "redirect:/Cv/verCv/"+numof;
    }
    
    
     @RequestMapping(value = "LicenciaOferta/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            licenciaOfertaService.deleteLicCand(id);
        }
        return "redirect:/Cv/verCv"+numof;
    }
}