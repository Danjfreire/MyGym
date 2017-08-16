package conexao;

import java.sql.SQLException;

import Dados.RepoInterfaces.IRepositorioAluno;
import Dados.RepoInterfaces.IRepositorioFuncionario;
import Dados.Repositorios.RepositorioAluno;
import Dados.Repositorios.RepositorioFuncionario;
import Negocio.beans.Instrutor;

public class Teste {

	public static void main(String[] args) {
		
		IRepositorioAluno repo = new RepositorioAluno();
		IRepositorioFuncionario repo1 = new RepositorioFuncionario();
		//repo1.Conectar("root", "");
		
		//Aluno a1 = new Aluno("11111111111", "zezinho", 20, "Rua do zezinho", "1997-02-15", 1);
		//Dependente d1 = new Dependente("11111111111", "joaozinho", "2010-10-07");
		Instrutor i1 = new Instrutor("22222222222", "Aninha", 'F', "2012-06-12", 2500.0, "11111111111111", "12345678");
		try {
			//repo.CadastrarAluno(a1);
			repo1.cadastrarInstrutor(i1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
