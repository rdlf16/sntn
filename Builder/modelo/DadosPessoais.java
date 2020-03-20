/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author wolley
 */
public class DadosPessoais {
    private String nome;
    private Date dataNascimento;
    private char sexo;

    public DadosPessoais(String nome, Date dataNascimento, char sexo) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
    }

    public DadosPessoais() {
    }    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "DadosPessoais: {" + "Nome: " + nome + ", Data Nascimento: " + dataNascimento + ", Sexo: " + sexo + '}';
    }
    
    
}
