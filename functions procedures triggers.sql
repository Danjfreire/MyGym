##FUNCTIONS

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

##PROCEDURES

delimiter \\
create procedure criaFicha(in numcpf char(11), in dataAtual date, in pesoAtual decimal(3,1), in alturaAtual decimal(4,2))
begin
	declare auximc decimal (5,2);
	declare aux decimal (3,2);

	set aux = alturaAtual * alturaAtual;
	set auximc = pesoAtual/aux;

	insert into ficha_acompanhamento(data, peso, altura, imc, cpf_aluno)value(dataAtual,pesoAtual, alturaAtual, auximc, numcpf);
end \\
