#Alunos

delimiter \\
create procedure atualizaAluno( in novoNome varchar(75), in NovaIdade int, in novoEnd varchar(100),in NovaData date, in NovoReg tinyint(1),in cpfAluno char(11))
	begin
		START TRANSACTION;
		update aluno set nome = novoNome , idade = NovaIdade, endereco = novoEnd,data_nasc = NovaData, regularizado = NovoReg where cpf = cpfAluno;
			COMMIT;
	end	\\

#Equipamento e manutencao

delimiter \\
create procedure atualizaManutencao(in codigo int,in novoValor double, in novoProtocolo varchar(100), in novaDesc varchar(100), in novaDataM date, in novaDataD date)
	begin
		START TRANSACTION;
		update manutencao set valor = novoValor, protocolo = novoProtocolo, descricao = novaDesc, data_manutencao = novaDataM, data_devolucao = novaDataD 
			where cod_manutencao = codigo;
		COMMIT;
	end \\	