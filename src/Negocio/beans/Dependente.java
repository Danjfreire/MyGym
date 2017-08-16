package Negocio.beans;

public class Dependente {

	private String cpfResponsavel;
	private String nome;
	private String dataNasc;

	public Dependente(String cpfResponsavel, String nome, String dataNasc) {
		super();
		this.cpfResponsavel = cpfResponsavel;
		this.nome = nome;
		this.dataNasc = dataNasc;
	}

	public String getCpfResponsavel() {
		return cpfResponsavel;
	}

	public String getNome() {
		return nome;
	}

	public String getDataNasc() {
		return dataNasc;
	}

}
