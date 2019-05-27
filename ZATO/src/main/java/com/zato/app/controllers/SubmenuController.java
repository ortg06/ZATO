/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Submenu;
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
@RequestMapping("/submenu")
@SessionAttributes("submenu")
public class SubmenuController {
    @Autowired
    private IService SubmenuService;
    @Autowired
    private IService menuService; 
    
    
    
}
