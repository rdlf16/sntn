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
public class AlterarProdutoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

       //String nomedaclasse = "command.situacao.ListarSituacaoAction";
       //Class classeAction = Class.forName(nomedaclasse);
       //ICommand comando_acao = (ICommand) classeAction.newInstance();
       //String pagina = comando_acao.executar(request, response);
        
        Produto produto = new Produto();
        Situacao sit = new Situacao();

        produto.setId(Integer.parseInt(request.getParameter("id")));
        produto.setDescricao(request.getParameter("txtdescricao"));        
        produto.setQuantidade(Integer.parseInt(request.getParameter("txtquantidade")));
        sit.setId(Integer.parseInt(request.getParameter("cmbsituacao")));
        produto.setSituacao(sit);
        

        ProdutoDao produtodao = new ProdutoDao();

        produtodao.alterar(produto);

        return "/ControleProduto?acao=Listar";

    }

}
