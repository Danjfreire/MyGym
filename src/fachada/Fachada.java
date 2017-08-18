package fachada;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Negocio.beans.Aluno;
import Negocio.beans.Atividade;
import Negocio.beans.Dependente;
import Negocio.beans.Instrutor;
import Negocio.controladores.ControlAluno;
import Negocio.controladores.ControlAtividade;
import Negocio.controladores.ControlFuncionario;
import Negocio.controlinteface.IControlAluno;
import Negocio.controlinteface.IControlAtividade;
import Negocio.controlinteface.IControlFuncionario;
import conexao.Conexao;

public class Fachada implements IFachada {

	private IControlAluno controlAluno;
	private IControlFuncionario controlFuncionario;
	private IControlAtividade controlAtividades;
	private static Fachada instance;

	public Fachada() {
		this.controlAluno = new ControlAluno();
		this.controlFuncionario = new ControlFuncionario();
		this.controlAtividades = new ControlAtividade();
	}

	public static Fachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}

	@Override
	public void conectar(String user, String senha)throws SQLException {
		Connection conexao = new Conexao().getConexao(user, senha);

		controlAluno.conectar(conexao);
		controlFuncionario.conectar(conexao);
		controlAtividades.Conectar(conexao);
	}

	@Override
	public boolean CadastrarAluno(Aluno aluno) throws SQLException {
		return controlAluno.CadastrarAluno(aluno);
	}
	
	@Override
	public boolean atualizarAluno(Aluno aluno) throws SQLException {
		return controlAluno.CadastrarAluno(aluno);
	}
	
	@Override
	public List<Aluno> buscaAluno(String parametro) throws SQLException {
		return controlAluno.buscaAluno(parametro);
	}

	@Override
	public boolean CadastrarDependente(Dependente dependente) throws SQLException {
		return controlAluno.CadastrarDependente(dependente);
	}

	@Override
	public boolean cadastrarInstrutor(Instrutor instrutor) throws SQLException {
		return controlFuncionario.cadastrarInstrutor(instrutor);
	}

	@Override
	public Instrutor buscaInstrutorAtividade(String cpfAluno) throws SQLException {
		return controlAtividades.buscaInstrutorAtividade(cpfAluno);
	}

	@Override
	public Aluno buscaAlunoAtividade(String cpfAluno) throws SQLException {
		return controlAtividades.buscaAlunoAtividade(cpfAluno);
	}

	@Override
	public List<Atividade> buscaAtividadesPlano(String cpfAluno) throws SQLException {
		return controlAtividades.buscaAtividadesPlano(cpfAluno);
	}


}
