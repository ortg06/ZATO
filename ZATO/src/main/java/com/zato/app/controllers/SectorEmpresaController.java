/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import java.math.BigDecimal;
import java.util.Map;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.CatalogoSectorEmpresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author Alex
 */

@Controller
@SessionAttributes("catalogoSectorEmpresa")
public class SectorEmpresaController{
    @Autowired
    private IService catalogoSectorEmpresaService;

    @RequestMapping(value="/Sector/listar",method=RequestMethod.GET)
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Listado de Sectores de Empresa");
        model.addAttribute("catalogoSectorEmpresa",catalogoSectorEmpresaService.findAllSectores());
        return "sector/listar";
    }

    @RequestMapping(value="/Sector/form",method=RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        
        CatalogoSectorEmpresa catalogoSectorEmpresa = new CatalogoSectorEmpresa();
        model.put("catalogoSectorEmpresa", catalogoSectorEmpresa);
        model.put("titulo", "Datos del Sector de Empresa");
        return "sector/form";
    }

    @RequestMapping(value="/Sector/form/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        
        CatalogoSectorEmpresa catalogoSectorEmpresa = null;
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            catalogoSectorEmpresa = catalogoSectorEmpresaService.findOneSector(id);
        } else {
            return "redirect:/Sector/listar";
        }
        model.put("catalogoSectorEmpresa", catalogoSectorEmpresa);
        model.put("titulo", "Editar Sector Empresa");
        return "sector/form";
    }

    @RequestMapping(value="/Sector/form",method=RequestMethod.POST)
    public String guardar(CatalogoSectorEmpresa catalogoSectorEmpresa, SessionStatus status)
    {
        catalogoSectorEmpresaService.saveSector(catalogoSectorEmpresa);
        
        status.setComplete();
        return "redirect:/Sector/listar";
    }

    @RequestMapping(value = "/Sector/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            catalogoSectorEmpresaService.deleteSector(id);
        }
        return "redirect:/Sector/listar";
    }
}