package Negocio.controladores;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Dados.RepoInterfaces.IRepositorioEspecialidade;
import Dados.Repositorios.RepositorioEspecialidade;
import Negocio.beans.Especialidade;
import Negocio.beans.Instrutor;
import Negocio.controlinteface.IControlEspecialidade;

public class ControlEspecialidade implements IControlEspecialidade {

private IRepositorioEspecialidade repo;
	
	public ControlEspecialidade(){
		this.repo = new RepositorioEspecialidade();
	}
	
	@Override
	public boolean cadastrarEspecialidade(Especialidade especialidade) throws SQLException {
		return repo.cadastrarEspecialidade(especialidade);
	}

	@Override
	public List<Instrutor> buscarInstrutores(Especialidade especialidade) throws SQLException, Exception {
		return repo.buscarInstrutores(especialidade);
	}

	@Override
	public void Conectar(Connection conexao) throws Exception {
		repo.Conectar(conexao);
	}

}
