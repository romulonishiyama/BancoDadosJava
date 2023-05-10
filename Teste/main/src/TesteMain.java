package Teste.main.src;

import java.sql.Connection;

import Teste.Dao.ConexaoDao;
import Teste.Dao.UsuarioDao;

public class TesteMain {

public static void main(String[] args) throws Exception {

    
    Connection conexao = ConexaoDao.conectarBD();
    // ConexaoDao.criarBancoDeDados(conexao, "database_");
    ConexaoDao.mostrarBancosExistentes(conexao);

    ConexaoDao.usarBanco("database_", conexao);
    ConexaoDao.criarTabela("Alunos", conexao);
    ConexaoDao.mostrarTabelas(conexao);
    
    
    
    UsuarioDao usuario = new UsuarioDao();
    usuario.inserirUsuario(conexao);
    
    usuario.listarDadosDaTabela(conexao);
    usuario.alterarDados(12, conexao, "Novo Marinho");
    usuario.listarDadosDaTabela(conexao);


    // usuario.deletar(5, conexao);
    



    ConexaoDao.fecharConexaoBD();





}
    
}
