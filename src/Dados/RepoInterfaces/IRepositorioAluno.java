package Dados.RepoInterfaces;

import java.sql.Connection;
import java.sql.SQLException;

import Negocio.beans.Aluno;
import Negocio.beans.Dependente;

public interface IRepositorioAluno {

	void Conectar(Connection conexao)throws SQLException;
	boolean CadastrarAluno(Aluno aluno) throws SQLException;
	boolean CadastrarDependente(Dependente dependente)throws SQLException;
	
}
