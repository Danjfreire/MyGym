package Dados.Repositorios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import Dados.RepoInterfaces.IRepositorioAtividades;
import Negocio.beans.Aluno;
import Negocio.beans.Instrutor;

public class RepositorioAtividades implements IRepositorioAtividades {

	private Connection connection;

	@Override
	public void Conectar(Connection conexao) throws SQLException {
		if (this.connection != null)
			this.connection.close();

		this.connection = conexao;
	}

	@Override
	public Instrutor buscaInstrutorAtividade(String cpfAluno) throws SQLException {

		String query = "select F.cpf, F.nome, F.sexo, F.data_contrato, F.salario, F.cnpj_filial, I.licenca "
				+ "from funcionario as F, instrutor as I, faz_atividade as FA, aluno as A "
				+ "where I.cpf = F.cpf and F.cpf = FA.cpf_instrutor and FA.cpf_aluno = A.cpf and A.cpf = ?;";

		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, cpfAluno);
		ResultSet rs = ps.executeQuery();
		Instrutor i1 = null;
		
		while (rs.next())
			i1 = preencherIntrutor(rs);

		ps.close();
		rs.close();

		return i1;
	}

	private Instrutor preencherIntrutor(ResultSet rs)throws SQLException {
		Instrutor i1;
		try {
			i1 = new Instrutor(rs.getString("cpf"), rs.getString("nome"), rs.getString("sexo").charAt(0),
					rs.getString("data_contrato"), Double.parseDouble(rs.getString("salario")),
					rs.getString("cnpj_filial"), rs.getString("licenca"));
		} catch (SQLException e) {
			throw e;
		}
		return i1;
	}

	@Override
	public Aluno buscaAlunoAtividade(String cpfAluno) throws SQLException {

		String query = "select A.cpf, A.nome, A.idade, A.endereco, A.data_nasc, A.regularizado "
				+ "from aluno as A, faz_atividade as FA " + "where A.cpf = FA.cpf_aluno and A.cpf = ?;";

		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, cpfAluno);
		ResultSet rs = ps.executeQuery();
		Aluno a1 = null;
		
		while (rs.next())
			a1 = preecherAluno(rs);
		
		ps.close();
		rs.close();
		
		return a1;
	}

	private Aluno preecherAluno(ResultSet rs) throws SQLException{
		Aluno a1;
		try{
			 a1 = new Aluno(rs.getString("cpf"), rs.getString("nome"), Integer.parseInt(rs.getString("idade"))
					, rs.getString("endereco"), rs.getString("data_nasc"), Integer.parseInt(rs.getString("regularizado")));
		}catch(SQLException e){
			throw e;
		}
		return a1;
	}

	@Override
	public List<String> buscaAtividadesPlano(String cpfAluno) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
