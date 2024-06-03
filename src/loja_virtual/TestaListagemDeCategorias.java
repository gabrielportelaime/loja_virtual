package loja_virtual;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import loja_virtual.dao.CategoriaDAO;
import loja_virtual.modelo.Categoria;
import loja_virtual.modelo.Produto;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDao = new CategoriaDAO(connection);
			// Duas formas de fazer:
			// 1 - Buscar todas as categorias e iterar para cada categorias buscando todos
			// os seus produtos - ineficiente O(n²)
			// 2 - Utilizar o Inner Join - O banco que trata o cruzamento das tabelas
			List<Categoria> listaDeCategorias = categoriaDao.listarComProdutos();
			listaDeCategorias.stream().forEach(ct -> {
				System.out.println(ct.getNome());
					for (Produto produto : ct.getProdutos()) {
						//Foi criado um método dentro de categoria para guardar os produtos daquela categoria
						System.out.println(ct.getNome() + "-" + produto.getNome());
					}
			});
		}
	}
}
