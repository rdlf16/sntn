/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author KaOs
 */
public class Tipo extends Objeto{
    
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Tipo(String descricao, int id) {
        super(id);
        this.descricao = descricao;
    }

    public Tipo(String descricao) {
        this.descricao = descricao;
    }

    public Tipo() {
    }
    
    
}
