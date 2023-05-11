package Teste.main.src;
import java.sql.Connection;
import java.util.Scanner;

import Teste.Dao.ConexaoDao;
import Teste.Dao.UsuarioDao;
public class TesteMain {

public static void main(String[] args) throws Exception {

    Scanner scanner = new Scanner(System.in);
    Connection conexao = ConexaoDao.conectarBD();
    UsuarioDao u1 = new UsuarioDao();
    boolean sair = false;

    while(!sair){

        System.out.println("Digite o banco que deseja utilizar");
        ConexaoDao.mostrarBancosExistentes(conexao);
        String bd = scanner.next();
        ConexaoDao.usarBanco(bd, conexao);

        System.out.println("O que deseja fazer agora ?\n1- Mostrar tabelas\n2-Mostrar dados da tabela");
        int num = scanner.nextInt();

        if(num == 1){
            ConexaoDao.mostrarTabelas(conexao);
        }else if(num == 2){
            System.out.println("Digite o nome da tabela:");
            String nom = scanner.next();
            u1.listarDadosDaTabela(conexao, nom);
            
        }


    }














    conexao.close();
    scanner.close();
 




}
    
}
