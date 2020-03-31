/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.situacao;

import Util.ConectaBanco;
import dao.produto.ProdutoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Situacao;

/**
 *
 * @author KaOs
 */
public class SituacaoDao implements ISituacaoDao {

    private static final String SELEC = "SELECT * FROM situacao;";
    private static final String BUSC = "SELECT * FROM situacao WHERE id=?;";
    private Object pstmt;
    private Connection conexao;

    @Override
    public ArrayList<Situacao> listarTodos() {
        ArrayList<Situacao> arr = new ArrayList<Situacao>();

        try {

            //Conexao
            conexao = ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(SELEC);

            //executa
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                //a cada loop
                Situacao novoSituacao = new Situacao();
                novoSituacao.setId(rs.getInt("id"));
                novoSituacao.setDescricao(rs.getString("descricao"));

                //add na lista
                arr.add(novoSituacao);
            }
            return arr;

        } catch (Exception ex) {

            return arr;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    public Situacao buscar(Situacao situacao) {
        
        try {

            //Conexao
            conexao = ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(BUSC);
            
            pstmt.setInt(1, situacao.getId());

            //executa
            ResultSet rs = pstmt.executeQuery();

            rs.next();

            situacao.setId(rs.getInt("id"));
            situacao.setDescricao(rs.getString("descricao"));

            return situacao;

        } catch (Exception ex) {

            return situacao;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
