/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder02;

import modelo.Paciente;

/**
 *
 * @author wolley
 */
public class App {
    
    public static void main(String[] args) {
        
        Paciente paciente = PacienteBuilder.novoPacienteBuilder()
                .comNome("Jose da Silva")
                .nascidoEm("12/02/1970")
                .doSexo('M')
                .comRG("25025125-x")
                 .comCPF("333.333.333-33")
                .doTipoSanguineo("O+")
                .comPeso(92)
                .temAltura(1.90)
                .noCep("08820130")
                .noLogradouro("Avenida dos Estados")
                .noNumero(150)
                .daCidade("Mogi das Cruzes")
                .doEstado("São Paulo")
                .constroi();
        
        System.out.println(paciente);
        
    }
    
}
