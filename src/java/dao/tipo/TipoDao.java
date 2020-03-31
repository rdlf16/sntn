/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.tipo;

import dao.tipo.*;
import Util.ConectaBanco;
import dao.produto.ProdutoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Departamento;
import modelo.Tipo;

/**
 *
 * @author KaOs
 */
public class TipoDao implements ITipoDao {

    private static final String SELEC = "SELECT * FROM tipo;";
    private static final String BUSC = "SELECT * FROM tipo WHERE fk_departamento=?;";
    private static final String BUS = "SELECT * FROM tipo WHERE id=?;";
    private Object pstmt;
    private Connection conexao;

    @Override
    public ArrayList<Tipo> listarTodos() {
        ArrayList<Tipo> arr = new ArrayList<Tipo>();

        try {

            //Conexao
            conexao = ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(SELEC);

            //executa
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                //a cada loop
                Tipo novoTipo = new Tipo();
                novoTipo.setId(rs.getInt("id"));
                novoTipo.setDescricao(rs.getString("descricao"));
                
                //add na lista
                arr.add(novoTipo);
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
    public ArrayList<Tipo> buscar(Departamento departamento) {
        
        ArrayList<Tipo> arr = new ArrayList<Tipo>();
        
        try {

            //Conexao
            conexao = ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(BUSC);
            
            pstmt.setInt(1, departamento.getId());

                  //executa
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                //a cada loop
                Tipo novoTipo = new Tipo();
                novoTipo.setId(rs.getInt("id"));
                novoTipo.setDescricao(rs.getString("descricao"));

                //add na lista
                arr.add(novoTipo);
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
    
    public void buscarID(Tipo tipo) {
                
       try {
            //Conexao
            conexao = ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(BUS);

            pstmt.setInt(1, tipo.getId());
            //executa
            ResultSet rs = pstmt.executeQuery();

            // como a query ira retornar somente um registro, faremos o NEXT
            rs.next();

            tipo.setId(rs.getInt("id"));
            tipo.setDescricao(rs.getString("descricao"));

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

}
