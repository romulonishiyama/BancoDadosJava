package Teste.main.src;

import java.sql.Connection;

import Teste.Dao.ConexaoDao;
import Teste.Dao.UsuarioDao;

public class TesteMain {

public static void main(String[] args) throws Exception {

    
    Connection conexao = ConexaoDao.conectarBD();
    // ConexaoDao.criarBancoDeDados(conexao, "database_data3");
    // ConexaoDao.mostrarBancosExistentes(conexao);
    ConexaoDao.usarBanco("base", conexao);
    // ConexaoDao.criarTabela("Alunos", conexao);
    ConexaoDao.mostrarTabelas(conexao);
    
    
    
    UsuarioDao usuario = new UsuarioDao();
    usuario.inserirUsuario(conexao);
    
    usuario.listar(conexao);

    usuario.deletar(5, conexao);
    



    ConexaoDao.fecharConexaoBD();





}
    
}
