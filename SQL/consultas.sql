#RETORNA OS NOMES DOS FUNCIONARIO QUE TRABALHAM NA SEGUNDA FEIRA NO PERIODO DA TARDE
select F.nome 
from funcionario as F, dia_semana as D, periodo as P , jornada as J
where
	F.cpf = J.cpf_funcionario and
	J.id_dia = D.id and
	J.id_periodo = P.id and
	D.descricao = "Segunda" and
	P.descricao = "Tarde";

#RETORNA OS NOMES DOS ALUNOS QUE TIVERAM FICHAS CRIADAS ANTES DE 2017
select distinct A.nome
from aluno as A, ficha_exercicio as F
where 
	A.cpf = F.cpf_aluno and
	F.data_inicio < "2017-01-01";

#RETORNA TODOS OS NOMES DE TODOS OS INSTRUTORES
select F.nome 
from funcionario as F, instrutor as I
where 
	F.cpf = I.cpf;



	