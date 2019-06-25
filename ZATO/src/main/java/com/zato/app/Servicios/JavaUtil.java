/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.Servicios;

import com.zato.app.entidades.Perfil;
import com.zato.app.entidades.Rol;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpSession;

public class JavaUtil {
  
   
    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
   /* public static String sessionToken(BigDecimal idRol){
        
        String clave="";
        if(idRol == new BigDecimal(1))
            clave = "foahoandas154984as21654f949as";
        if(idRol == new BigDecimal(2))
            clave = "46d54asc8a7a51as98das1ca5s1d9";
        if(idRol == new BigDecimal(3))
            clave = "f9d8ghfh98fg7498f1a21s69q2sda";
        
        return clave;
    }*/
    
    public static String validar(HttpSession session, String[] roles)
    {
        String retorno="";
        boolean validar = false;
        Perfil perfil = (Perfil) session.getAttribute("Perfil");
        if(perfil==null)
            retorno= "redirect:/login";
        else
        {
            Rol rol = (Rol) session.getAttribute("Rol");
            for(String r:roles)
            {
                if(rol.getPkRol().toString().equals((new BigDecimal(r).toString())))
                    validar = true;
            }
            if(!validar)
                retorno= "redirect:/sinAcceso";
            
        }
        return retorno;
    }
            
    
}

