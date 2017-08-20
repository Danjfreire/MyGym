create view relatorio_ficha as
select A.nome as Nome_Aluno, F.nome as Nome_Instrutor, E.descricao as Especialidade, T.tipo as TipoTreino, FE.data_inicio
from
	aluno as A, funcionario as F, instrutor as I, especialidade as E, treino as T, ficha_exercicio as FE, instrutor_espec as IE
where
	A.cpf = FE.cpf_aluno and
	F.cpf = FE.cpf_instrutor and
	FE.cpf_instrutor = I.cpf and
	I.cpf = IE.cpf_instrutor and
	IE.cod_especialidade = E.cod and
	FE.id_ficha = T.id_ficha and
	FE.data_inicio > "2005-10-10" and
	FE.data_inicio < "2015-10-10";

