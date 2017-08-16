package Negocio.controlinteface;

import java.sql.Connection;
import java.sql.SQLException;

import Negocio.beans.Aluno;
import Negocio.beans.Dependente;

public interface IControlAluno {

	boolean CadastrarAluno(Aluno aluno) throws SQLException;
	boolean CadastrarDependente(Dependente dependente)throws SQLException;
	void conectar(Connection conect)throws SQLException;
}
