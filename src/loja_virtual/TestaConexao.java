package loja_virtual;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory criaConexao = new ConnectionFactory();
		// criaConexao é um objeto da classe ConnectionFactory
		Connection connection = criaConexao.recuperarConexao();
		// connection recebe a conexão do getConnection
		System.out.println("Fechando conexão!!!");
		connection.close();
	}
}
