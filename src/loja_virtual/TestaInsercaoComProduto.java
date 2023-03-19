package loja_virtual;

import java.sql.Connection;
import java.sql.SQLException;

import loja_virtual.dao.ProdutoDAO;
import loja_virtual.modelo.Produto;

public class TestaInsercaoComProduto {
	public static void main(String[] args) throws SQLException {
		Produto comoda = new Produto("Cômoda", "Cômoda Vertical");
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			produtoDao.salvar(comoda);
			// Lista = produtoDao.listar();
		}
		System.out.println(comoda);
	}
}
