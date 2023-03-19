package loja_virtual;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	//Classe para criar a conexão com o banco de dados
	public Connection recuperarConexao() throws SQLException {
		//Método para realizar a conexão
		return DriverManager.
				getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "sefaz123");
		//Retorna a conexão
	}
}
