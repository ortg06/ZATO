/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import com.zato.app.Servicios.IService;
import com.zato.app.dao.IEmpresaDao;
import com.zato.app.entidades.Empresa;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author ecampos
 */
@Controller
@RequestMapping("empresa")
@SessionAttributes("empresa")
public class EmpresaController {

    BigDecimal num = null;
    @Autowired
    private IService IService;
    @Autowired
    private IService Sector;
    @Autowired
    IEmpresaDao repo;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Empresas Registradas");
        model.addAttribute("empresas", IService.findAllempresa());

        return "empresa/listar";
    }

    @GetMapping(value = "/ver/{id}")
    public String ver(@PathVariable(value = "id") BigDecimal id, Map<String, Object> model) {

        Empresa empresa = IService.findOneEmpresa(id);
        int blobLenght;
        try {
            if (empresa.getLogoEmpresa() != null) {
                blobLenght = (int) empresa.getLogoEmpresa().length();
                byte[] blobAsBytes = empresa.getLogoEmpresa().getBytes(1, blobLenght);
                String img = Base64.encodeBase64String(blobAsBytes);
                model.put("imagen", img);
            }

            model.put("empresa", empresa);

            model.put("titulo", "Detalle de Empresa: " + empresa.getNomEmpresa());
            model.put("sectores", Sector.findAllSectores());
            model.put("tipos", IService.findAllTipoEmpresas());
            model.put("municipios", IService.findAllmun());
            model.put("tp", empresa.getCatalogoTipoEmpresa().getPkTipoEmpresa());
            model.put("s", empresa.getCatalogoSectorEmpresa().getPkSector());
            model.put("p", empresa.getMunicipio().getPkMunicipio());
            model.put("ofertas", IService.findOfertaByEmpresa(empresa));

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "empresa/ver";
    }

    @RequestMapping(value = "/nuevo", method = RequestMethod.GET)
    public String crear(Map<String, Object> model) {
        Empresa empresa = new Empresa();
        model.put("empresa", empresa);
        model.put("titulo", "Datos de la Empresa");
        model.put("sectores", Sector.findAllSectores());
        model.put("tipos", IService.findAllTipoEmpresas());
        model.put("municipios", IService.findAllmun());

        return "empresa/formEmp";
    }

    @RequestMapping(value = "/editar/{id}")
    public String editar(@PathVariable(value = "id") BigDecimal id, Map<String, Object> model) {
        Empresa empresa = null;

        // se compara si el ID es mayor que cero
        if (id.compareTo(BigDecimal.ZERO) > 0) {
            empresa = IService.findOneEmpresa(id);

        } else {
            return "redirect:/empresa/listar";
        }
        model.put("empresa", empresa);
        model.put("titulo", "Datos de la Empresa");
        model.put("sectores", Sector.findAllSectores());
        model.put("tipos", IService.findAllTipoEmpresas());
        model.put("municipios", IService.findAllmun());
        model.put("tp", empresa.getCatalogoTipoEmpresa().getPkTipoEmpresa());
        model.put("s", empresa.getCatalogoSectorEmpresa().getPkSector());
        model.put("p", empresa.getMunicipio().getPkMunicipio());
        return "empresa/formEmp";
    }

    @RequestMapping(value = "/formEmp", method = RequestMethod.POST)
    public String guardar(Empresa empresa, @RequestParam("file") MultipartFile foto, SessionStatus status) {
        if (!foto.isEmpty()) {

            try {

                byte[] content = foto.getBytes();
                Blob blob = new SerialBlob(content);
                empresa.setLogoEmpresa(blob);
                IService.saveEmpresa(empresa);
                status.setComplete();
                // Procedimiento: ACTUALIZARPERFILEMPRESA
                // parametros: (pk empresa,pk perfil)
                repo.updatePerfilEmpresa(empresa.getPkEmpresa(), num);
            } catch (IOException e) {

                e.printStackTrace();
            } catch (SerialException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        //Procedimiento: ACTUALIZARPERFILEMPRESA
        //parametros: (pk empresa,pk perfil)
        repo.updatePerfilEmpresa(empresa.getPkEmpresa(), num);
        //IService.saveEmpresa(empresa);
        status.setComplete();

        return "redirect:/empresa/ver/" + num;
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") BigDecimal id) {
        //se compara si el ID es mayor que cero
        if (id.compareTo(BigDecimal.ZERO) > 0) {
            IService.deleteEmpresa(id);
        }
        return "redirect:/empresa/listar";
    }

    @RequestMapping(value = "/nuevo/{id}", method = RequestMethod.GET)
    public String crear(@PathVariable(value = "id") BigDecimal id, Map<String, Object> model) {
        Empresa empresa = new Empresa();
        num = id;
        model.put("empresa", empresa);
        model.put("titulo", "Datos de la Empresa");
        model.put("sectores", Sector.findAllSectores());
        model.put("tipos", IService.findAllTipoEmpresas());
        model.put("municipios", IService.findAllmun());

        return "empresa/formEmp";
    }

}
