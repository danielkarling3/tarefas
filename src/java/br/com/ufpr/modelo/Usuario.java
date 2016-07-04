/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufpr.modelo;

import java.io.Serializable;

/**
 *
 * @author danielkarling
 */

public class Usuario implements Serializable{

    String nome;
    String senha;
    public Usuario() {
    
    
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
