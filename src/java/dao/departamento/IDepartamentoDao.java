/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.departamento;

import java.util.ArrayList;
import modelo.Departamento;

/**
 *
 * @author KaOs
 */
public interface IDepartamentoDao {
    
    public ArrayList<Departamento> listarTodos();
    
    public Departamento buscar(Departamento departamento);
            
}
