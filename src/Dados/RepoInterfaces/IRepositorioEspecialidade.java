package Dados.RepoInterfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Negocio.beans.Especialidade;
import Negocio.beans.Instrutor;


public interface IRepositorioEspecialidade {
	
	void Conectar(Connection conexao) throws Exception;
	boolean cadastrarEspecialidade(Especialidade especialidade) throws SQLException;
	List<Instrutor>buscarInstrutores(Especialidade especialidade) throws SQLException, Exception;


}
