package Negocio.controladores;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Dados.RepoInterfaces.IRepositorioAtividades;
import Dados.Repositorios.RepositorioAtividades;
import Negocio.beans.Aluno;
import Negocio.beans.Instrutor;
import Negocio.controlinteface.IControlAtividade;

public class ControlAtividade implements IControlAtividade{

	private IRepositorioAtividades repo;
	
	public ControlAtividade(){
		repo = new RepositorioAtividades();
	}
	
	@Override
	public void Conectar(Connection conexao) throws SQLException {
		repo.Conectar(conexao);
	}

	@Override
	public Instrutor buscaInstrutorAtividade(String cpfAluno) throws SQLException {
		return repo.buscaInstrutorAtividade(cpfAluno);
	}

	@Override
	public Aluno buscaAlunoAtividade(String cpfAluno) throws SQLException {
		return repo.buscaAlunoAtividade(cpfAluno);
	}

	@Override
	public List<String> buscaAtividadesPlano(String cpfAluno) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
