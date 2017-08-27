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
create procedure inserirEquipamento(in tipo varchar(100),in descr varchar(100), in cnpj char(14))
	begin
		START TRANSACTION;
		insert into equipamento (tipo_equip, descricao, cnpj_filial) values (tipo, descr, cnpj);
		COMMIT;
	end \\

delimiter \\
create procedure inserirManutencao( in novoValor double, in novoProtocolo varchar(100), in novaDesc varchar(100), in novaDataM date, in novaDataD date, in codEquip int)
	begin
		declare cod int;
		START TRANSACTION;
			insert into manutencao(valor, protocolo, descricao, data_manutencao, data_devolucao)
			values(novoValor,novoProtocolo,novaDesc, novaDataM, novaDataD); 
		COMMIT;

		START TRANSACTION;
			set cod = (select  MAX(cod_manutencao) from manutencao);
			insert into sofreu_manutencao(cod_equip, cod_manutencao, data_manutencao) values (codEquip, cod, novaDataM);
		COMMIT;
	end \\

delimiter \\
create procedure atualizaManutencao(in codigo int,in novoValor double, in novoProtocolo varchar(100), in novaDesc varchar(100), in novaDataM date, in novaDataD date)
	begin
		START TRANSACTION;
		update manutencao set valor = novoValor, protocolo = novoProtocolo, descricao = novaDesc, data_manutencao = novaDataM, data_devolucao = novaDataD 
			where cod_manutencao = codigo;
		update sofreu_manutencao set data_manutencao = novaDataM where cod_manutencao = codigo;
		COMMIT;
	end \\	

delimiter \\
create procedure removerManutencao(in codigo int)
	begin
		START TRANSACTION;
		delete from manutencao where cod_manutencao = codigo;
		delete from sofreu_manutencao where cod_manutencao = codigo;
		COMMIT;
	end \\