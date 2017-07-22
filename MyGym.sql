# Definição do banco
CREATE SCHEMA MYGYM;

# Definição de tabelas

CREATE TABLE matriz (
cnpj_matriz varchar(14) not null,
razao_social varchar(255) not null,
endereco varchar(255) not null,
telefone varchar(11) not null,
unique(cnpj_matriz),
primary key(cnpj)
);

CREATE TABLE filial(
cnpj_filial varchar(14) not null,
razao_social varchar(255) not null,
telefone varchar(11) not null,
cnpj_matriz varchar(14) not null,
unique(cnpj_filial),
primary key(cnpj_filial,cnpj_matriz),
foreign key(cnpj_matriz) references matriz(cnpj_matriz)
);

CREATE TABLE equipamento(
cod_equip int not null auto_increment,
tipo_equip varchar(100),
descricao varchar(255),
cnpj_filial varchar(14) not null,
primary key(codigo_equip),
foreign key(cnpj_filial) references filial(cnpj_filial)
);

CREATE TABLE manutencao(
cod_manutencao int not null auto_increment,
valor int not null,
protocolo varchar(100),
descricao varchar(255),
data_manutencao date,
data_devolucao date,
primary key(cod_manutencao)
);

CREATE TABLE sofreu_manutencao(
cod_equip int not null,
cod_manutencao int not null,
data_manutencao date,
primary key (cod_equip, cod_manutencao, data_manutencao),
foreign key (cod_equip) references equipamento(cod_equip),
foreign key (cod_manutencao) references manutencao(cod_manutencao),
foreign key (data_manutencao) references manutencao(data_manutencao)
);

CREATE TABLE funcionario(
cpf varchar(11) not null,
nome varchar(255) not null,
sexo varchar(10),
data_contrato date,
salario decimal(10,2),
cnpj_filial varchar(14) not null,
primary key (cpf),
foreign key (cnpj_filial) references filial(cnpj_filial)
); 

CREATE TABLE dia_semana(
id int not null auto_increment,
descricao varchar(20),
primary key(id)
);

CREATE TABLE periodo(
id int not null auto_increment,
descricao varchar(10),
primary key(id)
);

CREATE TABLE jornada(
cpf_funcionario varchar(11) not null,
id_dia int not null,
id_periodo int not null,
primary key(cpf_funcionario,id_dia,id_periodo),
foreign key(cpf_funcionario) references funcionario(cpf),
foreign key(id_dia) references dia_semana(id),
foreign key(id_periodo) references periodo(id)
);

CREATE TABLE gerente(
cpf varchar(11) not null,
primary key (cpf),
foreign key (cpf) references funcionario(cpf)
);

CREATE TABLE recepcionista(
cpf varchar(11) not null,
primary key(cpf),
foreign key(cpf) references funcionario(cpf)
);

CREATE TABLE servico(
cpf varchar(11) not null,	
tipo_servico varchar(255),
area varchar(255),
primary key(cpf),
foreign key(cpf) references funcionario(cpf)
);

CREATE TABLE vendedor(
cpf varchar(11) not null,
taxa_comissao decimal(1,2),
primary key(cpf),
foreign key(cpf) references funcionario(cpf)
);

CREATE TABLE medico(
cpf varchar(11) not null,	
especializacao varchar(20),
crm varchar(20),
primary key(cpf),
foreign key(cpf) references funcionario(cpf)
);

CREATE TABLE instrutor(
cpf varchar(11) not null,
licenca varchar(20),
primary key(cpf),
foreign key(cpf) references funcionario(cpf),
);

CREATE TABLE especialidade(
cod int not null auto_increment,
descricao varchar(100),
primary key(cod)
);

CREATE TABLE instrutor_espec(
cpf_instrutor varchar(11) not null,
cod_especialidade int,
primary key(cpf_instrutor,cod_especialidade),
foreign key(cpf_instrutor) references instrutor(cpf),
foreign key(cod_especialidade) references especialidade(cod)
);

CREATE TABLE aluno(
cpf varchar(11) not null,
nome varchar(255) not null,
idade int not null,
edereco varchar(255),
data_nasc date,
regularizado boolean,
primary key(cpf) 
);

CREATE TABLE telefone(
cpf varchar(11) not null,
telefone varchar(11) not null,
primary key(cpf, telefone),
foreign key(cpf) references aluno(cpf)
);

CREATE TABLE dependente(
sequencial int not null,
nome varchar(255) not null,
data_nasc date,
cpf_responsavel varchar(11) not null,
primary key(sequencial,cpf_responsavel),
foreign key(cpf_responsavel) references aluno(cpf)
);

