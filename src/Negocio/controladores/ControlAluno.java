package Negocio.controladores;

import java.sql.Connection;
import java.sql.SQLException;

import Dados.RepoInterfaces.IRepositorioAluno;
import Dados.Repositorios.RepositorioAluno;
import Negocio.beans.Aluno;
import Negocio.beans.Dependente;
import Negocio.controlinteface.IControlAluno;

public class ControlAluno implements IControlAluno{

	private IRepositorioAluno repo;
	
	public ControlAluno(){
		this.repo = new RepositorioAluno();
	}

	@Override
	public boolean CadastrarAluno(Aluno aluno) throws SQLException {
		return repo.CadastrarAluno(aluno);
	}

	@Override
	public boolean CadastrarDependente(Dependente dependente) throws SQLException {
		return repo.CadastrarDependente(dependente);
	}

	@Override
	public void conectar(Connection conect) throws SQLException {
		repo.Conectar(conect);
	}
	
	
	
}
