/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufpr.dao;

import br.com.ufpr.modelo.Tarefa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import br.com.ufpr.jdbc.MysqlConectionFactory;
import java.util.ArrayList;

/**
 *
 * @author danielkarling
 */
public class JdbcTarefaDao {

    private Connection connection;

    public JdbcTarefaDao() {
        this.connection = (new MysqlConectionFactory()).getConnection();
        System.out.println("connection construido ================");
    }

    public void adiciona(Tarefa tarefa) {

        String sql = "insert into tarefa " + "(descricao,finalizado)" + "values (?,?)";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            stmt.setString(1, tarefa.getDescricao());
            stmt.setBoolean(2, false);
            // stmt.setDate(3, new java.sql.Date(tarefa.getDataFinalizacao().getTimeInMillis()));

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException();

        }
    }

    public Tarefa buscaTarefa(Long id) {
        Tarefa tarefa = new Tarefa();
        String sql = "select * from tarefa where id =" + id;

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet select = stmt.executeQuery();
            while (select.next()) {
                tarefa.setId(select.getLong("id"));
                tarefa.setDescricao(select.getString("descricao"));
                tarefa.setFinalizado(select.getBoolean("finalizado"));

                if (tarefa.getDataFinalizacao() != null) {
                    Date dataFinalizado = select.getDate("dataFinalizacao");

                    Calendar dataFinalizacao = Calendar.getInstance();
                    dataFinalizacao.setTime(dataFinalizado);
                    tarefa.setDataFinalizacao(dataFinalizacao);
                }
            }

            select.close();
            // stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException();
        }
        return tarefa;

    }

    public ArrayList<Tarefa> getLista() {
        ArrayList<Tarefa> listaTarefas = new ArrayList<Tarefa>();

        String sql = "select * from tarefa ";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet select = stmt.executeQuery();
            while (select.next()) {
                Tarefa tarefa = new Tarefa();
                tarefa.setId(select.getLong("id"));
                tarefa.setDescricao(select.getString("descricao"));
                tarefa.setFinalizado(select.getBoolean("finalizado"));
                //tarefa.setDataFinalizacao(select.getString("dataFinalizacao"));
                if (tarefa.getDataFinalizacao() != null) {
                    Date datafinalizacaoDate = select.getDate("datafinalizacao");

                    Calendar dataFinalizacao = Calendar.getInstance();
                    dataFinalizacao.setTime(datafinalizacaoDate);
                    tarefa.setDataFinalizacao(dataFinalizacao);
                }
                listaTarefas.add(tarefa);
            }

            select.close();
            // stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException();
        }

        return listaTarefas;

    }

    public void remover(Tarefa tarefa) {
        String sql = "delete from tarefa where id =" + tarefa.getId();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    public void alterar(Tarefa tarefa) throws SQLException {
        if (tarefa.getDataFinalizacao() != null) {
            String sql = "update tarefa set descricao=?,finalizado=?, dataFinalizacao=? where id ="
                    + tarefa.getId();
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, tarefa.getDescricao());
            stmt.setBoolean(2, tarefa.getFinalizado());
             stmt.setDate(3, new java.sql.Date(tarefa.getDataFinalizacao().getTimeInMillis()));
              stmt.execute();
            stmt.close();
        } else {
            String sql = "update tarefa set descricao=?,finalizado=? where id ="
                    + tarefa.getId();
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, tarefa.getDescricao());
                stmt.setBoolean(2, tarefa.getFinalizado());
                stmt.execute();
            }
        }
        

    }

    public Tarefa buscaPorId(Long id) {
        Tarefa tarefa = new Tarefa();
        String sql = "select * from contatos where id =" + id;

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet select = stmt.executeQuery();
            while (select.next()) {
                tarefa.setId(select.getLong("id"));
                tarefa.setDescricao(select.getString("descricao"));
                tarefa.setFinalizado(select.getBoolean("finalizado"));

                if (tarefa.getDataFinalizacao() != null) {
                    Date dataFinalizado = select.getDate("dataFinalizacao");

                    Calendar dataFinalizacao = Calendar.getInstance();
                    dataFinalizacao.setTime(dataFinalizado);
                    tarefa.setDataFinalizacao(dataFinalizacao);
                }
            }

            select.close();
            // stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException();
        }
        return tarefa;

    }

}
