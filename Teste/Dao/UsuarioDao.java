package Teste.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {

    public void inserirUsuario(Connection conn) throws SQLException {
        String sql = "INSERT INTO alunos (nome, email) VALUES (?, ? );";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, "Romulo Nishiyama");
        stmt.setString(2, "nishiya@gmail.com");
        stmt.execute();
        stmt.close();
    }

    public void listar(Connection conn) throws Exception {
        String sql = "SELECT * FROM alunos";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            System.out.println("ID: "+ rs.getString("id")+ ", Nome: "+ rs.getString("nome")+ ", Email: "+rs.getString("email"));
        }

    }

    public void deletar(int id, Connection conn) throws SQLException{
        String sql = "DELETE FROM ALUNOS WHERE ID=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();

        
        
    }

}
