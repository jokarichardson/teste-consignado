-- Crédito Contratado
DROP TABLE IF EXISTS consignado_contratado;

CREATE TABLE consignado_contratado (
  id                         INT         PRIMARY KEY AUTO_INCREMENT,
  cpf_cliente                BIGINT, 
  valor_contratado           DECIMAL, 
  quantidade_parcelas        INT,
  data_vencimento_parcela    VARCHAR(02), 
  data_inicio_contrato       DATE,
  data_encerramento_contrato DATE,
  numero_beneficio           INT
);

