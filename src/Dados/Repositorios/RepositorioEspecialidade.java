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
import conexao.Conexao;

public class RepositorioEspecialidade implements IRepositorioEspecialidade{
	
	public RepositorioEspecialidade() {

	}

	private Connection connection;
	
	@Override
	public void Conectar(String usuario, String senha) throws Exception {
		this.connection = new Conexao().getConexao(usuario, senha);		
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

}
