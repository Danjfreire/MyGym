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
	public Instrutor buscaInstrutorAtividade(int codPlano, String atividade) throws SQLException, Exception {
		return repo.buscaInstrutorAtividade(codPlano, atividade);
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
	public boolean inserirAtividade(int codigo, String atividade, String cpf_aluno, String cpf_instrutor) throws SQLException {
		return repo.inserirAtividade(codigo, atividade, cpf_aluno, cpf_instrutor);
	}

	@Override
	public List<Plano> buscaPlano(String cpf) throws SQLException {
		return repo.buscaPlano(cpf);
	}

	@Override
	public boolean removerAtividadePlano(Atividade a1) throws SQLException {
		return repo.removerAtividadePlano(a1);
	}

}
