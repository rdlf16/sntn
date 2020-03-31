/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.tipo;

import java.util.ArrayList;
import modelo.Departamento;
import modelo.Tipo;

/**
 *
 * @author KaOs
 */
public interface ITipoDao {
    
    public ArrayList<Tipo> listarTodos();
    
    public ArrayList<Tipo> buscar(Departamento departamento);
            
}
