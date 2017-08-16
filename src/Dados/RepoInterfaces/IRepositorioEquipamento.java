package Dados.RepoInterfaces;

import java.sql.SQLException;

import Negocio.beans.Equipamento;

public interface IRepositorioEquipamento {
	
	void Conectar(String usuario, String senha);
	boolean cadastrarEquipamento(Equipamento equipamento) throws SQLException;


}
