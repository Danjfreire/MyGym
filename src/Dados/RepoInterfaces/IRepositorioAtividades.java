package Dados.RepoInterfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Negocio.beans.Aluno;
import Negocio.beans.Atividade;
import Negocio.beans.Instrutor;

public interface IRepositorioAtividades {

	void Conectar(Connection conexao)throws SQLException;
	Instrutor buscaInstrutorAtividade(String cpfAluno) throws SQLException;
	Aluno buscaAlunoAtividade(String cpfAluno)throws SQLException;
	List<Atividade> buscaAtividadesPlano(String cpfAluno) throws SQLException;
	
	
}
