package Dados.RepoInterfaces;

import java.sql.Connection;
import java.sql.SQLException;

import Negocio.beans.Instrutor;

public interface IRepositorioFuncionario {

	void Conectar(Connection conexao) throws SQLException;
	boolean cadastrarInstrutor(Instrutor instrutor) throws SQLException;
}
