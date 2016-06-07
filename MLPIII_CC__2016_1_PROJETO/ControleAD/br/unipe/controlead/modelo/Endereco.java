package br.unipe.controlead.modelo;

public class Endereco {

	private Integer id;
	private String rua;
	private String cep;
	private String numero;
	private String estado;
	private String pais;

	public Endereco(String rua, String cep, String numero, String estado, String pais) {
		this.rua = rua;
		this.cep = cep;
		this.numero = numero;
		this.estado = estado;
		this.pais = pais;
	}

	public String getRua() {
		return rua;
	}

	public String getCep() {
		return cep;
	}

	public String getNumero() {
		return numero;
	}

	public String getEstado() {
		return estado;
	}

	public String getPais() {
		return pais;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String toString() {
		return String.format("[Endereço %d - %s - %s - %s - %s - %s]", id, rua, cep, numero, estado, pais);
	}

}