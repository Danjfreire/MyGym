package Negocio;

public class Funcionario {

	private String cpf;
	private String nome;
	private char sexo;
	private String dataContrato;
	private double salario;
	private String cnpjFilial;

	public Funcionario(String cpf, String nome, char sexo, String dataContrato, double salario, String cnpjFilial) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.sexo = sexo;
		this.dataContrato = dataContrato;
		this.salario = salario;
		this.cnpjFilial = cnpjFilial;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public char getSexo() {
		return sexo;
	}

	public String getDataContrato() {
		return dataContrato;
	}

	public double getSalario() {
		return salario;
	}

	public String getCnpjFilial() {
		return cnpjFilial;
	}

}
