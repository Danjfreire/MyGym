package Negocio.controladores;

import java.sql.Connection;
import java.sql.SQLException;

import Dados.RepoInterfaces.IRepositorioFuncionario;
import Dados.Repositorios.RepositorioFuncionario;
import Negocio.beans.Instrutor;
import Negocio.controlinteface.IControlFuncionario;

public class ControlFuncionario implements IControlFuncionario {

	private IRepositorioFuncionario repo;

	public ControlFuncionario() {
		this.repo = new RepositorioFuncionario();
	}

	@Override
	public boolean cadastrarInstrutor(Instrutor instrutor) throws SQLException {
		return repo.cadastrarInstrutor(instrutor);
	}

	@Override
	public void conectar(Connection conect) throws SQLException {
		repo.Conectar(conect);
	}

}
