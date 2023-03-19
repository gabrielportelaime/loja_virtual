package loja_virtual.modelo;

public class Produto {
	// Classe para representar o modelo do produto usado no banco de dados
	private Integer id;
	private String nome;
	private String descricao;

	public Produto(String nome, String descricao) {
		// Construtor da classe Produto, apenas precisa do nome e da descricao
		super();
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public Produto(Integer id, String nome, String descricao) {
		// Construtor da classe Produto com todos os atributos
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		// Método sobrescrito para quando for chamando o sysou com o Produto dentro,
		// mostrar id, nome e descricao
		return String.format("O produto é: %d, %s, %s", this.id, this.nome, this.descricao);
	}

}
