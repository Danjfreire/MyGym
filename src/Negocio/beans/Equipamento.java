package Negocio.beans;

public class Equipamento {
	private int codigo;
	private String tipo_equip;
	private String descricao;
	private String cnpj_filial;
	
	
	public Equipamento(int codigo,String tipo_equip, String descricao, String cnpj_filial) {
		this.codigo=codigo;
		this.tipo_equip = tipo_equip;
		this.descricao = descricao;
		this.cnpj_filial = cnpj_filial;
	}


	public int getCodigo() {
		return codigo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getTipo_equip() {
		return tipo_equip;
	}


	public String getCnpj_filial() {
		return cnpj_filial;
	}
	
	
	
}
