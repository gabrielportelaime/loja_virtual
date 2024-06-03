package loja_virtual;

import java.sql.SQLException;

public class TestaPoolDeConexoes {

	public static void main(String[] args) throws SQLException {
		// Classe para testar quantas conexões podem se manter abertas no pool de
		// conexões

		ConnectionFactory connectionFactory = new ConnectionFactory();

		for (int i = 1; i <= 20; i++) {
			connectionFactory.recuperarConexao();
			System.out.println("Conexão de número: " + i);
		}

	}

}
