/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.produto;

import command.ICommand;
import dao.departamento.DepartamentoDao;
import dao.produto.ProdutoDao;
import dao.tipo.TipoDao;
import java.util.ArrayList;
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
public class CadastrarProdutoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            Produto produto = new Produto();
            Situacao situacao = new Situacao();
            Departamento departamento = new Departamento();
            Tipo tipo = new Tipo();
            TipoDao tipoDao = new TipoDao();
            DepartamentoDao departamentoDao = new DepartamentoDao();

            ArrayList<Departamento> arrdepartamento = new ArrayList<Departamento>();
            ArrayList<Tipo> arrtipo = new ArrayList<Tipo>();

            arrdepartamento = departamentoDao.listarTodos();

            HttpSession session = request.getSession(); // Criando sessão para carregar as combos.
            session.setAttribute("arrdepartamento", arrdepartamento); // carregando a combo Departamento.

            produto.setDescricao(request.getParameter("txtdescricao"));
            produto.setQuantidade(Integer.parseInt(request.getParameter("txtquantidade")));
            situacao.setId(1);
            produto.setSituacao(situacao);
            departamento.setId(Integer.parseInt(request.getParameter("cmbdepartamento")));
            departamento = departamentoDao.buscar(departamento); // preenche departamento com o proprio ID e a Descrição.
            produto.setDepartamento(departamento);

            session.setAttribute("objProduto", produto); // Coloca o objeto na sessão.

            arrtipo = tipoDao.buscar(departamento); //  preenche o arr de tipo apartir do ID do Departamento.
            session.setAttribute("arrtipo", arrtipo); //  Coloca o arr tipo na sessão.

            tipo.setId(Integer.parseInt(request.getParameter("cmbtipo")));

            produto.setTipo(tipo);

            String btncadastrar = request.getParameter("btncadastrar");
            if (btncadastrar != null) {
                ProdutoDao produtodao = new ProdutoDao();

                produtodao.cadastrar(produto);
                session.removeAttribute("objProduto");

                return "sucesso.jsp";
            } else {
                return "/cadastros/produto/cadastrar_produto.jsp";
            }
        } catch (Exception ex) {
            return "/cadastros/produto/cadastrar_produto.jsp";

        }

    }

}
