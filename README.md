<p align="center">
#CONSIGNADO
Aplicação de Demonstração para Crédito Consignado
Copyright © 2020 Richardson Software Ltda.
</p>

Essa aplicação tem o intuito de apresentar um CRUD simples, que realiza busca de ofertas de crédito consignado, respeitando a nova <b>Instrução Normativa nº 100, do Instituto Nacional do Seguro Social, de 28/12/2018</b>.

## Introdução

Com a nova Instrução Normativa, os bancos somente poderão oferecer crédito consignado, aos aposentados e pensionistas, mediante as regras abaixo:

1. Regra nº 1

* Todo cidadão que se aposentar a partir de 30/03/2019, terá seu benefício bloqueado automaticamente, pelo período de 90 dias, a partir da data de concessão pelo INSS (Data de Despacho do Benefício - DDB).

2. Regra nº 2

* Após 90 dias da Data de Despacho do Benefício, o aposentado ou pensionista poderá contratar um crédito consignado. Para isto, é necessário que um termo de pré-autorização seja assinado pelo beneficiário para que a instituição financeira possa solicitar o acesso às informações do benefício ao INSS. Com a aprovação, pelo INSS, do termo, será considerado mais um prazo de 90 dias a partir da Data de Despacho do Benefício para que seja permitido aos bancos ofertarem crédito consignado.

3. Regra nº 3

* Passados 180 dias da Data de Despacho do Benefício (DDB), 90 dias do bloqueio mais 90 dias para frente, os bancos podem iniciar o processo de oferta de crédito consignado aos seus clientes aposentados e pensionistas, desde que o intervalo entre a Data de Despacho do Benefício, e a Data de Autorizaão da Consulta, seja de, no mínimo, 90 dias (DDB - DAC >= 90).

## Tecnologias Utilizadas

* Java (JDK 13);
* Spring Boot;
* Maven;
* REST;
* H2 In-memory Database

## Operações:

* recuperarOfertas (/consignado/recuperarOfertas):

  Essa operação realiza a busca dos Beneficiarios INSS cuja Data de Despacho do Benefício (DDB) seja igual ou inferior à data corrente subtraída de 180 dias;

  * Endpoint: /consignado/recuperarOfertas
  * Método: GET
  * Response: Listagem de BeneficiarioDTO

* recuperarOfertasAutorizadas:

  Essa operação realiza a busca dos Beneficiarios INSS cuja Data de Despacho do Benefício (DDB) seja igual ou inferior à data corrente subtraída de 180 dias, porém haja assinatura da pré-autorização (Data de Autorização da Consulta - DAC), e a diferença entre a DAC e a DDB seja de, no mínimo, 90 dias;

  * Endpoint: /consignado/recuperarOfertasAutorizadas
  * Método: GET
  * Response: Listagem de BeneficiarioDTO

* armazenarCreditoContratado()

  * Endpoint: /consignado
  * Método: POST
  * Request: CreditoContratadoDTO
  * Response: CreditoContratadoDTO persistido

## Objetos:

* BeneficiarioDTO:

```javascript
  {
    "cpfCliente": "String",
    "nomeCliente": "String",
    "margemDisponivel": Double,
    "numeroBeneficio": Integer,
    "dataAutorizacaoConsulta": "String",
    "dataNascimentoCliente": "String",
    "dataDespachoBeneficio": "String"
  }
```
* CreditoContratadoDTO:

```javascript
  {
    "id": Integer,
    "cpfCliente": "String",
    "dataEnceramentoContrato": "String",
    "dataInicioContrato": "String",
    "dataVencimentoParcela": "String",
    "numeroBeneficio": Integer,
    "quantidadeParcelas": Integer,
    "valorContratado": Integer
  }
```

## Execução em Nuvem

* Acessar a URL [https://teste-consignado.herokuapp.com/](https://teste-consignado.herokuapp.com/), via Postman ou via navegador. Em sendo acessada via navegador, será apresentada a interface do Swagger com as operações disponíveis.

## Execução Local

* Utilizando um terminal (Command Prompt do Windows, Git Bash ou terminal do Linux), acessar o diretório raiz da aplicação (teste-consignado);

* Maven:

  * Digitar o comando:

    ```
    mvn spring-boot:run
    ```
  
  * Acessar localhost:8080 no navegador de preferência;

* Executando via jar:

  * Realizar o build do projeto com sua ferramenta preferencial;
  * Digitar o comando:

    ```
    java -jar target/teste-consignado-1.0.0-SNAPSHOT.jar
    ```

  * Acessar localhost:8080 no navegador de preferência;