package br.unipe.controlead.modelo;

public class Professor {

	private Integer id;
	private String nome;
	private String cpf;
	private String identidade;
	private String telefone;
	private Integer endereco;

	public Professor(String nome, String cpf, String identidade, String telefone, Integer endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.identidade = identidade;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getIdentidade() {
		return identidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public Integer getEndereco() {
		return endereco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String toString() {
		return String.format("[Professor %d - %s - %s - %s - %s - %d]", id, nome, cpf, identidade, telefone, endereco);
	}

}