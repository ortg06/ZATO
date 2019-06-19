/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.ItemPrueba;
import com.zato.app.entidades.Opciones;
import com.zato.app.entidades.Prueba;
import java.math.BigDecimal;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author Oscar
 */

@Controller
@RequestMapping("/items")
@SessionAttributes("opcion")
public class OpcionesController {

    BigDecimal num = null;
    @Autowired
    private IService IService;

    @RequestMapping(value = "/opciones/nuevo/{id}", method = RequestMethod.GET)
    public String crear(@PathVariable(value = "id") BigDecimal id, Map<String, Object> model) {
        Opciones opcion = new Opciones();

        num = id;

        model.put("item", IService.findOneItem(id));
        model.put("opcion", opcion);
        model.put("titulo", "Nueva Opción");

        return "prueba/formO";
    }

    @RequestMapping(value = "/opciones/formOp", method = RequestMethod.POST)
    public String guardar(Opciones opcion, SessionStatus status) {
        ItemPrueba p = IService.findOneItem(num);
        opcion.setItemPrueba(p);
        IService.saveOpcion(opcion);
        status.setComplete();
        return "redirect:/opciones/" + num;
    }

}
