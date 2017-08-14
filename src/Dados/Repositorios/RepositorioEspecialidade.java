package Dados.Repositorios;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import Dados.Conexao;
import Dados.RepoInterfaces.IRepositorioEspecialidade;
import Negocio.Especialidade;

public class RepositorioEspecialidade implements IRepositorioEspecialidade{
	
	public RepositorioEspecialidade() {

	}

	private Connection connection;
	
	@Override
	public void Conectar(String usuario, String senha) {
		this.connection = new Conexao().getConexao(usuario, senha);		
	}

	@Override
	public boolean cadastrarEspecialidade(Especialidade especialidade) throws SQLException {
		String query = "insert into especialidade (descricao) value (?)";
		
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, especialidade.getDescricao());
		
		return executar(ps);
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
