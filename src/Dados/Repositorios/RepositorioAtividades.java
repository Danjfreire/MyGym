package Dados.Repositorios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import Dados.RepoInterfaces.IRepositorioAtividades;
import Negocio.beans.Aluno;
import Negocio.beans.Atividade;
import Negocio.beans.Instrutor;
import Negocio.beans.Plano;

public class RepositorioAtividades implements IRepositorioAtividades {

	private Connection connection;

	@Override
	public void Conectar(Connection conexao) throws SQLException {
		if (this.connection != null)
			this.connection.close();

		this.connection = conexao;
	}

	@Override
	public Instrutor buscaInstrutorAtividade(int codPlano, String atividade) throws SQLException, Exception {

		String query = "select F.cpf, F.nome, F.sexo, F.data_contrato, F.salario, F.cnpj_filial, I.licenca"
				+ " from  funcionario as F,plano as P,plano_atividade as PA, instrutor as I,"
				+ " atividade as AT, faz_Atividade as FA where  P.codigo = ? and P.codigo = PA.cod_plano and "
				+ "PA.id_atividade = AT.id and AT.descricao = ? and AT.id = FA.id_atividade and "
				+ "FA.cpf_instrutor = F.cpf and F.cpf = I.cpf;";

		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setInt(1, codPlano);
		ps.setString(2, atividade);
		ResultSet rs = ps.executeQuery();
		Instrutor i1 = null;;

		while (rs.next())
			i1 = preencherIntrutor(rs);

		ps.close();
		rs.close();

		return i1;
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

	@Override
	public Aluno buscaAlunoAtividade(String cpfAluno) throws SQLException,Exception {

		String query = "select A.cpf, A.nome, A.idade, A.endereco, A.data_nasc, A.regularizado "
				+ "from aluno as A where A.cpf = ?;";

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

	private Aluno preecherAluno(ResultSet rs) throws SQLException,Exception {
		Aluno a1;
		try {
			a1 = new Aluno(rs.getString("cpf"), rs.getString("nome"), Integer.parseInt(rs.getString("idade")),
					rs.getString("endereco"), rs.getString("data_nasc"),
					Integer.parseInt(rs.getString("regularizado")),null);
		} catch (SQLException e) {
			throw e;
		}
		return a1;
	}

	@Override
	public List<Atividade> buscaAtividadesPlano(Plano plan) throws SQLException {

		List<Atividade> resultado = new ArrayList<Atividade>();
//		String query = "select AT.descricao, AT.valor, AT.id "
//				+ "from atividade as AT, plano_atividade as PA, plano as P, contrato as C, aluno as A"
//				+ " where A.cpf = C.cpf_aluno and C.codigo = P.cod_contrato and P.codigo = PA.cod_plano and	"
//				+ "PA.id_atividade = AT.id and A.cpf = ?";
		
		String query = "select AT.descricao, AT.valor, AT.id from atividade as AT, plano_atividade as PA, plano as P "
				+ "where P.codigo = PA.cod_plano and PA.id_atividade = AT.id and P.codigo = ?;";
		
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setInt(1, plan.getCod_contrato());
		ResultSet rs = ps.executeQuery();
		Atividade a1 = null;

		while (rs.next()) {
			a1 = preecherAtividade(rs);
			resultado.add(a1);
		}
		ps.close();
		rs.close();
		
		return resultado;
	}

	private Atividade preecherAtividade(ResultSet rs) throws SQLException {
		Atividade a1;
		try {
			a1 = new Atividade(rs.getString("descricao"), Double.parseDouble(rs.getString("valor")),
					Integer.parseInt(rs.getString("id")));
		} catch (SQLException e) {
			throw e;
		}
		return a1;
	}

	@Override
	public boolean cadastrarPlano(String cpf, String dataInicio, String dataFim) throws SQLException {
		String query = "call inserirPlano(?,?,?);";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setString(1, cpf);
		ps.setString(2, dataInicio);
		ps.setString(3, dataFim);
		
		
		return executar(ps);
	}
	
	public boolean executar(PreparedStatement ps) throws SQLException {
		boolean result;

		if (ps.execute())
			result = true;
		else
			result = false;

		ps.close();
		//System.out.println("Retornou " + result);
		return result;
	}

	@Override
	public boolean inserirAtividade(int codigo, String atividade, String cpf_aluno, String cpf_instrutor) throws SQLException {
		String query = "call inserirAtividade(?,?,150.0, ?,?)";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setInt(1, codigo);
		ps.setString(2, atividade);
		ps.setString(3, cpf_aluno);
		ps.setString(4, cpf_instrutor);
		
		return executar(ps);
	}

	@Override
	public List<Plano> buscaPlano(String cpf) throws SQLException {
		
		String query = "call buscaPlano(?)";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setString(1, cpf);
		ResultSet rs = ps.executeQuery();
		List<Plano> planos = new ArrayList<>();
		
		while(rs.next()){
			Plano p1 = preencherPlano(rs);
			planos.add(p1);
		}
		
		return planos;
	}

	private Plano preencherPlano(ResultSet rs) throws SQLException{
		Plano p1;
		try {
			p1 = new Plano(rs.getInt("codigo"), rs.getString("data_inicio"), rs.getString("data_fim"), rs.getInt("cod_contrato"), rs.getDouble("valor_total"));
		} catch (SQLException e) {
			throw e;
		}
		return p1;
		
	}

	@Override
	public boolean removerAtividadePlano(Atividade a1) throws SQLException {
		
		String query = "call removerAtividade(?)";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		ps.setInt(1, a1.getId());
		
		return executar(ps);
	}

}
