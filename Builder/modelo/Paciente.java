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
public class Paciente {
    private int codigo;
    private DadosPessoais dadosPessoais;
    private DadosFisicos dadosFisicos;
    private Documento documento;
    private Endereco endereco;
    private boolean doadorDeOrgaos;

    public Paciente(int codigo, DadosPessoais dadosPessoais, DadosFisicos dadosFisicos, Documento documento, Endereco endereco, boolean doadorDeOrgaos) {
        this.codigo = codigo;
        this.dadosPessoais = dadosPessoais;
        this.dadosFisicos = dadosFisicos;
        this.documento = documento;
        this.endereco = endereco;
        this.doadorDeOrgaos = doadorDeOrgaos;
    }   

    public Paciente() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }

    public void setDadosPessoais(DadosPessoais dadosPessoais) {
        this.dadosPessoais = dadosPessoais;
    }

    public DadosFisicos getDadosFisicos() {
        return dadosFisicos;
    }

    public void setDadosFisicos(DadosFisicos dadosFisicos) {
        this.dadosFisicos = dadosFisicos;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public boolean isDoadorDeOrgaos() {
        return doadorDeOrgaos;
    }

    public void setDoadorDeOrgaos(boolean doadorDeOrgaos) {
        this.doadorDeOrgaos = doadorDeOrgaos;
    }
    
    public String doador(){
        if(this.isDoadorDeOrgaos() == true){
            return "Sim";
        } else {
            return "Não";
        }
    }
    
    @Override
    public String toString() {
        return "---------------------- Paciente ----------------------\n" +
                             "Codigo: "+ codigo + "\n"+
                             dadosPessoais + "\n"+
                             dadosFisicos + "\n"+
                             "Doador de Orgãos: {"+this.doador()+"}\n"+
                             documento +"\n"+
                             endereco + '}';
    }
        
}
