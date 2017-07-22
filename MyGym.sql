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



