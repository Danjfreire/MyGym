package Negocio.controladores;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Dados.RepoInterfaces.IRepositorioEquipamento;
import Dados.Repositorios.RepositorioEquipamento;
import Negocio.beans.Equipamento;
import Negocio.beans.Manutencao;
import Negocio.controlinteface.IControlEquipamento;

public class ControlEquipamento implements IControlEquipamento{

	IRepositorioEquipamento repo;
	
	public ControlEquipamento(){
		repo = new RepositorioEquipamento();
	}
	
	@Override
	public void conectar(Connection conect) throws SQLException {
		repo.Conectar(conect);
	}
	
	@Override
	public List<Equipamento> buscaEquip(Equipamento e) throws SQLException {
		return repo.buscaEquip(e);
	}

	@Override
	public List<Manutencao> buscaManutencao(String idEquip) throws SQLException {
		return repo.buscaManutencao(idEquip);
	}

	@Override
	public boolean cadastrarEquip(Equipamento e) throws SQLException {
		return repo.cadastrarEquipamento(e);
	}

	@Override
	public boolean atualizarManutencao(Manutencao m1) throws SQLException {
		return repo.atualizarManutencao(m1);
	}

	@Override
	public boolean removerManutencao(String codigo) throws SQLException {
		return repo.removerManutencao(codigo);
	}


}
