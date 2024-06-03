package loja_virtual;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		Statement stm = connection.createStatement(); 
		stm.execute("INSERT INTO PRODUTO (nome, descricao) VALUES ('Mouse', 'Mouse sem fio')", 
						Statement.RETURN_GENERATED_KEYS);
		//Statement.RETURN_GENERATED_KEYS possibilita recuperar a(s) chave(s) do que foi inserido no banco
		ResultSet rst = stm.getGeneratedKeys();
		//stm.getGeneratedKeys irá me retornar a(s) chave(s) do que foi inserido
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id criado foi: " + id);
		}
	}
}
