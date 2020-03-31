/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author KaOs
 */
public class Produto extends Objeto{
    private String descricao;
    private int quantidade;
    private Situacao situacao;
    private Departamento departamento;
    private Tipo tipo;

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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
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

    public Produto(String descricao, int quantidade, Situacao situacao, Departamento departamento, int id) {
        super(id);
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.situacao = situacao;
        this.departamento = departamento;
    }

    public Produto(String descricao, int quantidade, Situacao situacao, Departamento departamento) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.situacao = situacao;
        this.departamento = departamento;
    }

    public Produto(String descricao, int quantidade, Situacao situacao, Departamento departamento, Tipo tipo, int id) {
        super(id);
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.situacao = situacao;
        this.departamento = departamento;
        this.tipo = tipo;
    }
        
}
