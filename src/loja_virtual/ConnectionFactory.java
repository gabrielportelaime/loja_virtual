package loja_virtual;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	// Classe para criar a conexão com o banco de dados

	public DataSource dataSource;

	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");

		//Setar usuário 
		comboPooledDataSource.setUser("");
		//Setar senha do banco de dados
		comboPooledDataSource.setPassword("");
		comboPooledDataSource.setMaxPoolSize(15);
		this.dataSource = comboPooledDataSource;
	}

	public Connection recuperarConexao() throws SQLException {
		// Método para realizar a conexão
		return dataSource.getConnection();
	}
}
