package com.zato.app.controllers;

import java.math.BigDecimal;
import java.util.Map;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.CatalogoCategoria;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@SessionAttributes("catalogoCategoria")
 public class CategoriaController{

    @Autowired
    private IService categoriaService;

    @RequestMapping(value="/Categoria/listar",method=RequestMethod.GET)
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Listado de Categorias");
        model.addAttribute("categorias", categoriaService.findAllCategorias());
        return "categoria/listar";
    }

    @RequestMapping(value="/Categoria/form",method=RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        CatalogoCategoria catalogoCategoria = new CatalogoCategoria();
        model.put("catalogoCategoria", catalogoCategoria);
        model.put("titulo", "Datos de la Categoria");
        return "categoria/form";
    }

    @RequestMapping(value="/Categoria/form/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        CatalogoCategoria catalogoCategoria = null;
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            catalogoCategoria = categoriaService.findOneCategoria(id);
        } else {
            return "redirect:/Categoria/listar";
        }
        model.put("catalogoCategoria", catalogoCategoria);
        model.put("titulo", "Editar Categoria");
        return "categoria/form";
    }

    @RequestMapping(value="/Categoria/form",method=RequestMethod.POST)
    public String guardar(CatalogoCategoria catalogoCategoria , SessionStatus status)
    {
        
        categoriaService.saveCategoria(catalogoCategoria);
        status.setComplete();
        return "redirect:/Categoria/listar";
    }

    @RequestMapping(value = "/Categoria/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            
            categoriaService.deleteCategoria(id);
        }
        return "redirect:/Categoria/listar";
    }
 }