package loja_virtual;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection connection = criaConexao.recuperarConexao();
		PreparedStatement stm = connection.prepareStatement("select id, nome, descricao from PRODUTO");
		// Statement é uma interface utilizada para executar instruções SQL
		// Statement é o responsável por executar os teus códigos sql no banco de dados
		stm.execute();
		// O método execute retorna false para update, delete, insert e true para quando
		// a resposta for um ResultSet
		ResultSet rst = stm.getResultSet();
		// ResultSet é a resposta do Statement para uma Query
		while (rst.next()) {
			Integer id = rst.getInt("id");
			// getInt, getString pode ser pelo label ou pela coluna no banco
			String nome = rst.getString("nome");
			String descricao = rst.getString("descricao");
			System.out.println(id);
			System.out.println(nome);
			System.out.println(descricao);
		}
		connection.close();
	}

}
