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

	private Equipamento preencherEquip(ResultSet rs) throws SQLException {
		Equipamento e1;
		try {
			e1 = new Equipamento(rs.getInt("codigo_equip"), rs.getString("tipo_equip"), rs.getString("descricao"),
					rs.getString("cnpj_filial"));
		} catch (SQLException e) {
			throw e;
		}

		return e1;
	}

	@Override
	public List<Manutencao> buscaManutencao(String idEquip) throws SQLException {

		String query1 = "select * from sofreu_manutencao where cod_equip = ?";
		PreparedStatement ps1 = (PreparedStatement) connection.prepareStatement(query1);
		ps1.setString(1, idEquip);
		ResultSet rs1 = ps1.executeQuery();

		List<Integer> IDs = new ArrayList<>();
		List<Manutencao> resultado = new ArrayList<>();

		while (rs1.next()) {
			IDs.add(rs1.getInt("cod_manutencao"));
		}

		ps1.close();
		rs1.close();
		
		for(int i = 0; i< IDs.size();i++) {
			String query2 = "select * from manutencao where cod_manutencao = ?";
			PreparedStatement ps2 = (PreparedStatement) connection.prepareStatement(query2);
			ps2.setInt(1, IDs.get(i));
			ResultSet rs2 = ps2.executeQuery();
			
			while(rs2.next()){
				resultado.add(preencherManutencao(rs2));
			}
			ps2.close();
			rs2.close();

		}
		

		return resultado;
	}

	private Manutencao preencherManutencao(ResultSet rs) throws SQLException {
		Manutencao m1;
		try {
			m1 = new Manutencao(rs.getInt("cod_manutencao"), rs.getDouble("valor"), rs.getString("protocolo"),
					rs.getString("descricao"), rs.getString("data_manutencao"), rs.getString("data_devolucao"));
		} catch (SQLException e) {
			throw e;
		}
		return m1;
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
	public boolean atualizarManutencao(Manutencao m1) throws SQLException{
		
		String query1 = "call atualizaManutencao(?,?,?,?,?,?)";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query1);
		ps.setInt(1, m1.getCod_manutencao());
		ps.setDouble(2, m1.getValor());
		ps.setString(3, m1.getProtocolo());
		ps.setString(4, m1.getDescricao());
		ps.setString(5, m1.getData_manutencao());
		ps.setString(6, m1.getData_devoluca());
		return executar(ps);
	}

}
