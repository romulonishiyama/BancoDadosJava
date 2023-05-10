package Teste.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        System.out.println("Fechamento da conexão com banco efetuada!");

        conn.close();

    }

    public static void criarBancoDeDados(Connection conn, String nomeBanco) throws SQLException {
        String sql = "CREATE DATABASE IF NOT EXISTS " + nomeBanco;
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute();
        stmt.close();

    }

    public static void mostrarBancosExistentes(Connection conn) throws SQLException {
        String sql = "SHOW DATABASES";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet valor = stmt.executeQuery();
        List<String> bancos = new ArrayList<>();

        while (valor.next()) {
            bancos.add(valor.getString("database"));
        }
        for (String banco : bancos) {
            System.out.println(banco);
        }
        stmt.close();
    }

    public static void usarBanco(String nomeBanco, Connection conn) throws SQLException {
        String sql = "USE ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
stmt.setString(1, sql);        stmt.execute();
        stmt.close();
        System.out.println("Usando banco " + nomeBanco);

    }

    public static void criarTabela(String nomeTabela, Connection conn) throws SQLException{
        String sql = "CREATE table if not exists alunos  ? ;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nomeTabela);
        stmt.execute();

        

    }

}
