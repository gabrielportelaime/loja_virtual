package loja_virtual;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class TestaRemocao {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection conexao = factory.recuperarConexao();
		PreparedStatement stm = conexao.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
		stm.setInt(1, 17);
		stm.execute();
		Integer linhas = stm.getUpdateCount();
		System.out.println("Quantidade de linhas que foram modificadas: " + linhas);
	}
}
