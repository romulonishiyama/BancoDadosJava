import java.sql.Connection;
import java.sql.SQLException;

import Teste.Dao.ConexaoDao;

public class TesteMain {

public static void main(String[] args) throws SQLException {

    Connection conexao = ConexaoDao.conectarBD();
    ConexaoDao.criarBancoDeDados(conexao, "db_rom");
    ConexaoDao.mostrarBancosExistentes(conexao);
    ConexaoDao.usarBanco("db_rom", conexao);
    // ConexaoDao.criarTabela("nome", conexao);






    ConexaoDao.fecharConexaoBD();





}
    
}
