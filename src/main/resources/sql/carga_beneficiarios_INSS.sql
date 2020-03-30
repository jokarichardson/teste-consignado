-- Beneficiários INSS
DROP TABLE IF EXISTS beneficiarios_INSS;

CREATE TABLE beneficiarios_INSS (
  cpf_cliente                   BIGINT       PRIMARY KEY, 
  nome_cliente                  VARCHAR(100), 
  margem_disponivel_contratacao DECIMAL,
  numero_beneficio              INT,
  data_autorizacao_consulta     DATE,
  data_nascimento_cliente       DATE,
  data_despacho_beneficio       DATE
);

INSERT
  INTO beneficiarios_INSS 
VALUES (11894307208, 'CLIENTE PROPOSTA DDB ANTERIOR A 180 DIAS, DAC SUPERIOR A 90 DIAS', 0.2, 12345678, '2019-12-02', '1952-09-01', '2019-09-01');

INSERT
  INTO beneficiarios_INSS 
VALUES (4835706056, 'CLIENTE PROPOSTA AUTORIZADA', 0.3, 87654321, '2020-01-02', '1958-07-20', '2019-08-21');

INSERT
  INTO beneficiarios_INSS 
VALUES (27864377840, 'CLIENTE NÃO EMITIU AUTORIZAÇÃO PARA CONSULTA DADOS', 0.32, 98765432, null, '1950-12-21', '2019-07-01');

INSERT
  INTO beneficiarios_INSS 
VALUES (62659343179, 'CLIENTE DDB ANTERIOR A 180 DIAS, DDB - DAC INFERIOR A 90 DIAS', 0.15, 32165498, '2020-02-01', '1951-10-11', '2019-12-01');