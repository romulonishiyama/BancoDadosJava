package Teste.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDao {

  

    public void inserirUsuario(Connection conn) throws SQLException{
        String sql = "INSERT INTO TO TABLE (?) IF NOT EXISTS VALUES (?) ";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(0, sql);
        stmt.execute();
        stmt.close();
    }

    
}
