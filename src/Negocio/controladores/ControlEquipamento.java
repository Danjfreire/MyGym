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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Manutencao> buscaManutencao(String idEquip) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cadastrarEquip(Equipamento e) throws SQLException {
		return repo.cadastrarEquipamento(e);
	}


}
