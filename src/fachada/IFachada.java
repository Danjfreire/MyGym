package fachada;

import java.sql.SQLException;

import Negocio.beans.Aluno;
import Negocio.beans.Dependente;
import Negocio.beans.Instrutor;

public interface IFachada {

	boolean CadastrarAluno(Aluno aluno) throws SQLException;
	boolean CadastrarDependente(Dependente dependente)throws SQLException;
	
	boolean cadastrarInstrutor(Instrutor instrutor) throws SQLException;
	
	void conectar(String user, String senha)throws SQLException;
}
