/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author wolley
 */
public class Endereco {

    private String cep;
    private String logradouro;
    private int numero;
    private String cidade;
    private String uf;

    public Endereco(String cep, String logradouro, int numero, String cidade, String uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.uf = uf;
    }

    public Endereco() {
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Endereco: {" + "CEP: " + cep + ", Logradouro: " + logradouro + ", Numero: " + numero + ", Cidade: " + cidade + ", UF: " + uf + '}';
    }

}