CREATE TABLE contrato(
codigo int not null auto_increment,
data_inicio date not null,
data_fim date not null,
vigente boolean not null,
duracao int,
cpf_aluno varchar(11) not null,
primary key (codigo),
foreign key (cpf_aluno) references aluno()cpf 
);

CREATE TABLE plano(
codigo int not null auto_increment,
data_inicio date not null,
data_fim date not null,
valor_total decimal(10,2),
cod_contrato int not null,
primary key(codigo),
foreign key(cod_contrato)references contrato(codigo)
);

CREATE TABLE fatura(
codigo int not null auto_increment,
valor_total decimal(10,2) not null,
num_parcelas int not null,
data_vencimento date not null,
quitada boolean not null,
cod_plano int not null,
primary key(codigo),
foreign key(cod_plano) references plano(codigo) 
);

CREATE TABLE forma_pagamento(
id int not null auto_increment,
descricao varchar(255) not null,
primary key(id)
);

CREATE TABLE pagamento(
codigo int not null auto_increment,
valor_parcela decimal(10,2) not null,
data date not null,
cod_fatura int not null,
forma_pag int not null,
primary key(codigo, cod_fatura),
foreign key(cod_fatura) references fatura(codigo),
foreign key(forma_pag) references forma_pagamento(id) 
);

CREATE TABLE atividade(
id int not null auto_increment,
valor decimal(10,2) not null,
descricao varchar(255),
primary key(id)
);

CREATE TABLE horario_atividade(
id_atividade int not null,
horario varchar (100) not null,
primary key (id_atividade,horario),
foreign key (id_atividade) references atividade(id) 
);

CREATE TABLE turma_atividade(
id_atividade int not null,
turma varchar(20) not null,
primary key(id_atividade,turma),
foreign key(id_atividade) references atividade(id)
);

CREATE TABLE plano_atividade(
cod_plano int not null,
id_atividade int not null,
primary key(cod_plano, id_atividade),
foreign key(cod_plano) references plano(codigo),
foreign key(id_atividade) references atividade(id)  
);

CREATE TABLE faz_atividade(
cpf_instrutor varchar(11) not null,
cpf_aluno varchar(11) not null,
data_atividade date not null,
primary key(cpf_instrutor,cpf_aluno,data_atividade),
foreign key(cpf_instrutor) references instrutor(cpf),
foreign key(cpf_aluno) references aluno(cpf)
);

CREATE TABLE exame(
cpf_medico varchar(11) not null,
cpf_aluno varchar(11) not null,
data_exame varchar(11) not null,
primary key(cpf_medico,cpf_aluno,data_exame),
foreign key(cpf_medico) references medico(cpf),
foreign key(cpf_aluno) references aluno(cpf)
);

CREATE TABLE result_exame(
sequencial int not null auto_increment,
tipo varchar(20) not null,
patologia varchar(100) not null,
parecer varchar(255) not null,
observacao varchar(255),
cpf_medico varchar(11) not null,
cpf_aluno varchar(11) not null,
data_exame date not null,
primary key (sequencial),
foreign key(cpf_medico) references medico(cpf),
foreign key(cpf_aluno) references aluno(cpf),
foreign key(data_exame) references exame(data_exame)
);

CREATE TABLE ficha_acompanhamento(
data date not null,
peso decimal(3,1) not null,
altura decimal(1,2) not null,
imc decimal(3,2) not null,
lesao varchar(150),
data_lesao date,
medida_extra_1 decimal(3,2),
medida_extra_2 decimal(3,2),
cpf_aluno varchar(11) not null,
primary key(data, cpf_aluno),
foreign key (cpf_aluno) references aluno(cpf)
);

CREATE TABLE ficha_exercicio(
cpf_instrutor varchar(11) not null,
cpf_aluno varchar(11) not null,
data_inicio date not null,
data_validade date,
primary key (cpf_instrutor, cpf_aluno, data_inicio),
foreign key(cpf_instrutor) references instrutor(cpf),
foreign key(cpf_aluno) references aluno(cpf),
);

CREATE TABLE treino(
id int not null auto_increment,
tipo varchar(150),
descricao varchar(255),
data date,
cpf_instrutor varchar(11),
cpf_aluno varchar(11),
primary key(id),
foreign key(data) references ficha_exercicio(data_inicio),
foreign key(cpf_instrutor) references instrutor(cpf),
foreign key(cpf_aluno) references aluno(cpf),
);

CREATE TABLE tipo_exercicio(
id int not null auto_increment,
descricao varchar(255),
primary key(id)
);

CREATE TABLE exercicio(
id int not null auto_increment,
nome varchar(255) not null,
maquina varchar(150) not null,
musculo varchar(150) not null,
descricao varchar(255),
tipo int not null,
primary key(id),
foreign key(tipo) references tipo_exercicio(id)
);


