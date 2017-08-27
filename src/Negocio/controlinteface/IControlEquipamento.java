package Negocio.controlinteface;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Negocio.beans.Equipamento;
import Negocio.beans.Manutencao;

public interface IControlEquipamento {

	List<Equipamento> buscaEquip(Equipamento e) throws SQLException;
	List<Manutencao> buscaManutencao(String idEquip)throws SQLException;
	boolean cadastrarEquip(Equipamento e) throws SQLException;
	boolean atualizarManutencao(Manutencao m1) throws SQLException;
	boolean removerManutencao(String codigo) throws SQLException;
	boolean cadastrarManutencao(Manutencao m1, int cod) throws SQLException;
	void conectar(Connection conect)throws SQLException;
}
