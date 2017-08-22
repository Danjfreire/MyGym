package Negocio.beans;

public class Aluno {

	private String cpf;
	private String nome;
	private int idade;
	private String endereco;
	private String data_nasc;
	private int regularizado;

	public Aluno(String cpf, String nome, int idade, String endereco, String data_nasc, int regularizado)
			throws Exception {
		super();
		checaCPF(cpf);
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
		this.data_nasc = data_nasc;
		this.regularizado = regularizado;
	}

	void checaCPF(String cpf) throws Exception{
		if(cpf.matches("[0-9]+") && cpf.length() == 11)
			this.cpf = cpf;
		else
			throw new Exception("CPF inválido");
	}
	
	
	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getData_nasc() {
		return data_nasc;
	}

	public int isRegularizado() {
		return regularizado;
	}

}
