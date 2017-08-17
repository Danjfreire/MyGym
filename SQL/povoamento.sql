#POVOAMENTO DE TABELAS A PARTIR DE ARQUIVOS .CSV
#DESCONSIDERA FOREIGN KEYS
#É NECESSÁRIO MODIFICAR O CAMINHO PARA SUA PASTA LOCAL

SET FOREIGN_KEY_CHECKS = 0;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\ALUNO.csv"
INTO TABLE aluno
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\ATIVIDADE.csv"
INTO TABLE atividade
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\CATEGORIA_PRODUTO.csv"
INTO TABLE categoria_produto
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\CLIENTE.csv"
INTO TABLE cliente
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\COMPRA.csv"
INTO TABLE compra
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\CONTRATO.csv"
INTO TABLE contrato
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\DEPENDENTE.csv"
INTO TABLE dependente
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\DIA_SEMANA.csv"
INTO TABLE dia_semana
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\EQUIPAMENTO.csv"
INTO TABLE equipamento
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\ESPECIALIDADE.csv"
INTO TABLE especialidade
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\ESTOQUE.csv"
INTO TABLE estoque
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\EXAME.csv"
INTO TABLE exame
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\EXERCICIO.csv"
INTO TABLE exercicio
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\FATURA.csv"
INTO TABLE fatura
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\FAZ_ATIVIDADE.csv"
INTO TABLE faz_atividade
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\FICHA_ACOMPANHAMENTO.csv"
INTO TABLE ficha_acompanhamento
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\FICHA_EXERCICIO.csv"
INTO TABLE ficha_exercicio
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\FILIAL.csv"
INTO TABLE filial
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\FORMA_PAGAMENTO.csv"
INTO TABLE forma_pagamento
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\FORNECEDOR.csv"
INTO TABLE fornecedor
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\FUNCIONARIO.csv"
INTO TABLE funcionario
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\GERENTE.csv"
INTO TABLE gerente
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\HISTORICO_COMPRA.csv"
INTO TABLE historico_compra
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\HORARIO_ATIVIDADE.csv"
INTO TABLE horario_atividade
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\INSTRUTOR.csv"
INTO TABLE instrutor
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\INSTRUTOR_ESPEC.csv"
INTO TABLE instrutor_espec
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\ITEM_COMPRA.csv"
INTO TABLE item_compra
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\JORNADA.csv"
INTO TABLE jornada
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\MANUTENCAO.csv"
INTO TABLE manutencao
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\MATRIZ.csv"
INTO TABLE matriz
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\MEDICO.csv"
INTO TABLE medico
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\PAGAMENTO.csv"
INTO TABLE pagamento
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\PERIODO.csv"
INTO TABLE periodo
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\PLANO.csv"
INTO TABLE plano
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\PLANO_ATIVIDADE.csv"
INTO TABLE plano_atividade
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\PRODUTO.csv"
INTO TABLE produto
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\PRODUTO_ESTOQUE.csv"
INTO TABLE produto_estoque
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\RECEPCIONISTA.csv"
INTO TABLE recepcionista
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\RESULT_EXAME.csv"
INTO TABLE result_exame
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\SERVICO.csv"
INTO TABLE servico
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\SOFREU_MANUTENCAO.csv"
INTO TABLE sofreu_manutencao
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\TELEFONE.csv"
INTO TABLE telefone
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\TIPO_EXERCICIO.csv"
INTO TABLE tipo_exercicio
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\TREINO.csv"
INTO TABLE treino
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\TURMA_ATIVIDADE.csv"
INTO TABLE turma_atividade
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

LOAD DATA LOCAL INFILE "C:\\Users\\Daniel\\Git\\MyGym\\DadosPovoamento\\VENDEDOR.csv"
INTO TABLE vendedor
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;

SET FOREIGN_KEY_CHECKS = 1;