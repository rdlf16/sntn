/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.produto;

import command.ICommand;
import dao.departamento.DepartamentoDao;
import dao.produto.ProdutoDao;
import dao.situacao.SituacaoDao;
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
public class BuscarProdutoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Produto produto = new Produto();
        Situacao situacao = new Situacao();
        SituacaoDao situacaoDao = new SituacaoDao();
        Departamento departamento = new Departamento();
        DepartamentoDao departamentoDao = new DepartamentoDao();
        Tipo tipo = new Tipo();
        TipoDao tipoDao = new TipoDao();        

        ArrayList<Departamento> arrdepartamento = new ArrayList<Departamento>();
        ArrayList<Tipo> arrtipo = new ArrayList<Tipo>();
        ArrayList<Situacao> arrsituacao = new ArrayList<Situacao>();

        arrdepartamento = departamentoDao.listarTodos(); //  preenche o arr de Departamento.
        arrsituacao = situacaoDao.listarTodos();
        

        HttpSession session = request.getSession(); // Criando sessão para carregar as combos.
        session.setAttribute("arrdepartamento", arrdepartamento); // carregando a combo Departamento.
        session.setAttribute("arrsituacao", arrsituacao); //  Coloca o arr tipo na sessão.

        //departamento = departamentoDao.buscar(departamento);
        //produto.setDepartamento(departamento);

        ProdutoDao produtodao = new ProdutoDao();

        produto.setId(Integer.parseInt(request.getParameter("id")));

        produtodao.buscar(produto);
        
        arrtipo = tipoDao.buscar(produto.getDepartamento());
        session.setAttribute("arrtipo", arrtipo); //  Coloca o arr tipo na sessão.
        
        session.setAttribute("objProduto", produto);

        return "/cadastros/produto/alterar_produto.jsp";

    }

}
