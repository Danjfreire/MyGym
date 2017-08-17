package fachada;

import java.sql.SQLException;
import java.util.List;

import Negocio.beans.Aluno;
import Negocio.beans.Dependente;
import Negocio.beans.Instrutor;

public interface IFachada {

	boolean CadastrarAluno(Aluno aluno) throws SQLException;
	boolean atualizarAluno(Aluno aluno) throws SQLException;
	List<Aluno> buscaAluno(String parametro) throws SQLException;
	boolean CadastrarDependente(Dependente dependente)throws SQLException;
	
	Instrutor buscaInstrutorAtividade(String cpfAluno) throws SQLException;
	Aluno buscaAlunoAtividade(String cpfAluno)throws SQLException;
	List<String> buscaAtividadesPlano(String cpfAluno) throws SQLException;
	
	boolean cadastrarInstrutor(Instrutor instrutor) throws SQLException;
	
	void conectar(String user, String senha)throws SQLException;
}
