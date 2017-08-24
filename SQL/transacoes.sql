delimiter \\
create procedure atualizaAluno( in novoNome varchar(75), in NovaIdade int, in novoEnd varchar(100),in NovaData date, in NovoReg tinyint(1),in cpfAluno char(11))
	begin
		START TRANSACTION;
		update aluno set nome = novoNome , idade = NovaIdade, endereco = novoEnd,data_nasc = NovaData, regularizado = NovoReg where cpf = cpfAluno;
			COMMIT;
	end	\\