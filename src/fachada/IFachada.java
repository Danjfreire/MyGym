package fachada;

import java.sql.SQLException;
import java.util.List;

import Negocio.beans.Aluno;
import Negocio.beans.Atividade;
import Negocio.beans.Dependente;
import Negocio.beans.Equipamento;
import Negocio.beans.Instrutor;
import Negocio.beans.Manutencao;

public interface IFachada {

	boolean CadastrarAluno(Aluno aluno) throws SQLException;
	boolean atualizarAluno(Aluno aluno) throws SQLException;
	List<Aluno> buscaAluno(String parametro) throws SQLException,Exception;
	boolean CadastrarDependente(Dependente dependente)throws SQLException;
	
	Instrutor buscaInstrutorAtividade(String cpfAluno) throws SQLException,Exception;
	Aluno buscaAlunoAtividade(String cpfAluno)throws SQLException,Exception;
	List<Atividade> buscaAtividadesPlano(String cpfAluno) throws SQLException;
	
	List<Equipamento> buscaEquip(Equipamento e) throws SQLException;
	List<Manutencao> buscaManutencao(String idEquip)throws SQLException;
	boolean cadastrarEquip(Equipamento e) throws SQLException;
	
	boolean cadastrarInstrutor(Instrutor instrutor) throws SQLException;
	
	void conectar(String user, String senha)throws Exception;
}
