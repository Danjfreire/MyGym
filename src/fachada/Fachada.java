package fachada;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Negocio.beans.Aluno;
import Negocio.beans.Atividade;
import Negocio.beans.Dependente;
import Negocio.beans.Equipamento;
import Negocio.beans.Especialidade;
import Negocio.beans.Instrutor;
import Negocio.beans.Manutencao;
import Negocio.beans.Plano;
import Negocio.controladores.ControlAluno;
import Negocio.controladores.ControlAtividade;
import Negocio.controladores.ControlEquipamento;
import Negocio.controladores.ControlEspecialidade;
import Negocio.controladores.ControlFuncionario;
import Negocio.controlinteface.IControlAluno;
import Negocio.controlinteface.IControlAtividade;
import Negocio.controlinteface.IControlEquipamento;
import Negocio.controlinteface.IControlEspecialidade;
import Negocio.controlinteface.IControlFuncionario;
import conexao.Conexao;

public class Fachada implements IFachada {

	private IControlAluno controlAluno;
	private IControlFuncionario controlFuncionario;
	private IControlAtividade controlAtividades;
	private IControlEquipamento controlEquipamento;
	private IControlEspecialidade controlEspecialidade;
	private static Fachada instance;

	public Fachada() {
		this.controlAluno = new ControlAluno();
		this.controlFuncionario = new ControlFuncionario();
		this.controlAtividades = new ControlAtividade();
		this.controlEquipamento = new ControlEquipamento();
		this.controlEspecialidade = new ControlEspecialidade();
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
			controlEspecialidade.Conectar(conexao);
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
	public Instrutor buscaInstrutorAtividade(int codPlano,String atividade) throws SQLException,Exception {
		return controlAtividades.buscaInstrutorAtividade(codPlano, atividade);
	}

	@Override
	public Aluno buscaAlunoAtividade(String cpfAluno) throws SQLException,Exception{
		return controlAtividades.buscaAlunoAtividade(cpfAluno);
	}

	@Override
	public List<Atividade> buscaAtividadesPlano(Plano plan) throws SQLException {
		return controlAtividades.buscaAtividadesPlano(plan);
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

	@Override
	public boolean removerAluno(String parametro) throws SQLException {
		return controlAluno.removerAluno(parametro);
	}

	@Override
	public boolean atualizarManutencao(Manutencao m1) throws SQLException {
		return controlEquipamento.atualizarManutencao(m1);
	}

	@Override
	public boolean removerManutencao(String codigo) throws SQLException {
		return controlEquipamento.removerManutencao(codigo);
	}

	@Override
	public boolean cadastrarManutencao(Manutencao m1, int cod) throws SQLException {
		return controlEquipamento.cadastrarManutencao(m1, cod);
	}

	@Override
	public boolean cadastrarPlano(String cpf, String dataInicio, String dataFim) throws SQLException {
		return controlAtividades.cadastrarPlano(cpf, dataInicio, dataFim);
	}

	@Override
	public boolean inserirAtividade(int codigo, String atividade, String cpf_aluno, String cpf_instrutor) throws SQLException {
		return controlAtividades.inserirAtividade(codigo, atividade, cpf_aluno, cpf_instrutor);
	}

	@Override
	public List<Plano> buscaPlano(String cpf) throws SQLException {
		return controlAtividades.buscaPlano(cpf);
	}

	@Override
	public boolean removerAtividadePlano(Atividade a1) throws SQLException {
		return controlAtividades.removerAtividadePlano(a1);
	}

	@Override
	public boolean cadastrarEspecialidade(Especialidade especialidade) throws SQLException {
		return controlEspecialidade.cadastrarEspecialidade(especialidade);
	}

	@Override
	public List<Instrutor> buscarInstrutores(Especialidade especialidade) throws SQLException, Exception {
		return controlEspecialidade.buscarInstrutores(especialidade);
	}


}
