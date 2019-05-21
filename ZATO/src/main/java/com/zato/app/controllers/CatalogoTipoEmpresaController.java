/**
 *
 * @author Alex
 */
package com.zato.app.controllers;

import java.math.BigDecimal;
import java.util.Map;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.CatalogoTipoEmpresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("catalogoTipoEmpresa")
public class CatalogoTipoEmpresaController{

    @Autowired
    private IService tipoEmpresaService;

    @RequestMapping(value = "/TipoEmpresa/listar", method = RequestMethod.GET)
    public String listarTipoEmpresa(Model model)
    {
        model.addAttribute("titulo", "Catalogo Tipos de Empresa");
        model.addAttribute("catalogoTipoEmpresa", tipoEmpresaService.findAllTipoEmpresas());
        return "tipoEmpresa/listar";
    }

    @RequestMapping(value = "/TipoEmpresa/form",method = RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        
        CatalogoTipoEmpresa catalogoTipoEmpresa = new CatalogoTipoEmpresa();
        model.put("catalogoTipoEmpresa", catalogoTipoEmpresa);
        model.put("titulo", "Datos del Tipo de Empresa");
        return "tipoEmpresa/form";
    }

    @RequestMapping(value = "/TipoEmpresa/form/{id}")
    public String editar (@PathVariable(value = "id") BigDecimal id, Map<String,Object> model)
    {
        
        CatalogoTipoEmpresa catalogoTipoEmpresa = null;

        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            catalogoTipoEmpresa = tipoEmpresaService.findOneTipoEmpresa(id);
          
        }else{
            return "redirect:/TipoEmpresa/listar";
        }
        model.put("catalogoTipoEmpresa", catalogoTipoEmpresa);
        model.put("titulo", "Editar Tipo de Empresa");
        return "tipoEmpresa/form";
    }

    @RequestMapping(value = "/TipoEmpresa/form",method = RequestMethod.POST)
    public String guardar(CatalogoTipoEmpresa catalogoTipoEmpresa, SessionStatus status)
    {
        
        tipoEmpresaService.saveTipoEmpresa(catalogoTipoEmpresa);
        status.setComplete();
        return "redirect:/TipoEmpresa/listar";
    }

    @RequestMapping(value = "/TipoEmpresa/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") BigDecimal id)
    {
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            tipoEmpresaService.deleteTipoEmpresa(id);
        }
        return "redirect:/TipoEmpresa/listar";
    }

}