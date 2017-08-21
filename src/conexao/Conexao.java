package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import com.mysql.jdbc.Connection;

public class Conexao {

	private String projeto = "jdbc:mysql://localhost:3306/MyGym";

	public Connection getConexao(String usuario, String senha) throws Exception {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(projeto, usuario, senha);

		} catch (SQLException | ClassNotFoundException e) {
			throw e;
		}
	}
}
