
insert into aluno (cpf, nome, idade, endereco, data_nasc, regularizado) 
	values ("33333333333", "alunoTeste",20,"endTeste","1998-10-10",1);

insert into funcionario(cpf,nome, sexo, data_contrato, salario, cnpj_filial)
	values("44444444444","funcionarioTeste","F","2000-10-10",3000.0,"11111111111111");

insert into instrutor(cpf, licenca) values ("44444444444","123456");

insert into faz_atividade(cpf_instrutor,cpf_aluno,data_atividade)
	values("44444444444","33333333333","2011-10-10");		