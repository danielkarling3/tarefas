/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufpr.controller;

import br.com.ufpr.dao.JdbcTarefaDao;
import br.com.ufpr.modelo.Tarefa;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author danielkarling
 */
@Controller
public class TarefasController {

    
    
     @RequestMapping("/novaTarefa")
    public String formulario(){
        System.out.println("criando tarefa");
        return "formulario";  //retorna o nome da pagina .jsp em WEB-INF/views
        
        
    }
    
    
    @RequestMapping("/adicionaTarefa")
    public String adiciona(Tarefa tarefa) {
        JdbcTarefaDao dao = new JdbcTarefaDao();
        dao.adiciona(tarefa);
        return "tarefa-adicionada";
    }
}
