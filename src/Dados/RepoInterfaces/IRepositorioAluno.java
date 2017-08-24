package Dados.RepoInterfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Negocio.beans.Aluno;
import Negocio.beans.Dependente;

public interface IRepositorioAluno {

	void Conectar(Connection conexao)throws SQLException;
	boolean CadastrarAluno(Aluno aluno) throws SQLException;
	boolean CadastrarDependente(Dependente dependente)throws SQLException;
	boolean atualizarAluno(Aluno aluno)throws SQLException;
	List<Aluno> buscaAluno(String parametro) throws SQLException, Exception;
	boolean removerAluno(String parametro) throws SQLException;
}
