package Negocio.beans;

public class Instrutor extends Funcionario{
	
	private String licenca;
	
	public Instrutor(String cpf, String nome, char sexo, String dataContrato, double salario, String cnpjFilial,
			String licenca) throws Exception {
		super(cpf, nome, sexo, dataContrato, salario, cnpjFilial);
		this.licenca = licenca;
	}

	public String getLicensa() {
		return licenca;
	}

	
}
