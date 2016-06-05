package br.com.ufpr.modelo;


import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author danielkarling
 */
public class Tarefa {

    private Long id;
    private String descricao;
    private boolean finalizado;
    private Calendar dataFinalizacao;

    public Long getId() {
        return this.id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public boolean getFinalizado() {
        return this.finalizado;
    }

    public Calendar getDataFinalizacao() {
        return this.dataFinalizacao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public void setDataFinalizacao(Calendar data) {
        this.dataFinalizacao = data;
    }

}
