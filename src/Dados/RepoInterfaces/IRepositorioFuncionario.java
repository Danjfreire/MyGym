package Dados.RepoInterfaces;

import java.sql.SQLException;

import Negocio.Funcionario;
import Negocio.Instrutor;

public interface IRepositorioFuncionario {

	void Conectar(String user, String senha);
	boolean cadastrarInstrutor(Instrutor instrutor) throws SQLException;
}
