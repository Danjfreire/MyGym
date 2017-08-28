package Dados.Repositorios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import Dados.RepoInterfaces.IRepositorioEspecialidade;
import Negocio.beans.Aluno;
import Negocio.beans.Especialidade;
import Negocio.beans.Instrutor;
import conexao.Conexao;

public class RepositorioEspecialidade implements IRepositorioEspecialidade{
	
	public RepositorioEspecialidade() {

	}

	private Connection connection;
	
	@Override
	public void Conectar(Connection conexao) throws Exception {
		if (this.connection != null)
			this.connection.close();
		this.connection = conexao;	
	}

	@Override
	public boolean cadastrarEspecialidade(Especialidade especialidade) throws SQLException {
		String query = "insert into especialidade (descricao) value (?)";
		
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, especialidade.getDescricao());
		
		return executar(ps);
	}
	
	public List<Especialidade> listarEspecialidade() throws SQLException, Exception{
		List<Especialidade> resultado = new ArrayList<Especialidade>();
		String query;
		query = "select * from especialidade";
		
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			resultado.add(preencherEspecialidade(rs));
		}
		ps.close();
		rs.close();
		
		return resultado;
	}
	
	private Especialidade preencherEspecialidade(ResultSet rs) throws SQLException,Exception{
		Especialidade e1;
		try{
			 e1 = new Especialidade(rs.getString("descricao"));
		}catch(SQLException e){
			throw e;
		}
		return e1;
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

	@Override
	public List<Instrutor> buscarInstrutores(Especialidade especialidade) throws SQLException ,Exception{
		
		String query = " select F.cpf, F.nome, F.sexo, F.data_contrato, F.salario, F.cnpj_filial, I.licenca"
				+ " from funcionario as F, instrutor as I, especialidade as E ,"
				+ " instrutor_espec as IE where F.cpf = I.cpf and I.cpf = IE.cpf_instrutor and "
				+ "IE.cod_especialidade = E.cod and E.descricao = ?;";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setString(1, especialidade.getDescricao());
		List<Instrutor> instrutores = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			instrutores.add(preencherIntrutor(rs));
		}
		
		return instrutores;
	}
	
	private Instrutor preencherIntrutor(ResultSet rs) throws SQLException, Exception {
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

}
