package Dados.RepoInterfaces;

import java.sql.SQLException;

import Negocio.beans.Especialidade;


public interface IRepositorioEspecialidade {
	
	void Conectar(String usuario, String senha) throws Exception;
	boolean cadastrarEspecialidade(Especialidade especialidade) throws SQLException;


}
