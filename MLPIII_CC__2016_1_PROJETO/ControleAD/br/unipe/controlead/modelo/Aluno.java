package br.unipe.controlead.modelo;

public class Aluno {

	private Integer id;
	private String nome;
	private String matricula;
	private String identidade;
	private String cpf;
	private String curso;
	private String cre;
	private String telefone;
	private Integer disciplina;
	private Integer endereco;

	public Aluno(String nome, String matricula, String identidade, String cpf, String curso, String cre,
			String telefone, Integer disciplina, Integer endereco) {
		this.nome = nome;
		this.matricula = matricula;
		this.identidade = identidade;
		this.cpf = cpf;
		this.curso = curso;
		this.cre = cre;
		this.telefone = telefone;
		this.disciplina = disciplina;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public Integer getId() {
		return id;
	}

	public String getIdentidade() {
		return identidade;
	}

	public String getCpf() {
		return cpf;
	}

	public String getCurso() {
		return curso;
	}

	public String getCre() {
		return cre;
	}

	public String getTelefone() {
		return telefone;
	}

	public Integer getDisciplina() {
		return disciplina;
	}

	public Integer getEndereco() {
		return endereco;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String toString() {
		return String.format("[Aluno %d - %s - %s - %s - %s - %s - %s - %s - %d - %d]", id, nome, matricula, identidade, cpf,
				curso, cre, telefone, disciplina, endereco);
	}

}