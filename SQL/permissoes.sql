CREATE USER 'gerente'@'localhost' IDENTIFIED BY 'senha1';
GRANT ALL PRIVILEGES ON MyGym.* TO 'gerente'@'localhost';

CREATE USER 'vendedor'@'localhost' IDENTIFIED BY 'senha2';
GRANT SELECT ON MyGym.item_compra TO 'vendedor'@'localhost';
GRANT SELECT ON MyGym.produto_estoque TO 'vendedor'@'localhost';
GRANT SELECT ON MyGym.cliente TO 'vendedor'@'localhost';

CREATE USER 'recepcionista'@'localhost' IDENTIFIED BY 'senha3';
GRANT SELECT ON MyGym.aluno TO 'recepcionista'@'localhost';
GRANT INSERT ON MyGym.aluno TO 'recepcionista'@'localhost'; 
GRANT SELECT ON MyGym.intrutor TO 'recepcionista'@'localhost';
GRANT SELECT ON MyGym.medico TO 'recepcionista'@'localhost';
GRANT SELECT ON MyGym.exame TO 'recepcionista'@'localhost';
GRANT INSERT ON MyGym.exame TO 'recepcionista'@'localhost';
GRANT SELECT ON MyGym.aluno TO 'recepcionista'@'localhost';
GRANT SELECT ON MyGym.treino TO 'recepcionista'@'localhost';
GRANT SELECT ON MyGym.ficha_exercicio TO 'recepcionista'@'localhost';
GRANT SELECT ON MyGym.turma_atividade TO 'recepcionista'@'localhost';
GRANT SELECT ON MyGym.atividade TO 'recepcionista'@'localhost';
GRANT SELECT ON MyGym.plano TO 'recepcionista'@'localhost';
GRANT INSERT ON MyGym.plano TO 'recepcionista'@'localhost';
GRANT SELECT ON MyGym.fatura TO 'recepcionista'@'localhost';
GRANT SELECT ON MyGym.pagamento TO 'recepcionista'@'localhost';
