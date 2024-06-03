package loja_virtual;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		// String nome = "MousePad";
		// String descricao = "MousePad Razer";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection connection = factory.recuperarConexao()) {
			// Para não precisar fechar a connection, pode-se usar o try, as chaves fecham
			// onde seria o connection.close
			connection.setAutoCommit(false);
			try (PreparedStatement stm = connection.prepareStatement(
					"INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
				// Garante que a conexão irá ser fechada, mesmo que a aplicação apresente erro
				// O PreparedStatement é a classe que recebe uma query preparada para não
				// receber SQL Injection
				adicionarVariavel("Smart TV", "45 polegadas", stm);
				adicionarVariavel("Radio", "Radio de bateria", stm);
				connection.commit();
				// Quando todo os statements acima estiverem preparados, pode commitar a
				// transação do banco
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Rollback foi executado.");
				connection.rollback();
				// Caso alguma operação apresentar erro ou exceção, volta tudo e nenhuma
				// alteração deve ser realizada
			}
		}
	}

	public static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		stm.execute();
		try (ResultSet rst = stm.getGeneratedKeys()) {
			// stm.getGeneratedKeys irá me retornar a(s) chave(s) do que foi inserido
			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O id criado foi: " + id);
			}
		}
	}
}
