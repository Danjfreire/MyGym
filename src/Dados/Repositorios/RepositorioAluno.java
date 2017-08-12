package Dados.Repositorios;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import Dados.Conexao;
import Dados.RepoInterfaces.IRepositorioAluno;
import Negocio.Aluno;
import Negocio.Dependente;

public class RepositorioAluno implements IRepositorioAluno{

	private Connection connection;
	
	public RepositorioAluno(){
		
	}
	
	public void Conectar(String usuario, String senha){
		this.connection = new Conexao().getConexao(usuario, senha);
	}
	
	@Override
	public boolean CadastrarAluno(Aluno aluno) throws SQLException {
		
		String query = "insert into aluno (cpf, nome, idade, endereco, data_nasc, regularizado) value (?,?,?,?,?,?)";
		
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setString(1, aluno.getCpf());
		ps.setString(2, aluno.getNome());
		ps.setString(3, String.valueOf(aluno.getIdade()));
		ps.setString(4,aluno.getEndereco());
		ps.setString(5, aluno.getData_nasc());
		ps.setString(6, String.valueOf(aluno.isRegularizado()));
				
		return executar(ps);
	}

	@Override
	public boolean CadastrarDependente(Dependente dependente) throws SQLException {
		
		String query = "insert into dependente(nome, data_nasc, cpf_responsavel) value(?,?,?)";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setString(1, dependente.getNome());
		ps.setString(2, dependente.getDataNasc());
		ps.setString(3, dependente.getCpfResponsavel());
		
		return executar(ps);
	}
	
	public boolean executar(PreparedStatement ps) throws SQLException{
		boolean result;
		
		if(ps.execute())
			result = true;
		else
			result = false;
		
		ps.close();
		return result;
	}
	

}
