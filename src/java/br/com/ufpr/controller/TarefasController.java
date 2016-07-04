/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufpr.controller;

import br.com.ufpr.dao.JdbcTarefaDao;
import br.com.ufpr.modelo.Tarefa;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author danielkarling
 */
@Controller
public class TarefasController {

    @RequestMapping("/novaTarefa")
    public String formulario() {
        System.out.println("criando tarefa");
        return "formulario";  //retorna o nome da pagina .jsp em WEB-INF/views

    }

    @RequestMapping("/adicionaTarefa")
    public String adiciona(@Valid Tarefa tarefa, BindingResult result) {

        if (result.hasFieldErrors("descricao")) {

            return "formulario";
        }  //verifica erro em descricao

        JdbcTarefaDao dao = new JdbcTarefaDao();
        dao.adiciona(tarefa);
        return "redirect:listarTarefas";
    }

    @RequestMapping("/listarTarefas")
    public String listar(Model model) {
        JdbcTarefaDao dao = new JdbcTarefaDao();
        model.addAttribute("tarefas", dao.getLista());
        return "listarTarefas";
    }

    @RequestMapping("/removerTarefa")
    public String remover(Tarefa tarefa) {
        JdbcTarefaDao dao = new JdbcTarefaDao();
        dao.remover(tarefa);
        return "redirect:listarTarefas";
    }

    @RequestMapping("/mostraTarefa")
    public String mostra(Long id, Model model) {
        JdbcTarefaDao dao = new JdbcTarefaDao();
        Tarefa tarefa = dao.buscaTarefa(id);
        model.addAttribute("tarefa", tarefa);

        return "formularioAltera";
    }

    @RequestMapping("/alteraTarefa")
    public String altera(Tarefa tarefa) throws SQLException {
        JdbcTarefaDao dao = new JdbcTarefaDao();
        dao.alterar(tarefa);

        return "redirect:listarTarefas";
    }

//    @RequestMapping("/finalizarTarefa")
//    public void finaliza(Long id, HttpServletResponse response, Model model) throws SQLException {
//        JdbcTarefaDao dao = new JdbcTarefaDao();
//        Tarefa tarefa = dao.buscaTarefa(id);
//        tarefa.setFinalizado(true);
//        tarefa.setDataFinalizacao(Calendar.getInstance());
//        dao.alterar(tarefa);
//        model.addAttribute("tarefa", tarefa.getDataFinalizacao());
//        response.setStatus(200);
//    }
    @RequestMapping("/finalizarTarefa")
    public String finaliza(Long id, Model model) throws SQLException {
        JdbcTarefaDao dao = new JdbcTarefaDao();
        Tarefa tarefa = dao.buscaTarefa(id);
        tarefa.setFinalizado(true);
        tarefa.setDataFinalizacao(Calendar.getInstance());
        dao.alterar(tarefa);
        model.addAttribute("tarefa", tarefa);
        return "finalizado";

    }

}
