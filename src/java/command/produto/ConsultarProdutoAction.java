/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.produto;

import command.ICommand;
import dao.produto.ProdutoDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Departamento;
import modelo.Produto;
import modelo.Situacao;
import modelo.Tipo;

/**
 *
 * @author KaOs
 */
public class ConsultarProdutoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
 
        Produto produto = new Produto();
        Situacao situacao = new Situacao();
        Departamento departamento = new Departamento();
        Tipo tipo = new Tipo();
        
        produto.setSituacao(situacao);
        produto.setDepartamento(departamento);
        produto.setTipo(tipo);
       
        ProdutoDao produtodao = new ProdutoDao();

        produto.setId(Integer.parseInt(request.getParameter("id")));
        
        produtodao.buscar(produto);

        HttpSession session = request.getSession();

        session.setAttribute("objProduto", produto);
        
        return "/cadastros/produto/consultar_produto.jsp";
           
    }
    
}
