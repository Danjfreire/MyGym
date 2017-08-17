package Negocio.beans;

public class Atividade {

	private String descricao;
	private double valor;
	private int id;
	
	public Atividade(String descricao, double valor, int id) {
		super();
		this.descricao = descricao;
		this.valor = valor;
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getValor() {
		return valor;
	}

	public int getId() {
		return id;
	}
	
	
	
}
