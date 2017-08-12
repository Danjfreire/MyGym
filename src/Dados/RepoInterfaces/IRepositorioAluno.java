package Dados.RepoInterfaces;

import java.sql.SQLException;

import Negocio.Aluno;
import Negocio.Dependente;

public interface IRepositorioAluno {

	void Conectar(String user, String senha);
	boolean CadastrarAluno(Aluno aluno) throws SQLException;
	boolean CadastrarDependente(Dependente dependente)throws SQLException;
	
}
