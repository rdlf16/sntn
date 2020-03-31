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
import modelo.Produto;

/**
 *
 * @author KaOs
 */
public class ExcluirProdutoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Produto produto = new Produto();

        ProdutoDao produtodao = new ProdutoDao();

        produto.setId(Integer.parseInt(request.getParameter("id")));

        if (request.getParameter("confirmaexclusao") != null) {
            if (Integer.parseInt(request.getParameter("confirmaexclusao")) == 2) {
                produtodao.excluir(produto);
                return "/ControleProduto?acao=Listar";
            }
            return "/cadastros/produto/excluir_produto.jsp";
            
        } else {

            produtodao.buscar(produto);

            HttpSession session = request.getSession();

            session.setAttribute("produto", produto);

            return "/cadastros/produto/excluir_produto.jsp";
        }
    }

}
