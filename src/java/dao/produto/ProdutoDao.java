/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.produto;

import Util.ConectaBanco;
import dao.departamento.DepartamentoDao;
import dao.situacao.SituacaoDao;
import dao.tipo.TipoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Departamento;
import modelo.Produto;
import modelo.Situacao;
import modelo.Tipo;

/**
 *
 * @author KaOs
 */
public class ProdutoDao implements IProdutodao {

    private static final String SELECT_ALL = "SELECT * FROM produto where descricao ilike ?;";
    private static final String INSERT = "INSERT INTO produto(descricao,quantidade,situacao,departamento,tipo) values(?,?,?,?,?);";
    private static final String DELETE = "UPDATE produto set situacao=3 where id=?";
    private static final String BUSCAR = "SELECT * FROM produto WHERE id=?;";
    private static final String UPDATE = "UPDATE produto set descricao=?,quantidade=?,situacao=?,departamento=?,tipo=? WHERE id=?;";

    private Object pstmt;
    private Connection conexao;

    @Override
    public ArrayList<Produto> listar(Produto produto) {

        //cria uma array de obJ Produto
        ArrayList<Produto> listaProduto = new ArrayList<Produto>();

        try {

            //Conexao
            conexao = ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);

            pstmt.setString(1, "%" + produto.getDescricao() + "%");

            //executa
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                //a cada loop
                Produto novoProduto = new Produto();
                Situacao novoSituacao = new Situacao();
                SituacaoDao sitDao = new SituacaoDao();
                Departamento novoDepartamento = new Departamento();
                DepartamentoDao deptoDao = new DepartamentoDao();
                Tipo novoTipo = new Tipo();
                TipoDao tipoDao = new TipoDao();
                
                novoProduto.setId(rs.getInt("id"));
                novoProduto.setDescricao(rs.getString("descricao"));
                novoProduto.setQuantidade(rs.getInt("quantidade"));
                novoSituacao.setId(rs.getInt("situacao"));
                sitDao.buscar(novoSituacao);
                novoDepartamento.setId(rs.getInt("departamento"));
                deptoDao.buscar(novoDepartamento);
                novoTipo.setId(rs.getInt("tipo"));
                tipoDao.buscarID(novoTipo);                
                
                novoProduto.setSituacao(novoSituacao);
                novoProduto.setDepartamento(novoDepartamento);
                novoProduto.setTipo(novoTipo);

                //add na lista
                listaProduto.add(novoProduto);
            }
            return listaProduto;

        } catch (Exception ex) {

            return listaProduto;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    public void buscar(Produto produto) {

        try {
            //Conexao
            conexao = ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(BUSCAR);

            pstmt.setInt(1, produto.getId());
            //executa
            ResultSet rs = pstmt.executeQuery();

            // como a query ira retornar somente um registro, faremos o NEXT
            rs.next();

            Situacao sit = new Situacao();
            Departamento depto = new Departamento();
            Tipo tipo =  new Tipo();

            produto.setDescricao(rs.getString("descricao"));
            produto.setQuantidade(rs.getInt("quantidade"));
            sit.setId(rs.getInt("situacao"));
            depto.setId(rs.getInt("departamento"));
            tipo.setId(rs.getInt("tipo"));            
            
            SituacaoDao sitDao = new SituacaoDao();
            sitDao.buscar(sit);
            DepartamentoDao deptoDao = new DepartamentoDao();
            deptoDao.buscar(depto);
            TipoDao tipoDao = new TipoDao();
            tipoDao.buscarID(tipo);
            
            produto.setSituacao(sit);
            produto.setDepartamento(depto);
            produto.setTipo(tipo);

        } catch (Exception e) {

            //
        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public boolean alterar(Produto produto) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);

            pstmt.setString(1, produto.getDescricao());
            pstmt.setInt(2, produto.getQuantidade());
            pstmt.setInt(3, produto.getSituacao().getId());
            pstmt.setInt(4, produto.getDepartamento().getId());
            pstmt.setInt(5, produto.getTipo().getId());
            pstmt.setInt(6, produto.getId());    

            pstmt.execute();
            return true;

        } catch (Exception ex) {

            return false;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public boolean excluir(Produto produto) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(DELETE);

            pstmt.setInt(1, produto.getId());

            pstmt.execute();

            return true;

        } catch (Exception ex) {

            return false;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public boolean cadastrar(Produto produto) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(INSERT);

            pstmt.setString(1, produto.getDescricao());
            pstmt.setInt(2, produto.getQuantidade());
            pstmt.setInt(3, produto.getSituacao().getId());
            pstmt.setInt(4, produto.getDepartamento().getId());
            pstmt.setInt(5, produto.getTipo().getId());          
            
            pstmt.execute();

            return true;

        } catch (Exception ex) {

            return false;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
