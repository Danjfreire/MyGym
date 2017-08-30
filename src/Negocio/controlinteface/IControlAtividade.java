package Negocio.controlinteface;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Negocio.beans.Aluno;
import Negocio.beans.Atividade;
import Negocio.beans.Instrutor;
import Negocio.beans.Plano;

public interface IControlAtividade {

	void Conectar(Connection conexao)throws SQLException;
	Instrutor buscaInstrutorAtividade(int codPlano, String atividade) throws SQLException,Exception;
	Aluno buscaAlunoAtividade(String cpfAluno)throws SQLException, Exception;
	List<Atividade> buscaAtividadesPlano(Plano plan) throws SQLException;
	boolean cadastrarPlano(String cpf, String dataInicio, String dataFim) throws SQLException;
	boolean inserirAtividade(int codigo, String atividade, String cpf_aluno,String cpf_instrutor) throws SQLException;
	List<Plano> buscaPlano(String cpf) throws SQLException;
	boolean removerAtividadePlano(Atividade a1) throws SQLException;
	
}
