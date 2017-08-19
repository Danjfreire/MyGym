package Dados.Repositorios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import Dados.RepoInterfaces.IRepositorioEquipamento;
import Negocio.beans.Equipamento;
import Negocio.beans.Manutencao;
import conexao.Conexao;

public class RepositorioEquipamento implements IRepositorioEquipamento {

	private Connection connection;

	public RepositorioEquipamento() {
	}

	@Override
	public void Conectar(Connection conexao) throws SQLException {
		if (this.connection != null)
			this.connection.close();
		this.connection = conexao;
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

	@Override
	public List<Equipamento> buscaEquip(Equipamento e) throws SQLException {
		String query = "select * from equipamento";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();

		List<Equipamento> resultado = new ArrayList<>();
		while (rs.next()) {
			resultado.add(preencherEquip(rs));
		}
		ps.close();
		rs.close();
		
		return resultado;
	}

	private Equipamento preencherEquip(ResultSet rs)throws SQLException {
		Equipamento e1;
		try{
			e1 = new Equipamento(rs.getString("tipo_equip"), rs.getString("descricao"), rs.getString("cnpj_filial"));
		}catch(SQLException e){
			throw e;
		}
		
		return e1;
	}

	@Override
	public List<Manutencao> buscaManutencao(String idEquip) throws SQLException {
		// TODO Auto-generated method stub
		return null;
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
