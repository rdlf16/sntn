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
public class AlterarProdutoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Produto produto = new Produto();
        Situacao sit = new Situacao();
        Departamento departamento = new Departamento();
        DepartamentoDao departamentoDao = new DepartamentoDao();
        Tipo tipo = new Tipo();
        TipoDao tipoDao = new TipoDao();
        ArrayList<Tipo> arrtipo = new ArrayList<Tipo>();

        produto.setId(Integer.parseInt(request.getParameter("id")));
        produto.setDescricao(request.getParameter("txtdescricao"));
        produto.setQuantidade(Integer.parseInt(request.getParameter("txtquantidade")));
        sit.setId(Integer.parseInt(request.getParameter("cmbsituacao")));
        departamento.setId(Integer.parseInt(request.getParameter("cmbdepartamento")));
        departamento = departamentoDao.buscar(departamento);
        tipo.setId(Integer.parseInt(request.getParameter("cmbtipo")));

        produto.setSituacao(sit);
        produto.setDepartamento(departamento);
        produto.setTipo(tipo);

        arrtipo = tipoDao.buscar(departamento);

        HttpSession session = request.getSession();
        session.removeAttribute("arrtipo");
        session.removeAttribute("objProduto");
        session.setAttribute("objProduto", produto);
        session.setAttribute("arrtipo", arrtipo);

        String btnalterar = request.getParameter("btnalterar");

        if (btnalterar != null) {
            ProdutoDao produtoDao = new ProdutoDao();
            produtoDao.alterar(produto);
            session.removeAttribute("objProduto");
            return "/ControleProduto?acao=Listar";
        } else {
            return "/cadastros/produto/alterar_produto.jsp";
        }
    }
}
