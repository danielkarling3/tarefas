/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufpr.controller;

import br.com.ufpr.dao.UsuarioDao;
import br.com.ufpr.modelo.Usuario;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author danielkarling
 */
@Controller
public class loginController {

    @RequestMapping("loginForm")
    public String form(){
        return "formularioLogin";
                
    }
    
    
    @RequestMapping("efetuaLogin")
    public String efetivaLogin(Usuario user, HttpSession session) {

        if (new UsuarioDao().existeUsuario(user)) {

            session.setAttribute("logado", user);
            return "redirect:listarTarefas";
        }

        return "usuario logado";
    }
}
