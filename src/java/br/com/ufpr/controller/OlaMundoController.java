/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufpr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author danielkarling
 */
@Controller
public class OlaMundoController {
    @RequestMapping("/olaMundo")
    public String digaOla(){
        System.out.println("Ola Mundo, executando lógica com Spring MVC");
        return "ok";  //retorna o nome da pagina .jsp em WEB-INF/views
        
        
    }
   
    
}
