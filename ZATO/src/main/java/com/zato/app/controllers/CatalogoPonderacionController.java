/**
 *
 * @author Alex
 */
package com.zato.app.controllers;

import java.math.BigDecimal;
import java.util.Map;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.CatalogoPonderacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("catalogoPonderacion")
public class CatalogoPonderacionController{

    @Autowired
    private IService ponderacionService;

    @RequestMapping(value = "/CatalogoPonderacion/listar", method = RequestMethod.GET)
    public String listarCatalogoPonderacion(Model model)
    {
        model.addAttribute("titulo", "Catalogo de Ponderaciones");
        model.addAttribute("catalogosPonderacion", ponderacionService.findAllPonderacion());
        return "catalogoPonderacion/listar";
    }

    @RequestMapping(value = "/CatalogoPonderacion/form",method = RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        CatalogoPonderacion catalogoPonderacion = new CatalogoPonderacion();
        model.put("catalogoPonderacion", catalogoPonderacion);
        model.put("titulo", "Datos de la Ponderacion");
        return "catalogoPonderacion/form";
    }

    @RequestMapping(value = "/CatalogoPonderacion/form/{id}")
    public String editar (@PathVariable(value = "id") BigDecimal id, Map<String,Object> model)
    {
        CatalogoPonderacion catalogoPonderacion = null;

        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {

            catalogoPonderacion = ponderacionService.findOnePonderacion(id);
        }else{
            return "redirect:/CatalogoPonderacion/listar";
        }
        model.put("catalogoPonderacion", catalogoPonderacion);
        model.put("titulo", "Editar Ponderacion");
        return "catalogoPonderacion/form";
    }

    @RequestMapping(value = "/CatalogoPonderacion/form",method = RequestMethod.POST)
    public String guardar(CatalogoPonderacion catalogoPonderacion, SessionStatus status)
    {
        ponderacionService.save(catalogoPonderacion);
        status.setComplete();
        return "redirect:/CatalogoPonderacion/listar";
    }

    @RequestMapping(value = "/CatalogoPonderacion/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") BigDecimal id)
    {
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            ponderacionService.deletePonderacion(id);
        }
        return "redirect:/CatalogoPonderacion/listar";
    }





 }