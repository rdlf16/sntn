package Util;

/**
 *
 * @author KaOs
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBanco {

    public static Connection getConexao() {
        Connection conexao = null;
        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exerciciopj", "postgres", "postgres");
        
        } catch (Exception erro2) {
            //
        }
        return conexao;
    }

}
