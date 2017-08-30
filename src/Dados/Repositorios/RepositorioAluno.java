package Dados.Repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.mysql.jdbc.PreparedStatement;

import Dados.RepoInterfaces.IRepositorioAluno;
import Negocio.beans.Aluno;
import Negocio.beans.Dependente;

public class RepositorioAluno implements IRepositorioAluno {

	private Connection connection;

	public RepositorioAluno() {

	}

	public void Conectar(Connection conexao) throws SQLException {
		if (this.connection != null)
			this.connection.close();

		this.connection = conexao;
	}

	@Override
	public boolean CadastrarAluno(Aluno aluno) throws SQLException {

		String query = "insert into aluno (cpf, nome, idade, endereco, data_nasc, regularizado, imagem) value (?,?,?,?,?,?,?);";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);

		try {
			FileInputStream foto = new FileInputStream(aluno.getFoto());
			ps.setString(1, aluno.getCpf());
			ps.setString(2, aluno.getNome());
			ps.setString(3, String.valueOf(aluno.getIdade()));
			ps.setString(4, aluno.getEndereco());
			ps.setString(5, aluno.getData_nasc());
			ps.setString(6, String.valueOf(aluno.isRegularizado()));
			ps.setBinaryStream(7, foto, (int) aluno.getFoto().length());
		} catch (Exception ex) {

		}
		return executar(ps);
	}

	@Override
	public boolean CadastrarDependente(Dependente dependente) throws SQLException {

		String query = "START TRANSACTION;" + "insert into dependente(nome, data_nasc, cpf_responsavel) value(?,?,?);"
				+ "COMMIT;";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, dependente.getNome());
		ps.setString(2, dependente.getDataNasc());
		ps.setString(3, dependente.getCpfResponsavel());

		return executar(ps);
	}

	@Override
	public boolean atualizarAluno(Aluno aluno) throws SQLException {

		String query = "call atualizaAluno(?,?,?,?,?,?)";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, aluno.getNome());
		ps.setInt(2, aluno.getIdade());
		ps.setString(3, aluno.getEndereco());
		ps.setString(4, aluno.getData_nasc());
		ps.setString(5, String.valueOf(aluno.isRegularizado()));
		ps.setString(6, aluno.getCpf());

		// System.out.println(ps);
		return executar(ps);
	}

	@Override
	public List<Aluno> buscaAluno(String parametro) throws SQLException, Exception {
		List<Aluno> resultados = new ArrayList<Aluno>();
		String query;
		if (parametro.equals(""))
			query = "select * from aluno order by nome";
		else
			query = "select * from aluno where cpf = ?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			resultados.add(preencherAluno(rs));
		}
		ps.close();
		rs.close();

		return resultados;
	}

	public boolean executar(PreparedStatement ps) throws SQLException {
		boolean result;

		if (ps.execute())
			result = true;
		else
			result = false;

		ps.close();
		// System.out.println("Retornou " + result);
		return result;
	}

	private Aluno preencherAluno(ResultSet rs) throws SQLException, Exception {
		Aluno a1;
		try {
			Random rand = new Random();
			int aux = rand.nextInt(999999999);
			String diretorio = "FotosBusca/"+String.valueOf(aux) + ".jpeg";
			InputStream imagem = rs.getBinaryStream("imagem");
			File foto = new File(diretorio);
			java.nio.file.Files.copy(imagem, foto.toPath(), StandardCopyOption.REPLACE_EXISTING);
			imagem.close();

			a1 = new Aluno(rs.getString("cpf"), rs.getString("nome"), Integer.parseInt(rs.getString("idade")),
					rs.getString("endereco"), rs.getString("data_nasc"), Integer.parseInt(rs.getString("regularizado")),
					foto);
		} catch (SQLException e) {
			System.out.println("Deu pau");
			throw e;
		}
		return a1;
	}

	@Override
	public boolean removerAluno(String parametro) throws SQLException {

		String query = "delete from aluno where cpf = ?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, parametro);

		return executar(ps);
	}

}
