package Dados.Repositorios;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import Dados.Conexao;
import Dados.RepoInterfaces.IRepositorioEquipamento;
import Negocio.Equipamento;

public class RepositorioEquipamento implements IRepositorioEquipamento{

	private Connection connection;
	
	public RepositorioEquipamento() {
	}

	@Override
	public void Conectar(String usuario, String senha) {
		this.connection = new Conexao().getConexao(usuario, senha);				
	}

	@Override
	public boolean cadastrarEquipamento(Equipamento equipamento) throws SQLException {
		String query = "insert into equipamento (tipo_equip, descricao, cnpj_filial) values (?, ?, ?)";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, equipamento.getTipo_equip());
		ps.setString(2, equipamento.getDescricao());
		ps.setString(3, equipamento.getCnpj_filial());
		
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
