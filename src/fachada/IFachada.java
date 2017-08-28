package fachada;

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

public interface IFachada {

	boolean CadastrarAluno(Aluno aluno) throws SQLException;
	boolean atualizarAluno(Aluno aluno) throws SQLException;
	List<Aluno> buscaAluno(String parametro) throws SQLException,Exception;
	boolean CadastrarDependente(Dependente dependente)throws SQLException;
	boolean removerAluno(String parametro) throws SQLException;
	
	Instrutor buscaInstrutorAtividade(int codPlano, String atividade) throws SQLException,Exception;
	Aluno buscaAlunoAtividade(String cpfAluno)throws SQLException,Exception;
	List<Atividade> buscaAtividadesPlano(Plano plan) throws SQLException;
	boolean cadastrarPlano(String cpf, String dataInicio, String dataFim) throws SQLException;
	boolean inserirAtividade(int codigo, String atividade) throws SQLException;
	List<Plano> buscaPlano(String cpf) throws SQLException;
	boolean removerAtividadePlano(Atividade a1) throws SQLException;
	
	List<Equipamento> buscaEquip(Equipamento e) throws SQLException;
	List<Manutencao> buscaManutencao(String idEquip)throws SQLException;
	boolean atualizarManutencao(Manutencao m1) throws SQLException;
	boolean removerManutencao(String codigo)throws SQLException;
	boolean cadastrarEquip(Equipamento e) throws SQLException;
	boolean cadastrarManutencao(Manutencao m1, int cod) throws SQLException;
	
	boolean cadastrarInstrutor(Instrutor instrutor) throws SQLException;
	
	boolean cadastrarEspecialidade(Especialidade especialidade) throws SQLException;
	List<Instrutor>buscarInstrutores(Especialidade especialidade) throws SQLException, Exception;
	
	void conectar(String user, String senha)throws Exception;
}
