/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.produto;


import java.util.ArrayList;
import modelo.Produto;

/**
 *
 * @author profe
 */
public interface IProdutodao {

    public ArrayList<Produto> listar(Produto produto);

    public void buscar(Produto produto);

    public boolean alterar(Produto produto);

    public boolean excluir(Produto produto);
    
    public boolean cadastrar(Produto produto);

}
