/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.departamento;

import dao.departamento.*;
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

/**
 *
 * @author KaOs
 */
public class DepartamentoDao implements IDepartamentoDao {

    private static final String SELEC = "SELECT * FROM departamento;";
    private static final String BUSC = "SELECT * FROM departamento WHERE id=?;";
    private Object pstmt;
    private Connection conexao;

    @Override
    public ArrayList<Departamento> listarTodos() {
        
        ArrayList<Departamento> arr = new ArrayList<Departamento>();

        try {

            //Conexao
            conexao = ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(SELEC);

            //executa
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                //a cada loop
                Departamento novoDepartamento = new Departamento();
                novoDepartamento.setId(rs.getInt("id"));
                novoDepartamento.setDescricao(rs.getString("descricao"));

                //add na lista
                arr.add(novoDepartamento);
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
    public Departamento buscar(Departamento departamento) {
        
        try {

            //Conexao
            conexao = ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(BUSC);
            pstmt.setInt(1, departamento.getId());

            //executa
            ResultSet rs = pstmt.executeQuery();

            rs.next();

            departamento.setId(rs.getInt("id"));
            departamento.setDescricao(rs.getString("descricao"));

            return departamento;

        } catch (Exception ex) {

            return departamento;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
