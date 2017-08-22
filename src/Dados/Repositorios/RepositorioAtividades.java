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

public class RepositorioAtividades implements IRepositorioAtividades {

	private Connection connection;

	@Override
	public void Conectar(Connection conexao) throws SQLException {
		if (this.connection != null)
			this.connection.close();

		this.connection = conexao;
	}

	@Override
	public Instrutor buscaInstrutorAtividade(String cpfAluno) throws SQLException, Exception {

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

	private Aluno preecherAluno(ResultSet rs) throws SQLException,Exception {
		Aluno a1;
		try {
			a1 = new Aluno(rs.getString("cpf"), rs.getString("nome"), Integer.parseInt(rs.getString("idade")),
					rs.getString("endereco"), rs.getString("data_nasc"),
					Integer.parseInt(rs.getString("regularizado")));
		} catch (SQLException e) {
			throw e;
		}
		return a1;
	}

	@Override
	public List<Atividade> buscaAtividadesPlano(String cpfAluno) throws SQLException {

		List<Atividade> resultado = new ArrayList<Atividade>();
		String query = "select AT.descricao, AT.valor, AT.id "
				+ "from atividade as AT, plano_atividade as PA, plano as P, contrato as C, aluno as A"
				+ " where A.cpf = C.cpf_aluno and C.codigo = P.cod_contrato and P.codigo = PA.cod_plano and	"
				+ "PA.id_atividade = AT.id and A.cpf = ?";

		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, cpfAluno);
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

}
