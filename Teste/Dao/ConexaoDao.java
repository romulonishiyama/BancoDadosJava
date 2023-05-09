package Teste.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexaoDao {

     static Connection conn;

    public static Connection conectarBD() {

        final String URL = "jdbc:mysql://localhost:3306";
        final String USER = "root";
        final String PASSWORD = "";

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Banco conectado com sucesso!");
            return conn;

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
        return null;

    }

    public static void fecharConexaoBD() throws SQLException {

        conn.close();

    }

    public static void criarBancoDeDados(Connection conn, String nomeBanco) throws SQLException{
        String sql = "CREATE DATABASE IF NOT EXISTS "+ nomeBanco;
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute();
        stmt.close();

    }

    public static void mostrarBancosExistentes(Connection conn) throws SQLException{
        String sql = "SHOW DATABASES";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute();
        stmt.close();
    }

}
