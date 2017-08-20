
#ALUNO
insert into aluno (cpf, nome, idade, endereco, data_nasc, regularizado) 
	values ("33333333333", "alunoTeste",20,"endTeste","1998-10-10",1);

insert into aluno (cpf, nome, idade, endereco, data_nasc, regularizado) 
	values ("55555555555", "alunoTeste2",20,"endTeste2","1996-10-10",1);

insert into aluno (cpf, nome, idade, endereco, data_nasc, regularizado) 
	values ("77777777777", "alunoTeste3",20,"endTeste","1998-10-10",1);

#FUNCIONARIO - INSTRUTOR
insert into funcionario(cpf,nome, sexo, data_contrato, salario, cnpj_filial)
	values("22222222222","funcionarioTeste","F","2000-10-10",3000.0,"11111111111111");

insert into instrutor(cpf, licenca) values ("44444444444","123456");

insert into funcionario(cpf,nome, sexo, data_contrato, salario, cnpj_filial)
	values("44444444444","funcionarioTeste2","F","2000-10-10",3000.0,"11111111111111");

insert into instrutor(cpf, licenca) values ("44444444444","123456");

insert into especialidade(descricao) value ("musculacao");
insert into especialidade(descricao) value ("boxe");
insert into especialidade(descricao) value ("natacao");
insert into especialidade(descricao) value ("zumba"); 

insert into instrutor_espec(cpf_instrutor, cod_especialidade)
	values("22222222222",1);

insert into instrutor_espec(cpf_instrutor, cod_especialidade)
	values("44444444444",1);

#FICHA_EXERCICIO E TREINO
insert into ficha_exercicio(cpf_instrutor,cpf_aluno,data_inicio,data_validade)
	values ("44444444444","33333333333","2010-10-10","2011-10-10");	


insert into ficha_exercicio(cpf_instrutor,cpf_aluno,data_inicio,data_validade)
	values ("44444444444","55555555555","2009-10-10","2010-11-09");	


insert into ficha_exercicio(cpf_instrutor,cpf_aluno,data_inicio,data_validade)
	values ("22222222222","77777777777","2011-10-10","2012-10-10");	


insert into treino(tipo,descricao,data,id_ficha)
	values ("hipertrofia","treino com carga alta","2010-10-11",1);

insert into treino(tipo,descricao,data,id_ficha)
	values ("hipertrofia","treino com carga mediana","2009-10-11",2);


#ATIVIDADE - PLANO
insert into faz_atividade(cpf_instrutor,cpf_aluno,data_atividade)
	values("44444444444","33333333333","2011-10-10");

insert into contrato(data_inicio, data_fim, vigente, duracao, cpf_aluno)
	values("2010-10-10","2011-10-10",1,12,"33333333333");

insert into plano(data_inicio,data_fim,valor_total,cod_contrato)
	values("2010-10-10","2011-10-10",600.0,1);

insert into atividade(valor, descricao)
	values(200,"musculação");

insert into atividade(valor, descricao)
	values(200,"natação");

insert into atividade(valor, descricao)
	values(200,"boxe");

insert into plano_atividade(cod_plano,id_atividade)
	values(1,1);
insert into plano_atividade(cod_plano,id_atividade)
	values(1,2);
insert into plano_atividade(cod_plano,id_atividade)
	values(1,3);	


#EQUIPAMENTO - MANUTENCAO
insert into equipamento(tipo_equip,descricao,cnpj_filial)
	values("maquina supino", "máquina de supino articulado","11111111111111");

insert into equipamento(tipo_equip,descricao,cnpj_filial)
	values("smith", "máquina de agachamento","11111111111111");

insert into equipamento(tipo_equip,descricao,cnpj_filial)
	values("leg 45", "","11111111111111");



