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
import modelo.Produto;
import modelo.Situacao;

/**
 *
 * @author alunocmc
 */
public class CadastrarProdutoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            Produto produto = new Produto();
            produto.setDescricao(request.getParameter("txtdescricao"));
            produto.setQuantidade(Integer.parseInt(request.getParameter("txtquantidade")));
            Situacao situacao = new Situacao();
            situacao.setId(1);
            produto.setSituacao(situacao);

            if (produto.getDescricao().length() == 0) {
                return "/cadastros/produto/cadastrar_produto.jsp";
            } else {

                ProdutoDao produtodao = new ProdutoDao();

                produtodao.cadastrar(produto);

                return "sucesso.jsp";
            }
        } catch (Exception ex) {
            return "/cadastros/produto/cadastrar_produto.jsp";

        }

    }

}
