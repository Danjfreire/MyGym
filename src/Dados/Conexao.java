package Dados;

import java.sql.DriverManager;
import java.sql.Connection;
//import com.mysql.jdbc.Connection;

public class Conexao {

	private String projeto = "jdbc:mysql://localhost:3306/MyGym";

	public Connection getConexao(String usuario, String senha) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(projeto, usuario, senha);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
