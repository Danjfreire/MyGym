package Dados.RepoInterfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Negocio.beans.Equipamento;
import Negocio.beans.Manutencao;

public interface IRepositorioEquipamento {
	
	void Conectar(Connection conexao) throws SQLException;
	boolean cadastrarEquipamento(Equipamento equipamento) throws SQLException;
	List<Equipamento> buscaEquip(Equipamento e) throws SQLException;
	List<Manutencao> buscaManutencao(String idEquip)throws SQLException;
	boolean atualizarManutencao(Manutencao m1)throws SQLException;

}
