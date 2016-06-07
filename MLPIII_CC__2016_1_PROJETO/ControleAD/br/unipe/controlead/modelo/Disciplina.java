package br.unipe.controlead.modelo;

public class Disciplina {

	private Integer id;
	private String nome;
	private String periodo;
	private String ementa;
	private Integer professor;

	public Disciplina(String nome, String periodo, String ementa, Integer professor) {
		this.nome = nome;
		this.periodo = periodo;
		this.ementa = ementa;
		this.professor = professor;
	}

	public String getNome() {
		return nome;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPeriodo() {
		return periodo;
	}

	public Integer getId() {
		return id;
	}

	public String getEmenta() {
		return ementa;
	}

	public Integer getProfessor() {
		return professor;
	}
	
	public String toString() {
		return String.format("[Disciplina %d - %s - P%s - %s - %d]", id, nome, periodo, ementa, professor);
	}

}