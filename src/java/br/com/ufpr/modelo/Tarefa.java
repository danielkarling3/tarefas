package br.com.ufpr.modelo;


import java.util.Calendar;
import java.util.Locale;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

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
    @NotNull(message="{tarefa.descricao.vazia}")
    @Size(min=5, message="{tarefa.descricao.tamanhoErrado}")
    private String descricao;
    private boolean finalizado=false;
    @DateTimeFormat(pattern="dd/M/yyyy")
    private Calendar dataFinalizacao;

    public Tarefa() {
        
        
    }
   //necessita do construtor vazio e de todos os Getters e Setters para funcionar, pois eh uma JavaBeans
     

  
    
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
