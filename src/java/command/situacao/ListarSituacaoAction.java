/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.situacao;

import command.ICommand;
import dao.situacao.SituacaoDao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Situacao;

/**
 *
 * @author KaOs
 */
public class ListarSituacaoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();//Inserido comando para cria uma sessão, será utilizada pra passar o arraylist de situacao.

        ArrayList<Situacao> arrsituacao = new ArrayList<>();
        
        //arrsituacao = situacao.listarTodos();
        
        SituacaoDao sitDao = new SituacaoDao() {};
        
        arrsituacao = sitDao.listarTodos();
        
        session.setAttribute("arrsituacao", arrsituacao);
        return "ok";
    }

}
