-- https://pt.wikipedia.org/wiki/Lista_de_bancos_do_Brasil
drop database node_bank;

create database node_bank;

use node_bank;

create table bank (
  id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  digit INT(6) NOT NULL,
  sigla VARCHAR(15) NOT NULL,
  name VARCHAR(40) NOT NULL,
  description VARCHAR(1000) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5;

insert into bank (digit, sigla, name, description) values (1,	'BB'	'Banco do Brasil', 'Banco do Brasil S.A. é uma instituição financeira brasileira, constituída na forma de sociedade de economia mista, com participação da União brasileira em 68,7% das ações.');
insert into bank (digit, sigla, name, description) values (2, 'BACEN', 'Banco Central do Brasil', 'O Banco Central do Brasil é autarquia federal integrante do Sistema Financeiro Nacional, sendo vinculado ao Ministério da Fazenda do Brasil. Criado em 31 de dezembro de 1964 pela da Lei nº 4.595.');
insert into bank (digit, sigla, name, description) values (7 'BNDES', 'Banco Nacional de Desenvolvimento Econômico e Social', 'O Banco Nacional de Desenvolvimento Econômico e Social (BNDES) é uma empresa pública federal, com sede no Rio de Janeiro, e cujo principal objetivo é financiar de longo prazo a realização de investimentos em todos os segmentos da economia, de âmbito social, regional e ambiental.');
insert into bank (digit, sigla, name, description) values (104, 'CEF', 'Caixa Econômica Federal', 'Caixa Econômica Federal (CEF), também conhecida como Caixa Econômica ou apenas Caixa é uma instituição financeira, sob a forma de empresa pública do governo federal brasileiro, com patrimônio próprio e autonomia administrativa com sede em Brasília (DF) e com filiais em todo o território nacional. É uma pessoa jurídica autônoma, vinculada ao Ministério da Fazenda.');
insert into bank (digit, sigla, name, description) values (745,	'Citibank', 'Banco Citibank', 'O Citibank é a divisão de consumo da multinacional de serviços financeiros Citigroup. Foi fundado em 1812 como o "Banco da Cidade de Nova York", mais tarde "First National City Bank of New York". Em março de 2010, o Citigroup era o maior holding bancário nos Estados Unidos por ativos totais, seguido pelo Bank of America e pelo JP Morgan Chase.');
insert into bank (digit, sigla, name, description) values (479	'Itaú' ,'Itaú Unibanco', 'Itaú, cujo nome oficial é Itaú Unibanco S.A, é um banco brasileiro sediado em São Paulo, braço do Itaú Unibanco Holding S.A. voltado ao setor de varejo e múltiplo, que oferece serviços de finanças e seguros a dezenas de milhões de clientes.');
insert into bank (digit, sigla, name, description) values (033,	'Santander', 'Banco Santander', 'Grupo Santander é um grupo bancário global, liderado pelo Banco Santander S.A., o maior banco da zona euro. Tem sua origem em Santander, Cantábria, Espanha.');
insert into bank (digit, sigla, name, description) values (237, 'Bradesco', 'Bradesco', 'Bradesco é um banco brasileiro e atualmente é o segundo maior banco privado do Brasil, cresceu principalmente através de fusões e aquisições.');
insert into bank (digit, sigla, name, description) values (399, 'HSBC', 'HSBC Bank Brasil', 'HSBC (acrônimo do inglês Hong Kong and Shanghai Banking Corporation, traduzido em português: "Corporação Bancária de Hong Kong e Xangai"), oficialmente HSBC Holdings plc é um banco global britânico. Sua sede fica em Londres.');
