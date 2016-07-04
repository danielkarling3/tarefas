/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufpr.dao;

import br.com.ufpr.jdbc.MysqlConectionFactory;
import br.com.ufpr.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author danielkarling
 */
public class UsuarioDao {
    private Connection connection;

    public UsuarioDao() {
        this.connection = (new MysqlConectionFactory()).getConnection();
        System.out.println("connection construido ================");
    }

    public boolean existeUsuario(Usuario user) {
        String sql = "select 1 from usuario where nome=? and senha=?";
        
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            
            
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getSenha());
            ResultSet rs= stmt.executeQuery();
            boolean result = false;
            
            if (rs.next()){
             result =rs.getInt(0) == 1;
            }
             stmt.close();
            return result;
            
            // stmt.setDate(3, new java.sql.Date(tarefa.getDataFinalizacao().getTimeInMillis()));

           // stmt.execute();
           

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException();

        }
    }

    
    
    
}
