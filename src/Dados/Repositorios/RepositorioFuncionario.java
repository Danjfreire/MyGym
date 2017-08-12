package Dados.Repositorios;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import Dados.Conexao;
import Dados.RepoInterfaces.IRepositorioFuncionario;
import Negocio.Funcionario;
import Negocio.Instrutor;

public class RepositorioFuncionario implements IRepositorioFuncionario {

	private Connection connection;

	public RepositorioFuncionario() {

	}

	public void Conectar(String usuario, String senha) {
		this.connection = new Conexao().getConexao(usuario, senha);
	}

	private boolean cadastrarFuncionario(Funcionario funcionario) throws SQLException {
		
		String query = "insert into funcionario (cpf, nome, sexo, data_contrato, salario, cnpj_filial) value (?,?,?,?,?,?)";
		
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, funcionario.getCpf());
		ps.setString(2, funcionario.getNome());
		ps.setString(3, String.valueOf(funcionario.getSexo()));
		ps.setString(4, funcionario.getDataContrato());
		ps.setString(5, String.valueOf(funcionario.getSalario()));
		ps.setString(6, funcionario.getCnpjFilial());

		return executar(ps);
	}

	@Override
	public boolean cadastrarInstrutor(Instrutor instrutor) throws SQLException {
		
		boolean result1 = cadastrarFuncionario((Funcionario) instrutor);
		
		String query = "insert into instrutor(cpf, licenca) value(?,?)";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, instrutor.getCpf());
		ps.setString(2, instrutor.getLicensa());
		
		boolean result2 = executar(ps);
		
		if(result1 && result2)
			return true;
		else
			return false;
	}

	public boolean executar(PreparedStatement ps) throws SQLException {
		boolean result;

		if (ps.execute())
			result = true;
		else
			result = false;

		ps.close();
		return result;
	}

}
