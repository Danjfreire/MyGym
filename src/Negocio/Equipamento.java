package Negocio;

public class Equipamento {
	String tipo_equip;
	String descricao;
	String cnpj_filial;
	
	
	public Equipamento(String tipo_equip, String descricao, String cnpj_filial) {
		super();
		this.tipo_equip = tipo_equip;
		this.descricao = descricao;
		this.cnpj_filial = cnpj_filial;
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
