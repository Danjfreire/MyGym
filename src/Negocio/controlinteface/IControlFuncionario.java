package Negocio.controlinteface;

import java.sql.Connection;
import java.sql.SQLException;

import Negocio.beans.Instrutor;

public interface IControlFuncionario {
	
	boolean cadastrarInstrutor(Instrutor instrutor) throws SQLException;
	void conectar(Connection conect)throws SQLException;
}
