package fachada;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Negocio.beans.Aluno;
import Negocio.beans.Atividade;
import Negocio.beans.Dependente;
import Negocio.beans.Equipamento;
import Negocio.beans.Instrutor;
import Negocio.beans.Manutencao;
import Negocio.controladores.ControlAluno;
import Negocio.controladores.ControlAtividade;
import Negocio.controladores.ControlEquipamento;
import Negocio.controladores.ControlFuncionario;
import Negocio.controlinteface.IControlAluno;
import Negocio.controlinteface.IControlAtividade;
import Negocio.controlinteface.IControlEquipamento;
import Negocio.controlinteface.IControlFuncionario;
import conexao.Conexao;

public class Fachada implements IFachada {

	private IControlAluno controlAluno;
	private IControlFuncionario controlFuncionario;
	private IControlAtividade controlAtividades;
	private IControlEquipamento controlEquipamento;
	private static Fachada instance;

	public Fachada() {
		this.controlAluno = new ControlAluno();
		this.controlFuncionario = new ControlFuncionario();
		this.controlAtividades = new ControlAtividade();
		this.controlEquipamento = new ControlEquipamento();
	}

	public static Fachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}

	@Override
	public void conectar(String user, String senha)throws Exception {
		Connection conexao;
		try {
			conexao = new Conexao().getConexao(user, senha);
			controlAluno.conectar(conexao);
			controlFuncionario.conectar(conexao);
			controlAtividades.Conectar(conexao);
			controlEquipamento.conectar(conexao);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean CadastrarAluno(Aluno aluno) throws SQLException {
		return controlAluno.CadastrarAluno(aluno);
	}
	
	@Override
	public boolean atualizarAluno(Aluno aluno) throws SQLException {
		return controlAluno.atualizarAluno(aluno);
	}
	
	@Override
	public List<Aluno> buscaAluno(String parametro) throws SQLException,Exception {
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
	public Instrutor buscaInstrutorAtividade(String cpfAluno) throws SQLException,Exception {
		return controlAtividades.buscaInstrutorAtividade(cpfAluno);
	}

	@Override
	public Aluno buscaAlunoAtividade(String cpfAluno) throws SQLException,Exception{
		return controlAtividades.buscaAlunoAtividade(cpfAluno);
	}

	@Override
	public List<Atividade> buscaAtividadesPlano(String cpfAluno) throws SQLException {
		return controlAtividades.buscaAtividadesPlano(cpfAluno);
	}

	@Override
	public List<Equipamento> buscaEquip(Equipamento e) throws SQLException {
		return controlEquipamento.buscaEquip(e);
	}

	@Override
	public List<Manutencao> buscaManutencao(String idEquip) throws SQLException {
		return controlEquipamento.buscaManutencao(idEquip);
	}

	@Override
	public boolean cadastrarEquip(Equipamento e) throws SQLException {
		return controlEquipamento.cadastrarEquip(e);
	}


}
