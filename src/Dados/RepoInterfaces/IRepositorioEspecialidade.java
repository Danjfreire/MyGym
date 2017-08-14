package Dados.RepoInterfaces;

import java.sql.SQLException;

import Negocio.Especialidade;


public interface IRepositorioEspecialidade {
	
	void Conectar(String usuario, String senha);
	boolean cadastrarEspecialidade(Especialidade especialidade) throws SQLException;


}
