
package com.zato.app.controllers;

import java.math.BigDecimal;
import java.util.Map;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.AptitudOferta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("AptitudOferta")
@SessionAttributes("catalogoAptitud")
public class AptitudOfertaController {

    @Autowired
    private IService aptitudOfertaService;
    BigDecimal idOf = null;
    BigDecimal idEm = null;

    @RequestMapping(value = "AptitudOferta/form2/{id}", method=RequestMethod.GET)
    public String crear(@PathVariable(value="id") BigDecimal id,Map<String,Object>model){

        idEm=id;
        AptitudOferta aptitudOferta = new AptitudOferta();
        model.put("aptitudOferta", aptitudOferta);
        model.put("titulo","Aptitudes para la Oferta");
        model.put("catalogoAptitud", aptitudOfertaService.findAllCatalogoAptitud());
        return "AptitudOferta/form";

    }


    @RequestMapping(value = "AptitudOferta/form/{id}",method = RequestMethod.GET)
    public String editar (@PathVariable(value = "id") BigDecimal id, Map <String,Object> model)
    {
        AptitudOferta aptitudOferta = new AptitudOferta();
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            aptitudOferta = aptitudOfertaService.findOneAptitudOferta(id);
          
        } else {
            return "redirect:/";
        }
        model.put("aptitudOferta", aptitudOferta);
        model.put("titulo", "Actualizar Aptitud de Oferta");
        return "AptitudOferta/form";
    }

    @RequestMapping(value="AptitudOferta/form",method=RequestMethod.POST)
    public String guardar(AptitudOferta aptitudOferta, SessionStatus status)
    {

        aptitudOferta.setOferta(aptitudOfertaService.findOneOferta(idOf));

        aptitudOfertaService.saveAptitudOferta(aptitudOferta);
        status.setComplete();
        
        
        return "redirect:/empresa/ver/"+idEm;
    }


    @RequestMapping(value = "AptitudOferta/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            aptitudOfertaService.deleteAptitudOferta(id);
        }
        return "redirect:/emmpresa/ver"+idEm;
    }

}