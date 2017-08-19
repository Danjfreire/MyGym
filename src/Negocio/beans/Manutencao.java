package Negocio.beans;

public class Manutencao {

	private int cod_manutencao;
	private double valor;
	private String protocolo;
	private String descricao;
	private String data_manutencao;
	private String data_devoluca;

	public Manutencao(int cod_manutencao, double valor, String protocolo, String descricao, String data_manutencao,
			String data_devoluca) {
		super();
		this.cod_manutencao = cod_manutencao;
		this.valor = valor;
		this.protocolo = protocolo;
		this.descricao = descricao;
		this.data_manutencao = data_manutencao;
		this.data_devoluca = data_devoluca;
	}

	public int getCod_manutencao() {
		return cod_manutencao;
	}

	public double getValor() {
		return valor;
	}

	public String getProtocolo() {
		return protocolo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getData_manutencao() {
		return data_manutencao;
	}

	public String getData_devoluca() {
		return data_devoluca;
	}

	
}
