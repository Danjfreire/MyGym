package Negocio.beans;

public class Plano {

	private int codigo;
	private String data_inicio;
	private String data_fim;
	private int cod_contrato;
	private double valor;

	public Plano(int codigo, String data_inicio, String data_fim, int cod_contrato, double valor) {
		super();
		this.codigo = codigo;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
		this.cod_contrato = cod_contrato;
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getData_inicio() {
		return data_inicio;
	}

	public String getData_fim() {
		return data_fim;
	}

	public int getCod_contrato() {
		return cod_contrato;
	}

	public double getValor() {
		return valor;
	}

	
}
