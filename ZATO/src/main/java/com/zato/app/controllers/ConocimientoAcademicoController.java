package com.zato.app.controllers;

import java.math.BigDecimal;
import java.util.Map;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.ConocimientoAcademicos;
import com.zato.app.entidades.Oferta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping
@SessionAttributes("conocimientoacademico")
public class ConocimientoAcademicoController{

    @Autowired
    private IService conocimientoService;
    BigDecimal numOf=null;

    @RequestMapping(value="ConocimientoAcademico/form/{id}",method=RequestMethod.GET)
    public String crear(@PathVariable(value = "id") BigDecimal id,Map<String,Object> model)
    {
        numOf = id;
        ConocimientoAcademicos conocimientoAcademico = new ConocimientoAcademicos();

        model.put("conocimientoAcademico",conocimientoAcademico);
        model.put("gradoAcad", conocimientoService.findAllCatalogoGradoAcademico());
        model.put("titulo", "Conocimiento Academico");
        return "ConocimientoAcademico/form";
    }

    @RequestMapping(value="ConocimientoAcademico/form",method=RequestMethod.POST)
    public String guardar(ConocimientoAcademicos conocimientoAcademicos, SessionStatus status)
    {
        Oferta oferta = new Oferta();
       
        oferta=conocimientoService.findOneOferta(numOf);
        
        conocimientoAcademicos.setOferta(oferta);
       
        conocimientoService.saveConocimientoAcademico(conocimientoAcademicos);
        status.setComplete();
        
        
        return "redirect:/ver/verOferta/"+numOf;
    }


    @RequestMapping(value = "ConocimientoAcademico/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            conocimientoService.deleteConoAcad(id);
        }
        return "redirect:/ver/verOferta/"+numOf;
    }
}