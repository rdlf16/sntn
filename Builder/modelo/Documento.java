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
public class Documento {
    private String cpf;
    private String rg;

    public Documento(String cpf, String rg) {
        this.cpf = cpf;
        this.rg = rg;
    }

    public Documento() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return "Documento: {" + "CPF: " + cpf + ", RG: " + rg + '}';
    }   
    
}
