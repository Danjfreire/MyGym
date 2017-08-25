#FUNCTIONS

delimiter |
create function parecerAluno(numeroExame int)
returns varchar(100)
deterministic
begin	
	declare parecerdoaluno varchar(100);
	set parecerdoaluno = (select parecer from mygym.result_exame
	where id_exame = numeroExame);
	return parecerdoaluno;
end |


delimiter |
create function regularizadoAluno(cpfAluno char)
return varchar(100)
deterministic
begin
	declare situacaoAluno varchar(100);
	set situacaoAluno = (select quitada from mygym.fatura where cpfAluno = contrato.cpf);
	return situacaoAluno;
end |



#PROCEDURES

delimiter \\
create procedure criaFicha(in numcpf char(11), in dataAtual date, in pesoAtual decimal(3,1), in alturaAtual decimal(4,2))
begin
	declare auximc decimal (5,2);
	declare aux decimal (3,2);

	set aux = alturaAtual * alturaAtual;
	set auximc = pesoAtual/aux;

	insert into ficha_acompanhamento(data, peso, altura, imc, cpf_aluno)value(dataAtual,pesoAtual, alturaAtual, auximc, numcpf);
end \\



#TRIGGERS
delimiter \\
create trigger valor_total_compra
after insert on item_compra
for each row
begin
	declare auxqtd int;
	declare auxpreco decimal(4,2);
	set auxqtd = new.quantidade;
	set auxpreco = new.valor_unitario;
	update compra set valor_total = (auxqtd * auxpreco) where id = new.id_compra;
end \\

delimiter \\
create trigger valor_parcial_fatura
after insert on fatura
for each row
begin
	declare auxparcelas int;
	declare auxvalor decimal(10,2);
	set auxparcelas = new.num_parcelas;
	set auxvalor_total = new.valor_total;
	update fatura set valor_parcial = (auxvalor_total / auxparcelas) where codigo = new.codigo;
end \\

