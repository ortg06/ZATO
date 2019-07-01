package com.zato.app.controllers;

import java.math.BigDecimal;
import java.util.Map;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.HabilidadOferta;
import com.zato.app.entidades.Oferta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("HabilidadOferta")
public class HabilidadesOfertaController {
    
     @Autowired
    private IService habOfertaService;
    @Autowired
    private IService catalogoHabilidadService; 
    @Autowired
    private IService ofertaService; 
    
    BigDecimal numof=null;
    
    HabilidadOferta habilidadesOf = new HabilidadOferta();
    //Cv cv = new Cv();
    Oferta oferta = new Oferta();
    
  
  
     @RequestMapping(value="HabilidadesOf/formhabof/{id}",method=RequestMethod.GET)
    public String crear( @PathVariable(value = "id") BigDecimal id,Map<String,Object> model)
    {
        numof=id;
        model.put("habilidadesOf", habilidadesOf);
        model.put("titulo", "Conocimientos y Habilidades");
        model.put("catHabilidad",catalogoHabilidadService.findAllCatHabilidad());
        
        return "HabilidadesOf/formhabof";
    }
    
     
    
     @RequestMapping(value="HabilidadesOf/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            habilidadesOf = habOfertaService.findOneHabilidadOferta(id);
          
        } else {
            return "redirect:/oferta/verOferta";
        }
        model.put("habilidadesCv", habilidadesOf);
        model.put("titulo", "Actualizar Conocimiento / Habilidad");
        return "HabilidadesOf/formhabof";
    } 
    
    @RequestMapping(value="HabilidadesOf/formhabof",method=RequestMethod.POST)
    public String guardar(HabilidadOferta habilidadOferta, SessionStatus status)
    {
        oferta=ofertaService.findOneOferta(numof);
        habilidadOferta.setOferta(oferta);//id cv
        
        habOfertaService.saveHabOferta(habilidadOferta);
        status.setComplete();
        
        
        return "redirect:/oferta/verOferta/"+numof;
    }
    
    
     @RequestMapping(value = "HabilidadesOf/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            habOfertaService.deleteHabOferta(id);
        }
        return "redirect:/oferta/verOferta"+numof;
    }
    
}
