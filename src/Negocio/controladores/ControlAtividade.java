package Negocio.controladores;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Dados.RepoInterfaces.IRepositorioAtividades;
import Dados.Repositorios.RepositorioAtividades;
import Negocio.beans.Aluno;
import Negocio.beans.Atividade;
import Negocio.beans.Instrutor;
import Negocio.beans.Plano;
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
	public List<Instrutor> buscaInstrutorAtividade(String cpfAluno) throws SQLException, Exception {
		return repo.buscaInstrutorAtividade(cpfAluno);
	}

	@Override
	public Aluno buscaAlunoAtividade(String cpfAluno) throws SQLException, Exception {
		return repo.buscaAlunoAtividade(cpfAluno);
	}

	@Override
	public List<Atividade> buscaAtividadesPlano(Plano plan) throws SQLException {
		return repo.buscaAtividadesPlano(plan);
	}

	@Override
	public boolean cadastrarPlano(String cpf, String dataInicio, String dataFim) throws SQLException {
		return repo.cadastrarPlano(cpf, dataInicio, dataFim);
	}

	@Override
	public boolean inserirAtividade(int codigo, String atividade) throws SQLException {
		return repo.inserirAtividade(codigo, atividade);
	}

	@Override
	public List<Plano> buscaPlano(String cpf) throws SQLException {
		return repo.buscaPlano(cpf);
	}

}
