package Negocio.controlinteface;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Negocio.beans.Aluno;
import Negocio.beans.Dependente;

public interface IControlAluno {

	boolean CadastrarAluno(Aluno aluno) throws SQLException;
	boolean CadastrarDependente(Dependente dependente)throws SQLException;
	boolean atualizarAluno(Aluno aluno) throws SQLException;
	List<Aluno> buscaAluno(String parametro) throws SQLException,Exception;
	void conectar(Connection conect)throws SQLException;
}
