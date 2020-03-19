/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author alunocmc
 */
public class Produto extends Objeto{
    private String descricao;
    private int quantidade;
    private Situacao situacao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Produto() {
    }

    public Produto(String descricao, int quantidade, Situacao situacao) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.situacao = situacao;
    }

    public Produto(String descricao, int quantidade, Situacao situacao, int id) {
        super(id);
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.situacao = situacao;
    }
        
}
